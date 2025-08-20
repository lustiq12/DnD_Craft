package net.mcreator.dcc.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.dcc.procedures.MagicscrollFirearrowRightclickedProcedure;

import java.util.List;

public class MagicscrollFirearrowItem extends Item {
	public MagicscrollFirearrowItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.dcc.magicscroll_firearrow.description_0"));
		list.add(Component.translatable("item.dcc.magicscroll_firearrow.description_1"));
		list.add(Component.translatable("item.dcc.magicscroll_firearrow.description_2"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		MagicscrollFirearrowRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}