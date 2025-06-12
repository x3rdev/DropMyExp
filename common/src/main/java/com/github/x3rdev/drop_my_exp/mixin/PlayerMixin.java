package com.github.x3rdev.drop_my_exp.mixin;

import com.github.x3rdev.drop_my_exp.CommonClass;
import com.github.x3rdev.drop_my_exp.Constants;
import com.github.x3rdev.drop_my_exp.DMEConfig;
import net.minecraft.server.commands.ExperienceCommand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {

    @Inject(at = @At("RETURN"), method = "getBaseExperienceReward", cancellable = true)
    private void getBaseExperienceReward(CallbackInfoReturnable<Integer> cir) {
        if(DMEConfig.modEnabled) {
            float percent = DMEConfig.expPercent/100F;
            float exp = getTotalExperience((Player)((Object) this))*percent;
            if(DMEConfig.expCap == -1) {
                cir.setReturnValue((int) exp);
            } else {
                cir.setReturnValue((int) Math.min(exp, DMEConfig.expCap));
            }
        }
    }

    private static int getTotalExperience(Player player) {
        int level = player.experienceLevel;
        int extraExp = (int) (player.experienceProgress*(player.getXpNeededForNextLevel()));

        player.getXpNeededForNextLevel();
        if (level <= 16) {
            return level * level + 6 * level + extraExp;
        } else if (level <= 31) {
            return (int)(2.5 * level * level - 40.5 * level + 360) + extraExp;
        } else {
            return (int)(4.5 * level * level - 162.5 * level + 2220) + extraExp;
        }
    }
}
