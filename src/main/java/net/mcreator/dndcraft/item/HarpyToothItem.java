
package net.mcreator.dndcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HarpyToothItem extends Item {
	public HarpyToothItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
