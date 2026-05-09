package com.purplemushroom.cinders.common.datagen;

import com.purplemushroom.cinders.CindersOfCreation;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import ru.timeconqueror.timecore.api.devtools.gen.advancement.DataGeneration;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class DataHandler {
    @SubscribeEvent
    public static void onDataEvent(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        gen.addProvider(event.includeServer(), DataGeneration.factory(output_ -> new ModBlockTagsProvider(output_, lookupProvider, fileHelper)));
        gen.addProvider(event.includeClient(), DataGeneration.factory(ModBlockStateAndBlockModelProvider::new));
        gen.addProvider(event.includeClient(), DataGeneration.factory(ModItemModelProvider::new));
    }
}
