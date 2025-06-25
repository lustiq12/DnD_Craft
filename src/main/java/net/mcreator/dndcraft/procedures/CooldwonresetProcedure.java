package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class CooldwonresetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.cooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
