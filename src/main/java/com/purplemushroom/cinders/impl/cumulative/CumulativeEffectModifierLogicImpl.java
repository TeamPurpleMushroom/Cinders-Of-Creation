package com.purplemushroom.cinders.impl.cumulative;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifier;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierLogic;
import lombok.Getter;

public class CumulativeEffectModifierLogicImpl implements CumulativeEffectModifierLogic {
    private final CumulativeEffect effect;
    @Getter
    private int cap;

    public CumulativeEffectModifierLogicImpl(CumulativeEffect effect) {
        this.effect = effect;
        this.cap = effect.getBaseCap();
    }

    @Override
    public void accept(CumulativeEffectModifier modifier) {
        if(CumulativeEffect.isInvincible(cap)) {
            // skip logic since it's already invincible
            return;
        }

        int modifierValue = modifier.get(effect);
        if(CumulativeEffect.isInvincible(modifierValue)) {
            cap = CumulativeEffect.getInvincibleCap();
            return;
        }

        cap += modifierValue;
    }
}
