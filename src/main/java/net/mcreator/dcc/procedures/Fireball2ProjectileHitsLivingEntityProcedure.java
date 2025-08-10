package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class Fireball2ProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(15);
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 15);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 3, Level.ExplosionInteraction.MOB);
	}
}
