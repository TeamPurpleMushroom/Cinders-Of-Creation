package com.purplemushroom.cinders.impl.cumulative.holder;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierLogic;

import java.util.List;

public class MergedCumulativeEffectModifierHolder implements CumulativeEffectModifierHolder {
    private final List<CumulativeEffectModifierHolder> holders;

    public MergedCumulativeEffectModifierHolder(List<CumulativeEffectModifierHolder> holders) {
        this.holders = holders;
    }

    @Override
    public void iterateOverModifiers(CumulativeEffectModifierLogic logic) {
        for (CumulativeEffectModifierHolder holder : holders) {
            holder.iterateOverModifiers(logic);
        }
    }
}