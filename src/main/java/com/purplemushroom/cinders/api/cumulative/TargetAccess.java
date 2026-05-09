package com.purplemushroom.cinders.api.cumulative;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import org.jetbrains.annotations.Nullable;

public sealed interface TargetAccess {
    int getTickExisted();

    @SuppressWarnings({"SwitchStatementWithTooFewBranches"})
    static TargetAccess of(IAttachmentHolder holder) {
        return switch (holder) {
            case Entity entity -> new EntityTargetAccess(entity);
            default -> new EmptyTargetAccess();
        };
    }

    @Nullable
    default LivingEntity getAsLiving() {
        return null;
    }

    final class EntityTargetAccess implements TargetAccess {
        private final Entity entity;

        public EntityTargetAccess(Entity entity) {
            this.entity = entity;
        }

        @Override
        public int getTickExisted() {
            return entity.tickCount;
        }

        @Override
        public @Nullable LivingEntity getAsLiving() {
            if(entity instanceof LivingEntity living) {
                return living;
            }

            return null;
        }
    }

    final class EmptyTargetAccess implements TargetAccess {

        @Override
        public int getTickExisted() {
            return 0;
        }
    }
}
