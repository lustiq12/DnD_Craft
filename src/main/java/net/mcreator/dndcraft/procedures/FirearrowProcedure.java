package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class FirearrowProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "firearrow";
			entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Spell = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
