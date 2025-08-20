package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;

public class PaladinFlyOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("Fly", true);
	}
}