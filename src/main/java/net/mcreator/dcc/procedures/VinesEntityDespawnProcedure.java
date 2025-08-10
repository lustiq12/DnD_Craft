package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.DccMod;

public class VinesEntityDespawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DccMod.queueServerWork(130, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
