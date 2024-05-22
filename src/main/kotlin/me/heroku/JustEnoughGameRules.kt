package me.heroku

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BarrelBlockEntity
import net.minecraft.client.render.model.ModelLoader
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Identifier
import net.minecraft.world.GameRules
import net.minecraft.world.World
import org.slf4j.LoggerFactory
import java.util.Optional

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