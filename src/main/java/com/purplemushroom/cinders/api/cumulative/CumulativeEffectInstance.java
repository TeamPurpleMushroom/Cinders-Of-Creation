package com.purplemushroom.cinders.api.cumulative;

import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;

public interface CumulativeEffectInstance {
    int getValue();
    CumulativeEffect getEffect();
}
