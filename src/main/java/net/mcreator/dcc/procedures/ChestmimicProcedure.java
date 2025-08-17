package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModEntities;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ChestmimicProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CHEST) {
			if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
				sx = -1;
				found = false;
				for (int index0 = 0; index0 < 3; index0++) {
					sy = -1;
					for (int index1 = 0; index1 < 3; index1++) {
						sz = -1;
						for (int index2 = 0; index2 < 3; index2++) {
							if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("dcc:mimic_spawnable")))) {
								if (!(found == true)) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = DccModEntities.MIMIC.get().spawn(_level, BlockPos.containing(x + sx, y + sy, z + sz), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								}
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			}
		}
	}
}
