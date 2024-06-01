package me.heroku.mixin;

import me.heroku.Rules;
import net.minecraft.entity.mob.GhastEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(GhastEntity.ShootFireballGoal.class)
public class GhastFireballMixin {
    @Redirect(method = "tick", at = @At(value = "FIELD", target = "net/minecraft/entity/mob/GhastEntity$ShootFireballGoal.cooldown:I", opcode = Opcodes.PUTFIELD, ordinal = 1))
    public void setCooldown(GhastEntity.ShootFireballGoal goal, int cooldown) {
        var accessor = (GhastFireballAccessor) goal;
        var world = accessor.getGhast().getWorld();

        goal.cooldown = 20 - world.getGameRules().getInt(Rules.GHAST_FIREBALL_COOLDOWN);
    }
}