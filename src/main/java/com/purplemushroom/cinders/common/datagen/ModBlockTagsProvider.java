package com.purplemushroom.cinders.common.datagen;

import com.purplemushroom.cinders.CindersOfCreation;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CindersOfCreation.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider_) {
//        tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(LGBlocks.DUNGEON_CEILING)
//                .add(LGBlocks.CRACKED_DUNGEON_CEILING)
//                .add(LGBlocks.DUNGEON_WALL)
//                .add(LGBlocks.CRACKED_DUNGEON_WALL)
//                .add(LGBlocks.CRACKED_DUNGEON_FLOOR)
//                .add(LGBlocks.DUNGEON_LAMP)
//                .add(LGBlocks.BROKEN_DUNGEON_LAMP)
//
//                .add(LGBlocks.MICROVERSE_MANIPULATOR)
//                .replace(false);
    }
}
