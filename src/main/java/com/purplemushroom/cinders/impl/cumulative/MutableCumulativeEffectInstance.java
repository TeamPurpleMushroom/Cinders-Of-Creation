package com.purplemushroom.cinders.impl.cumulative;

import com.purplemushroom.cinders.api.cumulative.CumulativeEffectInstance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;

@AllArgsConstructor
public class MutableCumulativeEffectInstance implements CumulativeEffectInstance {
    public static final StreamCodec<RegistryFriendlyByteBuf, MutableCumulativeEffectInstance> STREAM_CODEC = StreamCodec.composite(
            CumulativeEffect.STREAM_CODEC,
            MutableCumulativeEffectInstance::getEffect,
            ByteBufCodecs.VAR_INT,
            MutableCumulativeEffectInstance::getValue,
            MutableCumulativeEffectInstance::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, List<MutableCumulativeEffectInstance>> LIST_CODEC = STREAM_CODEC.apply(ByteBufCodecs.list());

    @Getter
    private final CumulativeEffect effect;
    @Setter
    @Getter
    private int value;
}
