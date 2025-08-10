package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class HarpyOnEntityTickUpdateProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
			sourceentity.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-2)), (entity.getLookAngle().y * (-2)), (entity.getLookAngle().z * (-2))));
		}
	}
}
