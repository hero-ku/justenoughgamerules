package me.heroku.mixin;

import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EndermanEntity.class)
public interface EndermanAccessor {
    @Invoker("teleportTo")
    boolean invokeTeleportTo(double d, double e, double f);
}
