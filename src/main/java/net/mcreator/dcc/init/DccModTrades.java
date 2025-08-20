/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.dcc.init;

import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@EventBusSubscriber
public class DccModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.COPPER_COIN.get(), 7), new ItemStack(DccModItems.MONSTER_DAGGER.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 2), new ItemStack(DccModItems.HARPY_SPEAR.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.SILVER_COIN.get(), 4), new ItemStack(DccModItems.COOKED_ORK_BEEF.get(), 5), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get()), new ItemStack(DccModItems.ANIMAL_BONE.get(), 15), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.SILVER_COIN.get(), 6), new ItemStack(DccModItems.RAW_OWLBEAR_MEAT.get(), 3), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 60), new ItemStack(DccModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 2), new ItemStack(DccModItems.HARPY_TOOTH.get(), 3), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.PLATIN_COIN.get(), 9), new ItemStack(DccModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.PLATIN_COIN.get()), new ItemStack(Items.TOTEM_OF_UNDYING), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.RAW_ORK_BEEF.get(), 5), new ItemStack(DccModItems.COPPER_COIN.get(), 5), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.RAW_OWLBEAR_MEAT.get()), new ItemStack(DccModItems.SILVER_COIN.get(), 2), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.RUSTY_MACE.get()), new ItemStack(DccModItems.COPPER_COIN.get(), 4), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.MONSTER_DAGGER.get()), new ItemStack(DccModItems.COPPER_COIN.get(), 2), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DccModItems.COPPER_COIN.get(), 10), new ItemStack(DccModItems.SILVER_COIN.get()), 10, 5, 0f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.TOOLSMITH) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(DccModItems.COPPER_COIN.get(), 50), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(DccModItems.SILVER_COIN.get(), 5), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(DccModItems.GOLD_COIN.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 60), new ItemStack(DccModItems.PLATIN_COIN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DccModBlocks.SCRAPBLOCK.get(), 2), new ItemStack(DccModItems.SILVER_COIN.get(), 16), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DccModItems.SCRAPSHEET.get()), new ItemStack(DccModItems.SILVER_COIN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 5), new ItemStack(DccModItems.AX.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 2), new ItemStack(DccModItems.DAGGER.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 2), new ItemStack(DccModItems.LIGHT_HAMMER.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DccModItems.SILVER_COIN.get(), 2), new ItemStack(DccModItems.BATTLE_STAFF.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DccModItems.SILVER_COIN.get()), new ItemStack(DccModItems.CLUB.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get()), new ItemStack(DccModItems.SICKLE.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get()), new ItemStack(DccModItems.SPEAR.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 5), new ItemStack(DccModItems.MACE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DccModItems.SILVER_COIN.get(), 2), new ItemStack(DccModItems.ZWO_HANDED_CLUB.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 8), new ItemStack(Items.TRIDENT), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 15), new ItemStack(DccModItems.WAR_HAMMER.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 25), new ItemStack(DccModItems.SCIMITAR.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 10), new ItemStack(DccModItems.GLADIUS.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 15), new ItemStack(DccModItems.CLAYMORE.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 10), new ItemStack(DccModItems.BATTLE_AXE.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 30), new ItemStack(DccModItems.TWO_HANDED_AXE.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 10), new ItemStack(DccModItems.TWO_HANDEDHAMMER.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 50), new ItemStack(DccModItems.TWO_HANDED_CLAYMORE.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DccModItems.PLATIN_COIN.get(), 2), new ItemStack(DccModItems.RAW_ADAMANTIUM_ORE.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DccModItems.COPPER_COIN.get(), 10), new ItemStack(DccModItems.SILVER_COIN.get()), 10, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DccModItems.SILVER_COIN.get(), 10), new ItemStack(DccModItems.GOLD_COIN.get()), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get()), new ItemStack(DccModItems.SILVER_COIN.get(), 10), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DccModItems.SILVER_COIN.get()), new ItemStack(DccModItems.COPPER_COIN.get(), 10), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DccModItems.GOLD_COIN.get(), 10), new ItemStack(DccModItems.PLATIN_COIN.get()), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DccModItems.PLATIN_COIN.get()), new ItemStack(DccModItems.GOLD_COIN.get(), 10), 10, 5, 0f));
		}
	}
}