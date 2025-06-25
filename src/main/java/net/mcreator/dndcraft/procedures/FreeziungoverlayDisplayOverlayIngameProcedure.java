package net.mcreator.dndcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.init.DndCraftModMobEffects;

public class FreeziungoverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (1 < (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DndCraftModMobEffects.FREEZING.get()) ? _livEnt.getEffect(DndCraftModMobEffects.FREEZING.get()).getAmplifier() : 0)) {
			return true;
		}
		return false;
	}
}
