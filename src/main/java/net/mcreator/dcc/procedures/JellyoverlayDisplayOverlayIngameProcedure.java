package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.init.DccModMobEffects;

public class JellyoverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (1 < (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DccModMobEffects.JELLY) ? _livEnt.getEffect(DccModMobEffects.JELLY).getAmplifier() : 0)) {
			return true;
		}
		return false;
	}
}