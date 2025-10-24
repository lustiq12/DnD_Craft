package net.mcreator.dcc.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class RawOrkBeefItem extends Item {
	public RawOrkBeefItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0f).build()));
	}
}