package com.purplemushroom.cinders.api;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import com.purplemushroom.cinders.common.registries.ModAttachments;
import net.minecraft.world.entity.LivingEntity;

public class CindersApi {
    public CumulativeEffectTarget asCumulativeEffectTarget(LivingEntity entity) {
        return entity.getData(ModAttachments.CUMULATIVE_EFFECT_TARGET);
    }
}
