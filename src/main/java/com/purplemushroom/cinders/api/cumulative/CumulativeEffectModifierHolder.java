package com.purplemushroom.cinders.api.cumulative;

import net.minecraft.world.item.ItemStack;

public interface CumulativeEffectModifierHolder {
    void iterateOverModifiers(CumulativeEffectModifierLogic logic);

    static void iterateOverStacks(Iterable<ItemStack> stacks, CumulativeEffectModifierLogic logic) {
        for (ItemStack item : stacks) {
            if (item.getItem() instanceof CumulativeEffectModifier modifier) {
                logic.accept(modifier);
            }
        }
    }
}
