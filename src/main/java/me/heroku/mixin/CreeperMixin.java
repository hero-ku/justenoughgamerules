package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public abstract class CreeperMixin {
    @Inject(method = "explode", at = @At(value = "HEAD"))
    public void modifyExplosionRadius(CallbackInfo callbackInfo) {
        ((CreeperAccessor) this).setExplosionRadius(((CreeperEntity)(Object) this).getWorld().getGameRules().getInt(Rules.CREEPER_EXPLOSION_RADIUS));
    }
}

