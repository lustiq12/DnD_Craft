
package net.mcreator.dcc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AnimalFatItem extends Item {
	public AnimalFatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
