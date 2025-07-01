package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class LevelNumberProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Level: " + Math.round(entity.getData(DndCraftModVariables.PLAYER_VARIABLES).PlayerLevel);
	}
}
