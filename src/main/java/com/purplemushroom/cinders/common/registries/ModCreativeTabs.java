package com.purplemushroom.cinders.common.registries;

import com.purplemushroom.cinders.CindersOfCreation;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import ru.timeconqueror.timecore.api.registry.SimpleVanillaRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;

public class ModCreativeTabs {
    public static final ResourceKey<CreativeModeTab> MAIN = ResourceKey.create(Registries.CREATIVE_MODE_TAB, CindersOfCreation.rl("main"));

    @AutoRegistrable
    private static final SimpleVanillaRegister<CreativeModeTab> REGISTER = new SimpleVanillaRegister<>(Registries.CREATIVE_MODE_TAB, CindersOfCreation.MODID);

    @AutoRegistrable.Init
    private static void setup() {
        REGISTER.register(MAIN.location().getPath(), () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + CindersOfCreation.MODID))
                .icon(() -> new ItemStack(Items.ENDER_PEARL))
                .build());
    }
}