package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class VeteranquestshowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).CookingVeteranquest > 79) {
			return true;
		}
		return false;
	}
}
