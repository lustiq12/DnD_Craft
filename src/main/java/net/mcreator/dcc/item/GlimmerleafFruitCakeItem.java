package net.mcreator.dcc.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.dcc.procedures.RegenerationProcedure;

import java.util.List;

public class GlimmerleafFruitCakeItem extends Item {
	public GlimmerleafFruitCakeItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(16).saturationModifier(12.2f).build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.dcc.glimmerleaf_fruit_cake.description_0"));
		list.add(Component.translatable("item.dcc.glimmerleaf_fruit_cake.description_1"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		RegenerationProcedure.execute(entity);
		return retval;
	}
}