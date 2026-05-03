package com.purplemushroom.cinders.impl.cumulative;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifier;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.impl.cumulative.holder.InventoryCumulativeEffectModifierHolder;
import com.purplemushroom.cinders.impl.cumulative.holder.MergedCumulativeEffectModifierHolder;
import com.purplemushroom.cinders.impl.cumulative.holder.SingleCumulativeEffectModifierHolder;
import com.purplemushroom.cinders.impl.cumulative.modifier.MapBasedCumulativeEffectModifier;
import com.purplemushroom.cinders.impl.cumulative.modifier.SingleCumulativeEffectModifierImpl;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import net.minecraft.server.level.ServerPlayer;

import java.util.Arrays;

//TODO add baubles support
public class CumulativeEffectModifierHolders {
    public static CumulativeEffectModifierHolder of(CumulativeEffectModifierHolder... holders) {
        return new MergedCumulativeEffectModifierHolder(Arrays.asList(holders));
    }

    public static CumulativeEffectModifierHolder playerInventory(ServerPlayer player) {
        return new InventoryCumulativeEffectModifierHolder(player);
    }

    public static CumulativeEffectModifierHolder single(CumulativeEffectModifier modifier) {
        return new SingleCumulativeEffectModifierHolder(modifier);
    }

    public static CumulativeEffectModifierHolder invincible(CumulativeEffect effect) {
        return new SingleCumulativeEffectModifierHolder(new SingleCumulativeEffectModifierImpl(effect, CumulativeEffect.getInvincibleCap()));
    }

    public static CumulativeEffectModifierHolder invincible(CumulativeEffect... effects) {
        Object2IntArrayMap<CumulativeEffect> map = new Object2IntArrayMap<>(effects.length);
        for (CumulativeEffect effect : effects) {
            map.put(effect, CumulativeEffect.getInvincibleCap());
        }
        return new SingleCumulativeEffectModifierHolder(new MapBasedCumulativeEffectModifier(map));
    }
}
