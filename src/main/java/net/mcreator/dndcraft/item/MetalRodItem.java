
package net.mcreator.dndcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MetalRodItem extends Item {
	public MetalRodItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
