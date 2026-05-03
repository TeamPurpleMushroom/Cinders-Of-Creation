package com.purplemushroom.cinders.impl.cumulative.target;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectInstance;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;
import com.purplemushroom.cinders.impl.cumulative.MutableCumulativeEffectInstance;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseCumulativeEffectTarget<T extends IAttachmentHolder> implements CumulativeEffectTarget {
    private final T attachmentHolder;
    private final List<CumulativeEffectModifierHolder> modifierHolders;
    private final List<MutableCumulativeEffectInstance> effects;

    public BaseCumulativeEffectTarget(T attachmentHolder) {
        this.attachmentHolder = attachmentHolder;
        this.modifierHolders = new ArrayList<>();
        this.effects = new ArrayList<>();
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
                    effect.onCapReached(this);
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
    public T get() {
        return attachmentHolder;
    }
}
