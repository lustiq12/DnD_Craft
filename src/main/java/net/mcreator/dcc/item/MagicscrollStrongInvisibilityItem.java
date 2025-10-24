package net.mcreator.dcc.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.dcc.procedures.StronginvisibilityCastProcedure;

import java.util.List;

public class MagicscrollStrongInvisibilityItem extends Item {
	public MagicscrollStrongInvisibilityItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("-Strong Invisibility"));
		list.add(Component.literal("Magic Item"));
		list.add(Component.literal("\u00A7Common"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		StronginvisibilityCastProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}
}