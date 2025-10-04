package net.mcreator.dcc.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class GlimmerleafFruitItem extends Item {
	public GlimmerleafFruitItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(1f).build()));
	}
}