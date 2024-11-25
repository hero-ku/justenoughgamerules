package me.heroku

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents
import net.minecraft.server.world.ServerWorld
import org.slf4j.LoggerFactory

object JustEnoughGameRules : ModInitializer {
    private val logger = LoggerFactory.getLogger("justenoughgamerules")
	var currentWorld: ServerWorld? = null

	override fun onInitialize() {
		ServerWorldEvents.LOAD.register { _, world ->
			currentWorld = world
		}
		Rules.registerRules()
	}
}