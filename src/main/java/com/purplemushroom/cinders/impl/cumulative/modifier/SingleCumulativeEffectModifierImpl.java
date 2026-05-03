package com.purplemushroom.cinders.impl.cumulative.modifier;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifier;
import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;

public class SingleCumulativeEffectModifierImpl implements CumulativeEffectModifier {
    private final CumulativeEffect effect;
    private final int value;

    public SingleCumulativeEffectModifierImpl(CumulativeEffect effect, int value) {
        this.effect = effect;
        this.value = value;
    }

    @Override
    public int get(CumulativeEffect effect) {
        if (this.effect == effect) {
            return value;
        }

        return 0;
    }
}
