package net.mcreator.dndcraft.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class DodgeOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Dogde == true) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana > 9) {
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SCULK_SOUL, x, y, z, 2000, 1, 1, 1, 1);
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana - 10;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
