package com.purplemushroom.cinders.common.registries;

import com.purplemushroom.cinders.CindersOfCreation;
import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

@EventBusSubscriber
public class ModRegistrar {
    public static final ResourceKey<Registry<CumulativeEffect>> CUMULATIVE_EFFECT_KEY = ResourceKey.createRegistryKey(CindersOfCreation.rl("cumulative_effect"));

    private static Registry<CumulativeEffect> CUMULATIVE_EFFECT_REGISTRY;

    @SubscribeEvent
    public static void registerRegistries(NewRegistryEvent e) {
        CUMULATIVE_EFFECT_REGISTRY = e.create(new RegistryBuilder<>(CUMULATIVE_EFFECT_KEY)
                        .sync(true));
    }

    public static Registry<CumulativeEffect> cumulativeEffectRegistry() {
        return CUMULATIVE_EFFECT_REGISTRY;
    }
}