package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;

public class CooldwonresetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
			_vars.cooldown = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}
