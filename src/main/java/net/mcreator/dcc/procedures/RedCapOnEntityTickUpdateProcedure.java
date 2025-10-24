package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.dcc.init.DccModMobEffects;
import net.mcreator.dcc.entity.RedCapEntity;
import net.mcreator.dcc.DccMod;

import java.util.Comparator;

public class RedCapOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 400) == 1) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof RedCapEntity) {
					((RedCapEntity) entity).setAnimation("cast");
				}
				DccMod.queueServerWork(10, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator instanceof RedCapEntity)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(DccModMobEffects.BUTTERFLY_CURSE, 300, 1, false, false));
							}
						}
					}
				});
			}
		}
	}
}