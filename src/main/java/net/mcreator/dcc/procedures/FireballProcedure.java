package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;

public class FireballProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel > 5) {
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.Spell = "fireball";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}