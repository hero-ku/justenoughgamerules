package me.heroku.mixin;

import net.minecraft.entity.mob.GhastEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GhastEntity.ShootFireballGoal.class)
public interface GhastFireballAccessor {
    @Accessor
    GhastEntity getGhast();
}
