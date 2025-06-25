package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.dndcraft.DndCraftMod;

public class IronGoblinOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DndCraftMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 50000, 100000), () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
