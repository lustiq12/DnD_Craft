package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class FakelifeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).PlayerLevel > 2) {
			{
				DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
				_vars.Spell = "fakelife";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
