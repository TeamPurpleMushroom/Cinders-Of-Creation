package com.purplemushroom.cinders.common.datagen;

import com.purplemushroom.cinders.CindersOfCreation;
import net.minecraft.data.PackOutput;
import ru.timeconqueror.timecore.api.devtools.gen.BlockStateProvider;
import ru.timeconqueror.timecore.api.devtools.gen.ModelProvider;

public class ModBlockStateAndBlockModelProvider extends BlockStateProvider {
    public ModBlockStateAndBlockModelProvider(PackOutput output) {
        super(output, CindersOfCreation.MODID);
    }

    @Override
    protected void registerAll() {
        ModelProvider models = blockModels();

//        addBlockState(SPACE_FABRIC, BlockStateResources.singleVariantWithSingleModel(
//                models.addBlockModel(SPACE_FABRIC, BlockModels.particlesOnly(new TextureLocation(LootGames.MODID, "block/empty"))))
//        );
//
//        BlockModelLocation glassMatterModel =
//                models.addBlockModel(GLASSY_MATTER, BlockModels.particlesOnly(new TextureLocation(LootGames.MODID, "block/empty")));
//        addBlockState(GLASSY_MATTER, BlockStateResources.singleVariantWithSingleModel(glassMatterModel));
//        addBlockState(BOARD_GLASSY_MATTER, BlockStateResources.singleVariantWithSingleModel(glassMatterModel));


    }

    @Override
    public String getName() {
        return CindersOfCreation.MODID + " BlockState Provider";
    }
}
