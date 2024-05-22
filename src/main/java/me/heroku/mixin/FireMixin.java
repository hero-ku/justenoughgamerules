package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireBlock.class)
public class FireMixin {
    @Inject(method = "scheduledTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;removeBlock(Lnet/minecraft/util/math/BlockPos;Z)Z"), cancellable = true)
    public void stopFire(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo callbackInfo) {
        if (!world.getGameRules().getBoolean(Rules.RAIN_PUTS_OUT_FIRE)) {
            callbackInfo.cancel();
        }
    }
}
