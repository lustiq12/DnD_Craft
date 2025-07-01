package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class MonsterquestunlockProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).DailyRationQuest == -1) {
			return true;
		}
		return false;
	}
}
