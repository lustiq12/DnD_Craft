package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.dcc.DccMod;

import java.util.Comparator;

public class TentaclesEntityDespawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		DccMod.queueServerWork(130, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		if (!((findEntityInWorldRange(world, Player.class, x, y, z, 4)) == null)) {
			{
				Entity _ent = entity;
				_ent.teleportTo(((findEntityInWorldRange(world, Player.class, x, y, z, 4)).getX()), ((findEntityInWorldRange(world, Player.class, x, y, z, 4)).getY()), ((findEntityInWorldRange(world, Player.class, x, y, z, 4)).getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(((findEntityInWorldRange(world, Player.class, x, y, z, 4)).getX()), ((findEntityInWorldRange(world, Player.class, x, y, z, 4)).getY()),
							((findEntityInWorldRange(world, Player.class, x, y, z, 4)).getZ()), _ent.getYRot(), _ent.getXRot());
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}