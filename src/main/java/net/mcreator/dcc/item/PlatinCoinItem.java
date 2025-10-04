package net.mcreator.dcc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PlatinCoinItem extends Item {
	public PlatinCoinItem() {
		super(new Item.Properties().rarity(Rarity.EPIC));
	}
}