package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SlimeEntity.class)
public class SlimeMixin extends MobEntity {
    protected SlimeMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "remove", at = @At("STORE"), ordinal = 2)
    public int setSlimeSplitCount(int previous) {
        return switch(this.getType().getName().getString()) {
            case ("Slime") -> this.getWorld().getGameRules().getInt(Rules.SLIME_SPLIT_COUNT);
            case ("Magma Cube") -> this.getWorld().getGameRules().getInt(Rules.MAGMA_CUBE_SPLIT_COUNT);
            default -> 2;
        } + this.random.nextInt(3);
    }
}
