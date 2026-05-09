package com.purplemushroom.cinders.common.registries;

import com.purplemushroom.cinders.CindersOfCreation;
import com.purplemushroom.cinders.common.item.TestPearlItem;
import net.minecraft.world.item.Item;
import ru.timeconqueror.timecore.api.registry.ItemRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;
import ru.timeconqueror.timecore.api.util.Hacks;

@AutoRegistrable.Entries("item")
public class ModItems {
    public static Item TEST_PEARL = Hacks.promise();

    private static class Init {
        @AutoRegistrable
        private static final ItemRegister REGISTER = new ItemRegister(CindersOfCreation.MODID);

        @AutoRegistrable.Init
        private static void register() {
            REGISTER.register("test_pearl", () -> new TestPearlItem(new Item.Properties()))
                    .tab(ModCreativeTabs.MAIN);
        }
    }
}
