package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public abstract class CreeperMixin extends HostileEntity {
    protected CreeperMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "explode", at = @At(value = "HEAD"))
    public void modifyExplosionRadius(CallbackInfo callbackInfo) {
        ((CreeperAccessor) this).setExplosionRadius(this.getWorld().getGameRules().getInt(Rules.CREEPER_EXPLOSION_RADIUS));
    }
}