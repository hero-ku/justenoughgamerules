package me.heroku.mixin;

import me.heroku.JustEnoughGameRules;
import me.heroku.Rules;
import net.minecraft.item.BowItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public class BowMixin {
    @Inject(method = "getPullProgress", at = @At("HEAD"), cancellable = true)
    private static void getSetProgress(int useTicks, CallbackInfoReturnable<Float> callbackInfo) {
        var maxTicks = JustEnoughGameRules.INSTANCE.getCurrentWorld().getGameRules().getInt(Rules.BOW_DRAW_SPEED);

        float f = (float) useTicks / (float) maxTicks;
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        callbackInfo.setReturnValue(f);
    }
}
