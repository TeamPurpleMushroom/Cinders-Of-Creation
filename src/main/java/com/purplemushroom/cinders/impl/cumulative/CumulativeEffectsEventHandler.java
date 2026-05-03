package com.purplemushroom.cinders.impl.cumulative;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import com.purplemushroom.cinders.common.registries.Attachments;
import com.purplemushroom.cinders.impl.cumulative.target.BaseCumulativeEffectTarget;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.Iterator;
import java.util.List;

@EventBusSubscriber
public class CumulativeEffectsEventHandler {
    @SubscribeEvent
    public static void onEntityPostTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        if (!entity.hasData(Attachments.CUMULATIVE_EFFECT_TARGET)) {
            return;
        }

        CumulativeEffectTarget target = entity.getData(Attachments.CUMULATIVE_EFFECT_TARGET);
        if (!(target instanceof BaseCumulativeEffectTarget<?> baseTarget)) {
            return;
        }

        Level level = entity.level();
        long ticks = level.getGameTime();
        Iterator<MutableCumulativeEffectInstance> iterator = baseTarget.getMutableEffects().iterator();
        while (iterator.hasNext()) {
            MutableCumulativeEffectInstance instance = iterator.next();
            CumulativeEffect effect = instance.getEffect();
            if (effect.isInvincible(target)) {
                iterator.remove();
                continue;
            }

            effect.onTick(instance, ticks);

            if (instance.getValue() == 0) {
                iterator.remove();
            }
        }

        List<MutableCumulativeEffectInstance> effects = baseTarget.getMutableEffects();
        if(effects.isEmpty()) {
            entity.removeData(Attachments.CUMULATIVE_EFFECT_TARGET);
        }
    }
}
