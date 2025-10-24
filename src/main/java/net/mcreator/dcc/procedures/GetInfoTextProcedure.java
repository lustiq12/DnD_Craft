package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;

public class GetInfoTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String Result = "";
		return entity.getData(DccModVariables.PLAYER_VARIABLES).InfoText;
	}
}