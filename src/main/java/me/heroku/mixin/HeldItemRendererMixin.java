package me.heroku.mixin;

import me.heroku.JustEnoughGameRules;
import me.heroku.Rules;
import net.minecraft.client.render.item.HeldItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {
    @ModifyConstant(method = "renderFirstPersonItem", constant = @Constant(floatValue = 20.0f))
    private float getPullProgressForRendering(float previous) {
        return (float)JustEnoughGameRules.INSTANCE.getCurrentWorld().getGameRules().getInt(Rules.BOW_DRAW_SPEED);
    }
}
