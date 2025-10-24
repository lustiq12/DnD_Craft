package net.mcreator.dcc.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CookedOrkBeefItem extends Item {
	public CookedOrkBeefItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(7).saturationModifier(2f).build()));
	}
}