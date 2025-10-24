package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.dcc.init.DccModParticleTypes;

public class ButterflyCurseOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (DccModParticleTypes.BUTTERFLY_PARTICLE.get()), x, y, z, 20, 2, 3, 2, 0);
	}
}