package com.purplemushroom.cinders.impl.cumulative.target;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectInstance;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectModifierHolder;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;
import net.neoforged.neoforge.attachment.IAttachmentHolder;

import java.util.List;

public class EmptyCumulativeEffectTarget implements CumulativeEffectTarget {
    public static final EmptyCumulativeEffectTarget INSTANCE = new EmptyCumulativeEffectTarget();

    @Override
    public boolean addEffectPoints(CumulativeEffect effect, int power) {
        return false;
    }

    @Override
    public boolean removeEffectPoints(CumulativeEffect effect, int value) {
        return false;
    }

    @Override
    public boolean removeEffect(CumulativeEffect effect) {
        return false;
    }

    @Override
    public boolean hasEffect(CumulativeEffect effect) {
        return false;
    }

    @Override
    public void addModifierHolder(CumulativeEffectModifierHolder modifierHolder) {

    }

    @Override
    public List<? extends CumulativeEffectInstance> getEffects() {
        return List.of();
    }

    @Override
    public List<CumulativeEffectModifierHolder> getModifierHolders() {
        return List.of();
    }

    @Override
    public IAttachmentHolder get() {
        return null;
    }

    @Override
    public int getTickExisted() {
        return 0;
    }
}
