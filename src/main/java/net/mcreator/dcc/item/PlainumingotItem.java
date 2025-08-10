
package net.mcreator.dcc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PlainumingotItem extends Item {
	public PlainumingotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
