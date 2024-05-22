package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public abstract class EndermanMixin extends HostileEntity implements Angerable {
    protected EndermanMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "teleportRandomly", at = @At("HEAD"), cancellable = true)
    public void teleportRandomlyWithinRadius(CallbackInfoReturnable<Boolean> callbackInfo) {
        var accessor = (EndermanAccessor) this;
        var radius = this.getWorld().getGameRules().getInt(Rules.ENDERMAN_TElEPORT_RADIUS);

        if (!this.getWorld().isClient() && this.isAlive()) {
            System.out.println(radius);
            double d = this.getX() + (this.random.nextDouble() - 0.5) * radius;
            double e = this.getY() + (double)(this.random.nextInt(radius) - radius / 2);
            double f = this.getZ() + (this.random.nextDouble() - 0.5) * radius;
            callbackInfo.setReturnValue(accessor.invokeTeleportTo(d, e, f));
        } else {
            callbackInfo.setReturnValue(false);
        }
    }
}
