package com.purplemushroom.cinders.impl.cumulative.target;

import net.minecraft.world.entity.LivingEntity;

public class LivingEntityCumulativeEffectTarget extends BaseCumulativeEffectTarget<LivingEntity> {
    public LivingEntityCumulativeEffectTarget(LivingEntity attachmentHolder) {
        super(attachmentHolder);
    }

    @Override
    public int getTickExisted() {
        return get().tickCount;
    }
}
