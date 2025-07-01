package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class NightvisionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).PlayerLevel > 4) {
			{
				DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
				_vars.Spell = "nightvision";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
