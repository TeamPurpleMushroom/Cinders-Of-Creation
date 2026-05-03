package com.purplemushroom.cinders.api;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import com.purplemushroom.cinders.common.registries.Attachments;
import net.minecraft.world.entity.LivingEntity;

public class CindersApi {
    public CumulativeEffectTarget asCumulativeEffectTarget(LivingEntity entity) {
        return entity.getData(Attachments.CUMULATIVE_EFFECT_TARGET);
    }
}
