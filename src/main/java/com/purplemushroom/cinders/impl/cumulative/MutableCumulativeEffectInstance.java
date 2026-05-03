package com.purplemushroom.cinders.impl.cumulative;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectInstance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MutableCumulativeEffectInstance implements CumulativeEffectInstance {
    @Getter
    private final CumulativeEffect effect;
    @Setter
    @Getter
    private int value;
}
