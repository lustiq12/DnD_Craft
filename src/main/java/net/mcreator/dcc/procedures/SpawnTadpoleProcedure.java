package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModEntities;
import net.mcreator.dcc.entity.BullywugEntity;

public class SpawnTadpoleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof BullywugEntity _datEntI ? _datEntI.getEntityData().get(BullywugEntity.DATA_Generation) : 0) == 1)) {
			if (Mth.nextInt(RandomSource.create(), 1, 10000) == 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DccModEntities.BULLYWUG_TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}