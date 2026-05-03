package com.purplemushroom.cinders.impl.cumulative.modifier;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifier;
import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

public class MapBasedCumulativeEffectModifier implements CumulativeEffectModifier {
    private final Object2IntMap<CumulativeEffect> effectToValue;

    public MapBasedCumulativeEffectModifier(Object2IntMap<CumulativeEffect> effectToValue) {
        this.effectToValue = effectToValue;
    }

    @Override
    public int get(CumulativeEffect effect) {
        if(effectToValue.containsKey(effect)) {
            return effectToValue.getInt(effect);
        }

        return 0;
    }
}
