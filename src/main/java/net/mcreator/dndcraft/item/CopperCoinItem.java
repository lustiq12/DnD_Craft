
package net.mcreator.dndcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CopperCoinItem extends Item {
	public CopperCoinItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
