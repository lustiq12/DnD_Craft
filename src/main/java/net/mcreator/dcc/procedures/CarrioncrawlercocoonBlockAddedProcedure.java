package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModBlocks;

public class CarrioncrawlercocoonBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), DccModBlocks.CARRIONCRAWLERCOCOON.get().defaultBlockState(), 3);
	}
}