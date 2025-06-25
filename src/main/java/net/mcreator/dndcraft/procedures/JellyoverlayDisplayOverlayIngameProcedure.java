package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.init.DndCraftModMobEffects;

public class JellyoverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (1 < (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DndCraftModMobEffects.JELLY.get()) ? _livEnt.getEffect(DndCraftModMobEffects.JELLY.get()).getAmplifier() : 0)) {
			return true;
		}
		return false;
	}
}
