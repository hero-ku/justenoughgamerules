package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbstractSkeletonEntity.class)
public class SkeletonMixin extends HostileEntity {
    protected SkeletonMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyArg(method = "attack", at = @At(target = "net/minecraft/entity/projectile/PersistentProjectileEntity.setVelocity(DDDFF)V", value = "INVOKE"), index = 4)
    public float modifyDivergence(float divergence) {
        var world = this.getWorld();
        var gameRules = world.getGameRules();

        if (gameRules.getBoolean(Rules.USE_SKELETON_ACCURACY)) {
            return (float) gameRules.getInt(Rules.SKELETON_ACCURACY);
        } else {
            return divergence;
        }
    }
}
