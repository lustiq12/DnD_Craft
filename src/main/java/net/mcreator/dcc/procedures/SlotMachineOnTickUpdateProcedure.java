package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModBlocks;
import net.mcreator.dcc.entity.SlotMachineEntityEntity;

import java.util.Comparator;

public class SlotMachineOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == DccModBlocks.SLOT_MACHINE.get()) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == DccModBlocks.SLOT_MACHINE.get())) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (findEntityInWorldRange(world, SlotMachineEntityEntity.class, x, y, z, 1) != null) {
				if (!(findEntityInWorldRange(world, SlotMachineEntityEntity.class, x, y, z, 1)).level().isClientSide())
					(findEntityInWorldRange(world, SlotMachineEntityEntity.class, x, y, z, 1)).discard();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}