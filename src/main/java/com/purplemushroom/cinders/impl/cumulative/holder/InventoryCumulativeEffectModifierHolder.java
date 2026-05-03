package com.purplemushroom.cinders.impl.cumulative.holder;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierLogic;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;

public class InventoryCumulativeEffectModifierHolder implements CumulativeEffectModifierHolder {
    private final ServerPlayer player;

    public InventoryCumulativeEffectModifierHolder(ServerPlayer player) {
        this.player = player;
    }

    @Override
    public void iterateOverModifiers(CumulativeEffectModifierLogic logic) {
        Inventory inventory = player.getInventory();
        CumulativeEffectModifierHolder.iterateOverStacks(inventory.items, logic);
        CumulativeEffectModifierHolder.iterateOverStacks(inventory.armor, logic);
        CumulativeEffectModifierHolder.iterateOverStacks(inventory.offhand, logic);
    }
}
