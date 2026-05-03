package com.purplemushroom.cinders.api.cumulative;

import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;
import com.purplemushroom.cinders.impl.cumulative.target.EmptyCumulativeEffectTarget;
import com.purplemushroom.cinders.impl.cumulative.target.LivingEntityCumulativeEffectTarget;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CumulativeEffectTarget {
    static CumulativeEffectTarget make(IAttachmentHolder holder) {
        if(holder instanceof LivingEntity living) {
            return new LivingEntityCumulativeEffectTarget(living);
        }

        return EmptyCumulativeEffectTarget.INSTANCE;
    }

    boolean addEffectPoints(CumulativeEffect effect, int power);

    boolean removeEffectPoints(CumulativeEffect effect, int value);

    boolean removeEffect(CumulativeEffect effect);

    boolean hasEffect(CumulativeEffect effect);

    void addModifierHolder(CumulativeEffectModifierHolder modifierHolder);

    List<? extends CumulativeEffectInstance> getEffects();

    List<CumulativeEffectModifierHolder> getModifierHolders();

    /**
     * If the attachment holder is null, effect will not be applied
     */
    @Nullable
    IAttachmentHolder get();

    int getTickExisted();

    @Nullable
    default LivingEntity getAsLiving() {
        IAttachmentHolder holder = get();
        if(holder instanceof LivingEntity entity) {
            return entity;
        }

        return null;
    }
}
