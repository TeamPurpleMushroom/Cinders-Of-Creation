package com.purplemushroom.cinders.common.registries;

import com.purplemushroom.cinders.CindersOfCreation;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class Attachments {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, CindersOfCreation.MODID);

    public static final Supplier<AttachmentType<CumulativeEffectTarget>> CUMULATIVE_EFFECT_TARGET = ATTACHMENT_TYPES.register(
            "cumulative_effect_target", () -> AttachmentType.builder(CumulativeEffectTarget::make).build()
    );

    @Nullable
    public static Player asPlayer(IAttachmentHolder holder) {
        if(holder instanceof Player player) {
            return player;
        }

        return null;
    }

    @Nullable
    public static Entity asEntity(IAttachmentHolder holder) {
        if(holder instanceof Entity entity) {
            return entity;
        }

        return null;
    }
}
