package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

public class SoapRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(1, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_COBBLESTONE.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_COBBLESTONE_STAIRS.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.COBBLESTONE_STAIRS.defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.COBBLESTONE_SLAB.defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_STONE_BRICKS.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.STONE_BRICKS.defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.STONE_BRICK_STAIRS.defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.STONE_BRICK_SLAB.defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_STONE_BRICK_WALL.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.STONE_BRICK_WALL.defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == Blocks.MOSSY_COBBLESTONE_WALL.defaultBlockState()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.COBBLESTONE_WALL.defaultBlockState(), 3);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
	}
}
