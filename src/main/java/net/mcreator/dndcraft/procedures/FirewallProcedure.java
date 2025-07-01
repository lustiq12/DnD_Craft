package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class FirewallProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).PlayerLevel > 8) {
			{
				DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
				_vars.Spell = "firewall";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
