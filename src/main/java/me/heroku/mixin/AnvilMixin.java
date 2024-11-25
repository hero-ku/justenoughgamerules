package me.heroku.mixin;

import me.heroku.JustEnoughGameRules;
import me.heroku.Rules;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.FallingBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AnvilBlock.class)
public class AnvilMixin extends FallingBlock {
    public AnvilMixin(Settings settings) { super(settings); }

    @ModifyConstant(method = "configureFallingBlockEntity", constant = @Constant(floatValue = 2.0F))
    protected float setAnvilDamagePerBlock(float previous) {
        var world = JustEnoughGameRules.INSTANCE.getCurrentWorld();
        if (world == null) {
            return previous;
        }

        return (float) world.getGameRules().get(Rules.ANVIL_DAMAGE_PER_BLOCK).get();
    }

    @ModifyConstant(method = "configureFallingBlockEntity", constant = @Constant(intValue = 40))
    protected int setAnvilMaxDamage(int previous) {
        var world = JustEnoughGameRules.INSTANCE.getCurrentWorld();
        if (world == null) {
            return previous;
        }

        return world.getGameRules().get(Rules.ANVIL_MAX_DAMAGE).get();
    }
}
