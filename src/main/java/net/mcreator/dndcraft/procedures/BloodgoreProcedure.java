package net.mcreator.dndcraft.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.dndcraft.init.DndCraftModParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BloodgoreProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, double amount) {
		execute(null, world, x, y, z, damagesource, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, double amount) {
		if (damagesource == null)
			return;
		if (!(damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.FREEZE) || damagesource.is(DamageTypes.DRY_OUT) || damagesource.is(DamageTypes.MAGIC) || damagesource.is(DamageTypes.DROWN)
				|| damagesource.is(DamageTypes.FALLING_BLOCK) || damagesource.is(DamageTypes.LAVA))) {
			if (300 > 3 * amount) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (DndCraftModParticleTypes.BLOOD.get()), x, (y + 1), z, (int) (3 * amount), 0, 0, 0, 1);
			} else if (true) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (DndCraftModParticleTypes.BLOOD.get()), x, (y + 1), z, 500, 0, 0, 0, 1);
			}
		}
	}
}
