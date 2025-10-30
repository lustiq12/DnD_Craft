package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.entity.SlotMachineEntityEntity;

import java.util.Comparator;

public class SlotMachineOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((findEntityInWorldRange(world, SlotMachineEntityEntity.class, x, y, z, 2)) instanceof SlotMachineEntityEntity _datEntSetL)
			_datEntSetL.getEntityData().set(SlotMachineEntityEntity.DATA_Clicked, true);
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}