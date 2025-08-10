package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;

public class VeteranquestshowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(DccModVariables.PLAYER_VARIABLES).CookingVeteranquest > 79) {
			return true;
		}
		return false;
	}
}
