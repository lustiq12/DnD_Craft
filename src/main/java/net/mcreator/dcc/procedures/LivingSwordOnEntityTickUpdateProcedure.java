package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class LivingSwordOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.getPersistentData().putDouble("despawn", (entity.getPersistentData().getDouble("despawn") + 1));
			if (300 <= entity.getPersistentData().getDouble("despawn")) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}