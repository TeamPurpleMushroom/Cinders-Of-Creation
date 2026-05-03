package com.purplemushroom.cinders.impl.cumulative.holder;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifier;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierLogic;

public class SingleCumulativeEffectModifierHolder implements CumulativeEffectModifierHolder {
    private final CumulativeEffectModifier modifier;

    public SingleCumulativeEffectModifierHolder(CumulativeEffectModifier modifier) {
        this.modifier = modifier;
    }

    @Override
    public void iterateOverModifiers(CumulativeEffectModifierLogic logic) {
        logic.accept(modifier);
    }
}
