package me.heroku

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule
import net.minecraft.world.GameRules
import net.minecraft.world.GameRules.BooleanRule
import net.minecraft.world.GameRules.IntRule
import net.minecraft.world.GameRules.Key

object Rules {
    lateinit var DO_CROP_TRAMPLING: Key<BooleanRule>
    lateinit var DO_OXIDIZATION: Key<BooleanRule>
    lateinit var DO_ICE_MELTING: Key<BooleanRule>
    lateinit var DO_SAPLING_GROWTH: Key<BooleanRule>
    lateinit var RAIN_PUTS_OUT_FIRE: Key<BooleanRule>
    lateinit var DO_CROP_GROWTH: Key<BooleanRule>
    lateinit var USE_SKELETON_ACCURACY: Key<BooleanRule>
    lateinit var SKELETON_ACCURACY: Key<IntRule>
    lateinit var CREEPER_EXPLOSION_RADIUS: Key<IntRule>
    lateinit var ENDERMAN_TELEPORT_RADIUS: Key<DoubleRule>
    lateinit var GHAST_FIREBALL_COOLDOWN: Key<IntRule>
    lateinit var SLIME_SPLIT_COUNT: Key<IntRule>
    lateinit var MAGMA_CUBE_SPLIT_COUNT: Key<IntRule>
    lateinit var MINIMUM_SLIME_SIZE: Key<IntRule>
    lateinit var BOW_DRAW_SPEED: Key<IntRule>
    lateinit var ANVIL_DAMAGE_PER_BLOCK: Key<DoubleRule>
    lateinit var ANVIL_MAX_DAMAGE: Key<IntRule>

    fun registerRules() {
        DO_CROP_TRAMPLING = GameRuleRegistry.register("doCropTrampling", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true))
        DO_OXIDIZATION = GameRuleRegistry.register("doOxidization", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true))
        DO_ICE_MELTING = GameRuleRegistry.register("doIceMelting", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true))
        DO_SAPLING_GROWTH = GameRuleRegistry.register("doSaplingGrowth", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true))
        RAIN_PUTS_OUT_FIRE = GameRuleRegistry.register("rainPutsOutFire", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true))
        DO_CROP_GROWTH = GameRuleRegistry.register("doCropGrowth", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true))
        USE_SKELETON_ACCURACY = GameRuleRegistry.register("useSkeletonAccuracy", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false))
        SKELETON_ACCURACY = GameRuleRegistry.register("skeletonAccuracy", GameRules.Category.MISC, GameRuleFactory.createIntRule(0))
        CREEPER_EXPLOSION_RADIUS = GameRuleRegistry.register("creeperExplosionRadius", GameRules.Category.MISC, GameRuleFactory.createIntRule(3))
        ENDERMAN_TELEPORT_RADIUS = GameRuleRegistry.register("endermanTeleportRadius", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(64.0))
        GHAST_FIREBALL_COOLDOWN = GameRuleRegistry.register("ghastFireballCooldown", GameRules.Category.MISC, GameRuleFactory.createIntRule(60))
        SLIME_SPLIT_COUNT = GameRuleRegistry.register("slimeSplitCount", GameRules.Category.MISC, GameRuleFactory.createIntRule(2))
        MAGMA_CUBE_SPLIT_COUNT = GameRuleRegistry.register("magmaCubeSplitCount", GameRules.Category.MISC, GameRuleFactory.createIntRule(2))
        BOW_DRAW_SPEED = GameRuleRegistry.register("bowDrawTime", GameRules.Category.MISC, GameRuleFactory.createIntRule(20))
        MINIMUM_SLIME_SIZE = GameRuleRegistry.register("minimumSlimeSize", GameRules.Category.MISC, GameRuleFactory.createIntRule(1))
        ANVIL_DAMAGE_PER_BLOCK = GameRuleRegistry.register("anvilDamagePerBlock", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(2.0))
        ANVIL_MAX_DAMAGE = GameRuleRegistry.register("anvilMaxDamage", GameRules.Category.MISC, GameRuleFactory.createIntRule(40))
    }
}