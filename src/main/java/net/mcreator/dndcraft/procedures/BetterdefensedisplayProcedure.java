package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.init.DndCraftModMobEffects;

public class BetterdefensedisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (1 < (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DndCraftModMobEffects.KI_EFFECT) ? _livEnt.getEffect(DndCraftModMobEffects.KI_EFFECT).getAmplifier() : 0)) {
			return true;
		}
		return false;
	}
}
