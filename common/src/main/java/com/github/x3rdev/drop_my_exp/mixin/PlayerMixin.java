package com.github.x3rdev.drop_my_exp.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(at = @At("RETURN"), method = "getBaseExperienceReward", cancellable = true)
    private void getBaseExperienceReward(CallbackInfoReturnable<Integer> cir) {
//        cir.setReturnValue();
    }
}
