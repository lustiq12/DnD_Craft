
package net.mcreator.dndcraft.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;

public class AdamantiumSickleItem extends HoeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 2000;
		}

		@Override
		public float getSpeed() {
			return 12f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 2;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of();
		}
	};

	public AdamantiumSickleItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 5f, -2.1f)));
	}
}
