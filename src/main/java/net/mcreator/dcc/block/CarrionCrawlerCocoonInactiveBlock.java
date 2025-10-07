package net.mcreator.dcc.block;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.procedures.CarrioncrawlercocoonBlockAddedProcedure;

import java.util.List;

public class CarrionCrawlerCocoonInactiveBlock extends Block {
	public CarrionCrawlerCocoonInactiveBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 10f).randomTicks());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("block.dcc.carrion_crawler_cocoon_inactive.description_0"));
		list.add(Component.translatable("block.dcc.carrion_crawler_cocoon_inactive.description_1"));
		list.add(Component.translatable("block.dcc.carrion_crawler_cocoon_inactive.description_2"));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		CarrioncrawlercocoonBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}