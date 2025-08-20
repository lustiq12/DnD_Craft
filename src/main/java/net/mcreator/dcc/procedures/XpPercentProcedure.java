package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;

public class XpPercentProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Math.round(entity.getData(DccModVariables.PLAYER_VARIABLES).XpPercent) + "% to next level";
	}
}