package me.heroku.mixin;

import net.minecraft.entity.mob.GhastEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = "net/minecraft/entity/mob/GhastEntity$ShootFireballGoal")
public interface GhastFireballAccessor {
    @Accessor
    GhastEntity getGhast();

    @Accessor("cooldown")
    void setCooldown(int cooldown);
}
