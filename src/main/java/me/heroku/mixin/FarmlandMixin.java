package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public class FarmlandMixin extends Block {
	public FarmlandMixin(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("HEAD"), method = "onLandedUpon", cancellable = true)
	private void init(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo callbackInfo) {
		if (!world.getGameRules().getBoolean(Rules.DO_CROP_TRAMPLING)) {
			super.onLandedUpon(world, state, pos, entity, fallDistance);
			callbackInfo.cancel();
		}
	}
}