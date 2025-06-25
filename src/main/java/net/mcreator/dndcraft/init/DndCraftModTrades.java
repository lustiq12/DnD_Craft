
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.dndcraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DndCraftModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.COPPER_COIN.get(), 7),

				new ItemStack(DndCraftModItems.MONSTER_DAGGER.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 2),

				new ItemStack(DndCraftModItems.HARPY_SPEAR.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.IRON_COIN.get(), 4),

				new ItemStack(DndCraftModItems.COOKED_ORK_BEEF.get(), 5), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get()),

				new ItemStack(DndCraftModItems.ANIMAL_BONE.get(), 15), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.IRON_COIN.get(), 6),

				new ItemStack(DndCraftModItems.RAW_OWLBEAR_MEAT.get(), 3), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 60),

				new ItemStack(DndCraftModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 2),

				new ItemStack(DndCraftModItems.HARPY_TOOTH.get(), 3), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.ADAMANTIUM_COIN.get(), 9),

				new ItemStack(DndCraftModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.ADAMANTIUM_COIN.get()),

				new ItemStack(Items.TOTEM_OF_UNDYING), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.RAW_ORK_BEEF.get(), 5),

				new ItemStack(DndCraftModItems.COPPER_COIN.get(), 5), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.RAW_OWLBEAR_MEAT.get()),

				new ItemStack(DndCraftModItems.IRON_COIN.get(), 2), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.RUSTY_MACE.get()),

				new ItemStack(DndCraftModItems.COPPER_COIN.get(), 4), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.MONSTER_DAGGER.get()),

				new ItemStack(DndCraftModItems.COPPER_COIN.get(), 2), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(DndCraftModItems.COPPER_COIN.get(), 10),

				new ItemStack(DndCraftModItems.IRON_COIN.get()), 10, 5, 0f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.TOOLSMITH) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3),

					new ItemStack(DndCraftModItems.COPPER_COIN.get(), 50), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3),

					new ItemStack(DndCraftModItems.IRON_COIN.get(), 5), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6),

					new ItemStack(DndCraftModItems.GOLD_COIN.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 60),

					new ItemStack(DndCraftModItems.ADAMANTIUM_COIN.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DndCraftModBlocks.SCRAPBLOCK.get(), 2),

					new ItemStack(DndCraftModItems.IRON_COIN.get(), 16), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DndCraftModItems.SCRAPSHEET.get()),

					new ItemStack(DndCraftModItems.IRON_COIN.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 5),

					new ItemStack(DndCraftModItems.AX.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 2),

					new ItemStack(DndCraftModItems.DAGGER.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 2),

					new ItemStack(DndCraftModItems.LIGHT_HAMMER.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DndCraftModItems.IRON_COIN.get(), 2),

					new ItemStack(DndCraftModItems.BATTLE_STAFF.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DndCraftModItems.IRON_COIN.get()),

					new ItemStack(DndCraftModItems.CLUB.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get()),

					new ItemStack(DndCraftModItems.SICKLE.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get()),

					new ItemStack(DndCraftModItems.SPEAR.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 5),

					new ItemStack(DndCraftModItems.MACE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(DndCraftModItems.IRON_COIN.get(), 2),

					new ItemStack(DndCraftModItems.ZWO_HANDED_CLUB.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 8),

					new ItemStack(Items.TRIDENT), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 15),

					new ItemStack(DndCraftModItems.WAR_HAMMER.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 25),

					new ItemStack(DndCraftModItems.SCIMITAR.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 10),

					new ItemStack(DndCraftModItems.GLADIUS.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 15),

					new ItemStack(DndCraftModItems.CLAYMORE.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 10),

					new ItemStack(DndCraftModItems.BATTLE_AXE.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 30),

					new ItemStack(DndCraftModItems.TWO_HANDED_AXE.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 10),

					new ItemStack(DndCraftModItems.TWO_HANDEDHAMMER.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 50),

					new ItemStack(DndCraftModItems.TWO_HANDED_CLAYMORE.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(DndCraftModItems.ADAMANTIUM_COIN.get(), 2),

					new ItemStack(DndCraftModItems.RAW_ADAMANTIUM_ORE.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DndCraftModItems.COPPER_COIN.get(), 10),

					new ItemStack(DndCraftModItems.IRON_COIN.get()), 10, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(DndCraftModItems.IRON_COIN.get(), 10),

					new ItemStack(DndCraftModItems.GOLD_COIN.get()), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get()),

					new ItemStack(DndCraftModItems.IRON_COIN.get(), 10), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(DndCraftModItems.IRON_COIN.get()),

					new ItemStack(DndCraftModItems.COPPER_COIN.get(), 10), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DndCraftModItems.GOLD_COIN.get(), 10),

					new ItemStack(DndCraftModItems.ADAMANTIUM_COIN.get()), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(DndCraftModItems.ADAMANTIUM_COIN.get()),

					new ItemStack(DndCraftModItems.GOLD_COIN.get(), 10), 10, 5, 0f));
		}
	}
}
