package com.purplemushroom.cinders.api.cumulative;

import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;

public interface CumulativeEffectModifier {
    int get(CumulativeEffect effect);
}
