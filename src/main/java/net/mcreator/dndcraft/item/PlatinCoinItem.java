
package net.mcreator.dndcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PlatinCoinItem extends Item {
	public PlatinCoinItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}
}
