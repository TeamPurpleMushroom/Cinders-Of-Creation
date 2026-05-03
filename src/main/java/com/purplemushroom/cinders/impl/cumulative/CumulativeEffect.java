package com.purplemushroom.cinders.impl.cumulative;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import lombok.Getter;
import net.minecraft.world.entity.LivingEntity;

public abstract class CumulativeEffect {
    @Getter
    private final int baseCap;
    @Getter
    private final int decreasePeriodTicks;
    @Getter
    private final int decreaseAmount;

    protected CumulativeEffect(int baseCap, int decreasePeriodTicks, int decreaseAmount) {
        this.baseCap = baseCap;
        this.decreasePeriodTicks = decreasePeriodTicks;
        this.decreaseAmount = decreaseAmount;
    }

    public void onCapReached(CumulativeEffectTarget target) {
        LivingEntity living = target.getAsLiving();
        if(living != null) {
            onCapReached(living);
        }
    }

    public abstract void onCapReached(LivingEntity target);

    public void onTick(MutableCumulativeEffectInstance instance, long ticks) {
        if(ticks % decreasePeriodTicks == 0) {
            int newValue = Math.max(instance.getValue() - this.decreaseAmount, 0);
            instance.setValue(newValue);
        }
    }

    public boolean isInvincible(CumulativeEffectTarget target) {
        return isInvincible(getCap(target));
    }

    public int getCap(CumulativeEffectTarget target) {
        CumulativeEffectModifierLogicImpl logic = new CumulativeEffectModifierLogicImpl(this);
        for (CumulativeEffectModifierHolder holder : target.getModifierHolders()) {
            holder.iterateOverModifiers(logic);
        }
        return logic.getCap();
    }

    public static boolean isInvincible(int capValue) {
        return capValue == Integer.MAX_VALUE;
    }

    public static int getInvincibleCap() {
        return Integer.MAX_VALUE;
    }
}
