package com.purplemushroom.cinders.api.cumulative;

import com.purplemushroom.cinders.impl.cumulative.CumulativeEffect;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CumulativeEffectTarget {

    boolean addEffectPoints(CumulativeEffect effect, int power);

    boolean removeEffectPoints(CumulativeEffect effect, int value);

    boolean removeEffect(CumulativeEffect effect);

    boolean hasEffect(CumulativeEffect effect);

    void addModifierHolder(CumulativeEffectModifierHolder modifierHolder);

    List<? extends CumulativeEffectInstance> getEffects();

    List<CumulativeEffectModifierHolder> getModifierHolders();

    /**
     * If the attachment holder is null, effect will not be applied
     */
    @Nullable
    IAttachmentHolder get();

    TargetAccess getTargetAccess();
}
