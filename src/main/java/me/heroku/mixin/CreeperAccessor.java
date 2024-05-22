package me.heroku.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreeperEntity.class)
public interface CreeperAccessor {
    @Accessor("explosionRadius")
    void setExplosionRadius(int explosionRadius);
}
