package com.purplemushroom.cinders.common.datagen;

import com.purplemushroom.cinders.CindersOfCreation;
import com.purplemushroom.cinders.common.registries.ModItems;
import net.minecraft.data.PackOutput;
import ru.timeconqueror.timecore.api.client.resource.ItemModel;
import ru.timeconqueror.timecore.api.client.resource.StandardItemModelParents;
import ru.timeconqueror.timecore.api.client.resource.location.TextureLocation;
import ru.timeconqueror.timecore.api.devtools.gen.ModelProvider;

public class ModItemModelProvider extends ModelProvider {
    public ModItemModelProvider(PackOutput output) {
        super(output, CindersOfCreation.MODID, ITEM_FOLDER);
    }

    @Override
    protected void registerAll() {
        addItemModel(ModItems.TEST_PEARL, ItemModel.parentedBy(StandardItemModelParents.GENERATED)
                .addTextureLayer(new TextureLocation("minecraft", "item/ender_pearl")));
    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
