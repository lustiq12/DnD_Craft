
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DccModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> KEEP_CLASS_LEVELS_AND_GET_NO_STARTERITEMS_ON_RESPAWN;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		KEEP_CLASS_LEVELS_AND_GET_NO_STARTERITEMS_ON_RESPAWN = GameRules.register("keepClassLevelsAndGetNoStarteritemsOnRespawn", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	}
}
