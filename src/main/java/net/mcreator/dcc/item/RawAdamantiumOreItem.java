
package net.mcreator.dcc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RawAdamantiumOreItem extends Item {
	public RawAdamantiumOreItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
