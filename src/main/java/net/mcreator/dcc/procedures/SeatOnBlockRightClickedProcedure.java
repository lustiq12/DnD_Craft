package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;

public class SeatOnBlockRightClickedProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		sourceentity.startRiding(entity);
	}
}