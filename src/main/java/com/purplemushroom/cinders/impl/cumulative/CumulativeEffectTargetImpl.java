package com.purplemushroom.cinders.impl.cumulative;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectInstance;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import com.purplemushroom.cinders.api.cumulative.TargetAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.neoforged.neoforge.attachment.AttachmentSyncHandler;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//TODO optimize packet sending?
public class CumulativeEffectTargetImpl implements CumulativeEffectTarget {

    private final IAttachmentHolder attachmentHolder;
    private final List<CumulativeEffectModifierHolder> modifierHolders;
    private final List<MutableCumulativeEffectInstance> effects;
    private final TargetAccess targetAccess;

    public static CumulativeEffectTarget make(IAttachmentHolder attachmentHolder) {
        return new CumulativeEffectTargetImpl(attachmentHolder);
    }

    public CumulativeEffectTargetImpl(IAttachmentHolder attachmentHolder) {
        this.attachmentHolder = attachmentHolder;
        this.modifierHolders = new ArrayList<>();
        this.effects = new ArrayList<>();
        this.targetAccess = TargetAccess.of(attachmentHolder);
    }

    public void addModifierHolder(CumulativeEffectModifierHolder modifierHolder) {
        modifierHolders.add(modifierHolder);
    }

    @Override
    public boolean addEffectPoints(CumulativeEffect effect, int points) {
        if (effect.isInvincible(this)) {
            return false;
        }

        Iterator<MutableCumulativeEffectInstance> iterator = effects.iterator();
        while (iterator.hasNext()) {
            MutableCumulativeEffectInstance current = iterator.next();
            if (current.getEffect() == effect) {
                int old = current.getValue();

                int cap = effect.getCap(this);
                int newValue = Math.min(old + points, cap);
                current.setValue(newValue);

                if (newValue == cap) {
                    effect.onCapReached(this.getTargetAccess());
                    iterator.remove();
                    return true;
                }
            }
        }

        effects.add(new MutableCumulativeEffectInstance(effect, points));
        return true;
    }

    @Override
    public boolean removeEffectPoints(CumulativeEffect effect, int points) {
        Iterator<MutableCumulativeEffectInstance> iterator = effects.iterator();
        while (iterator.hasNext()) {
            MutableCumulativeEffectInstance instance = iterator.next();
            if (instance.getEffect() == effect) {
                int newValue = Math.max(instance.getValue() - points, 0);
                if (newValue == 0) {
                    iterator.remove();
                } else {
                    instance.setValue(newValue);
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeEffect(CumulativeEffect effect) {
        Iterator<MutableCumulativeEffectInstance> iterator = effects.iterator();
        while (iterator.hasNext()) {
            MutableCumulativeEffectInstance instance = iterator.next();
            if (instance.getEffect() == effect) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasEffect(CumulativeEffect effect) {
        for (MutableCumulativeEffectInstance instance : effects) {
            if (instance.getEffect() == effect) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<? extends CumulativeEffectInstance> getEffects() {
        return Collections.unmodifiableList(effects);
    }

    public List<MutableCumulativeEffectInstance> getMutableEffects() {
        return effects;
    }

    @Override
    public List<CumulativeEffectModifierHolder> getModifierHolders() {
        return modifierHolders;
    }

    @NotNull
    public IAttachmentHolder get() {
        return attachmentHolder;
    }

    @Override
    public TargetAccess getTargetAccess() {
        return targetAccess;
    }

    public static class SyncHandler implements AttachmentSyncHandler<CumulativeEffectTarget> {
        @Override
        public void write(RegistryFriendlyByteBuf buf, CumulativeEffectTarget attachment, boolean initialSync) {
            CumulativeEffectTargetImpl target = (CumulativeEffectTargetImpl) attachment;
            MutableCumulativeEffectInstance.LIST_CODEC.encode(buf, target.effects);
        }

        @Override
        public @Nullable CumulativeEffectTarget read(IAttachmentHolder holder, RegistryFriendlyByteBuf buf, @Nullable CumulativeEffectTarget previousValue) {
            CumulativeEffectTargetImpl target = new CumulativeEffectTargetImpl(holder);
            List<MutableCumulativeEffectInstance> effects = MutableCumulativeEffectInstance.LIST_CODEC.decode(buf);
            target.effects.addAll(effects);
            return target;
        }
    }
}
