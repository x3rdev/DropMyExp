package com.github.x3rdev.drop_my_exp.mixin;

import com.github.x3rdev.drop_my_exp.DMEConfig;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow protected abstract int getBaseExperienceReward();

    private LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "getExperienceReward", at = @At("RETURN"), cancellable = true)
    private void getExperienceReward(ServerLevel level, Entity killer, CallbackInfoReturnable<Integer> cir) {
        if(DMEConfig.modEnabled && this.getType().equals(EntityType.PLAYER)) {
            cir.setReturnValue(getBaseExperienceReward());
        }
    }

    @Inject(method = "dropExperience", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ExperienceOrb;award(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/phys/Vec3;I)V"), cancellable = true)
    private void dropExperience(Entity entity, CallbackInfo ci) {
        if(DMEConfig.modEnabled && DMEConfig.oneOrb && this.getType().equals(EntityType.PLAYER)) {
            Vec3 pos = this.position();
            level().addFreshEntity(new ExperienceOrb(this.level(), pos.x(), pos.y(), pos.z(), getBaseExperienceReward()));
        }
        ci.cancel();
    }
}
