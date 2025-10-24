package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModEntities;
import net.mcreator.dcc.entity.CarrionCrawlerEntity;
import net.mcreator.dcc.entity.BullywugEntity;

public class TadpoleGrowUpKiddoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("Time") == 0) {
			entity.getPersistentData().putDouble("Time", 1);
		} else {
			entity.getPersistentData().putDouble("Time", (entity.getPersistentData().getDouble("Time") + 1));
		}
		if (entity.getPersistentData().getDouble("Time") > 500) {
			if (!(entity instanceof CarrionCrawlerEntity) && !(entity == null)) {
				if (!entity.level().isClientSide())
					entity.discard();
				if ((world instanceof ServerLevel _level8 ? DccModEntities.BULLYWUG.get().spawn(_level8, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED) : null) instanceof BullywugEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BullywugEntity.DATA_Generation, 1);
			}
		}
	}
}