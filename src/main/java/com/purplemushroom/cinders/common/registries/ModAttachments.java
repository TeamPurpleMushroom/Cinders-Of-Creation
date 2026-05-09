package com.purplemushroom.cinders.common.registries;

import com.purplemushroom.cinders.CindersOfCreation;
import com.purplemushroom.cinders.api.cumulative.CumulativeEffectTarget;
import com.purplemushroom.cinders.impl.cumulative.CumulativeEffectTargetImpl;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.Nullable;
import ru.timeconqueror.timecore.api.registry.SimpleVanillaRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;
import ru.timeconqueror.timecore.api.registry.util.Promised;

public class ModAttachments {
    @AutoRegistrable
    private static final SimpleVanillaRegister<AttachmentType<?>> ATTACHMENT_TYPES = new SimpleVanillaRegister<>(NeoForgeRegistries.ATTACHMENT_TYPES, CindersOfCreation.MODID);

    public static final Promised<AttachmentType<CumulativeEffectTarget>> CUMULATIVE_EFFECT_TARGET = ATTACHMENT_TYPES.register(
            "cumulative_effect_target", () -> AttachmentType.builder(CumulativeEffectTargetImpl::make)
                    .sync(new CumulativeEffectTargetImpl.SyncHandler())
                    .build()
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
