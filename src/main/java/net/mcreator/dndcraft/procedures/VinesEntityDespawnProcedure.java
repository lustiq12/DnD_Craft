package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.DndCraftMod;

public class VinesEntityDespawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DndCraftMod.queueServerWork(130, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
