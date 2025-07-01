package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class DisplaybuttonProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("false")) {
			return true;
		}
		return false;
	}
}
