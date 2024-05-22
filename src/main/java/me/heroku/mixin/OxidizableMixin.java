package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.block.BlockState;
import net.minecraft.block.OxidizableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.util.math.random.Random;

@Mixin(OxidizableBlock.class)
public class OxidizableMixin {
    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void stopOxidization(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo callbackInfo) {
        if (!world.getGameRules().getBoolean(Rules.DO_OXIDIZATION)) {
            callbackInfo.cancel();
        }
    }
}
