package net.mcreator.dndcraft.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.dndcraft.init.DndCraftModParticleTypes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BloodgoreProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource) {
		execute(null, world, x, y, z, damagesource);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource) {
		if (damagesource == null)
			return;
		if (!(damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.FREEZE) || damagesource.is(DamageTypes.DRY_OUT) || damagesource.is(DamageTypes.MAGIC) || damagesource.is(DamageTypes.DROWN)
				|| damagesource.is(DamageTypes.FALLING_BLOCK))) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DndCraftModParticleTypes.BLOOD.get()), x, y, z, 50, 0, 0, 0, 1);
		}
	}
}
