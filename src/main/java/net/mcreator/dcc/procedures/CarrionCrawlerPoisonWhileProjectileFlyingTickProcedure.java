package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.entity.CarrionCrawlerEntity;

public class CarrionCrawlerPoisonWhileProjectileFlyingTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("Time") == 0) {
			entity.getPersistentData().putDouble("Time", 1);
		} else {
			entity.getPersistentData().putDouble("Time", (entity.getPersistentData().getDouble("Time") + 1));
		}
		if (entity.getPersistentData().getDouble("Time") > 5) {
			if (!(entity instanceof CarrionCrawlerEntity) && !(entity == null)) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}