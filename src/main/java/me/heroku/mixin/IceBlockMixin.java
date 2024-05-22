package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IceBlock.class)
public class IceBlockMixin {
    @Inject(method = "melt", at = @At("HEAD"), cancellable = true)
    public void melt(BlockState state, World world, BlockPos pos, CallbackInfo callbackInfo) {
        if (!world.getGameRules().getBoolean(Rules.DO_ICE_MELTING)) {
            callbackInfo.cancel();
        }
    }
}
