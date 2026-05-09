package com.purplemushroom.cinders.common.datagen;

import com.purplemushroom.cinders.CindersOfCreation;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import ru.timeconqueror.timecore.api.devtools.gen.loottable.TimeBlockLootSubProvider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockLootSubProvider extends TimeBlockLootSubProvider {
//    private static final Supplier<Stream<Block>> EXPLOSION_RESISTANT = () -> Stream.of(
//            LGBlocks.MICROVERSE_MANIPULATOR
//    );

    protected BlockLootSubProvider(HolderLookup.Provider registries) {
        super(CindersOfCreation.MODID, Stream.<Block>of() /*EXPLOSION_RESISTANT.get()*/
                        .map(ItemLike::asItem)
                        .collect(Collectors.toSet()),
                FeatureFlags.REGISTRY.allFlags(),
                registries);
        setErrorUponMissingLootTable(true);
    }

    @Override
    protected void generate() {
//        this.add(LGBlocks.DUNGEON_CEILING, noDrop());
//        this.add(LGBlocks.CRACKED_DUNGEON_CEILING, noDrop());
//        this.add(LGBlocks.DUNGEON_WALL, noDrop());
//        this.add(LGBlocks.CRACKED_DUNGEON_WALL, noDrop());
//        this.add(LGBlocks.CRACKED_DUNGEON_FLOOR, noDrop());
//        this.add(LGBlocks.SHIELDED_DUNGEON_FLOOR, noDrop());
//        this.add(LGBlocks.DUNGEON_LAMP, noDrop());
//        this.add(LGBlocks.BROKEN_DUNGEON_LAMP, noDrop());
//        this.add(LGBlocks.PUZZLE_MASTER, noDrop());
//        this.add(LGBlocks.BOARD_BORDER, noDrop());
//        this.add(LGBlocks.GLASSY_MATTER, noDrop());
//        this.add(LGBlocks.BOARD_GLASSY_MATTER, noDrop());
//        this.add(LGBlocks.DUNGEON_BLOCK, noDrop());
//        this.add(LGBlocks.BOARD_OPAQUE_MATTER, noDrop());
//        this.add(LGBlocks.SPACE_FABRIC, noDrop());
//        this.add(LGBlocks.MICROVERSE_MANIPULATOR, this::createNameableBlockEntityTable);
//        this.add(LGBlocks.TRANSFERENCE_CRYSTAL, noDrop());
//        this.add(LGBlocks.MATTER_BLOCK, noDrop());
//        this.add(LGBlocks.MATTER_BLOCK_SLAB, noDrop());
//        this.add(LGBlocks.MATTER_BLOCK_STAIRS, noDrop());
//        this.add(LGBlocks.MATTER_WALL, noDrop());
//        this.add(LGBlocks.MATTER_GLOWING_BLOCK, noDrop());

    }
}
