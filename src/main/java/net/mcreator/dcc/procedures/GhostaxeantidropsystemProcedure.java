package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.init.DccModItems;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class GhostaxeantidropsystemProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		execute(null, world, x, y, z, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (itemstack.getItem() == DccModItems.GHOST_AXE.get()) {
			if (!(findEntityInWorldRange(world, ItemEntity.class, x, y, z, 0.25)).level().isClientSide())
				(findEntityInWorldRange(world, ItemEntity.class, x, y, z, 0.25)).discard();
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}