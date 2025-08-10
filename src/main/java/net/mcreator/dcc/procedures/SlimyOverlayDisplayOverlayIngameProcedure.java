package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.init.DccModMobEffects;

public class SlimyOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (1 < (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DccModMobEffects.SLIMY) ? _livEnt.getEffect(DccModMobEffects.SLIMY).getAmplifier() : 0)) {
			return true;
		}
		return false;
	}
}
