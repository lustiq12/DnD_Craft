
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.dcc.DccMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DccModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DccMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DN_D = REGISTRY.register("dn_d",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.dcc.dn_d")).icon(() -> new ItemStack(DccModItems.MAGICSCROLL_FIREARROW.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DccModItems.MONSTER_DAGGER.get());
				tabData.accept(DccModItems.POISONED_DAGGER.get());
				tabData.accept(DccModItems.RUSTY_MACE.get());
				tabData.accept(DccModItems.DAGGER.get());
				tabData.accept(DccModItems.AX.get());
				tabData.accept(DccModItems.LIGHT_HAMMER.get());
				tabData.accept(DccModItems.BATTLE_STAFF.get());
				tabData.accept(DccModItems.CLUB.get());
				tabData.accept(DccModItems.ZWO_HANDED_CLUB.get());
				tabData.accept(DccModItems.SPEAR.get());
				tabData.accept(DccModItems.MACE.get());
				tabData.accept(DccModItems.METAL_ROD.get());
				tabData.accept(DccModItems.GLADIUS.get());
				tabData.accept(DccModItems.CLAYMORE.get());
				tabData.accept(DccModItems.TWO_HANDEDHAMMER.get());
				tabData.accept(DccModItems.WAR_HAMMER.get());
				tabData.accept(DccModItems.TWO_HANDED_AXE.get());
				tabData.accept(DccModItems.BATTLE_AXE.get());
				tabData.accept(DccModItems.TWO_HANDED_CLAYMORE.get());
				tabData.accept(DccModItems.SCIMITAR.get());
				tabData.accept(DccModItems.SICKLE.get());
				tabData.accept(DccModItems.ADAMANTIUM_DAGGER.get());
				tabData.accept(DccModItems.ADAMANTIUM_AX.get());
				tabData.accept(DccModItems.ADAMANTIUM_CLAYMORE.get());
				tabData.accept(DccModItems.LIGHT_ADAMANTIUM_HAMMER.get());
				tabData.accept(DccModItems.ADAMANTIUM_SPEAR.get());
				tabData.accept(DccModItems.ADAMANTIUM_MACE.get());
				tabData.accept(DccModItems.ADAMANTIUM_GLADIUS.get());
				tabData.accept(DccModItems.TWO_HANDED_ADAMANTIUM_HAMMER.get());
				tabData.accept(DccModItems.ADAMANTIUM_WAR_HAMMER.get());
				tabData.accept(DccModItems.TWO_HANDED_ADAMANTIUM_AXE.get());
				tabData.accept(DccModItems.ADAMANTIUM_BATTLE_AXE.get());
				tabData.accept(DccModItems.TWO_HANDED_ADAMANTIUM_CLAYMORE.get());
				tabData.accept(DccModItems.ADAMANTIUM_SCIMITAR.get());
				tabData.accept(DccModItems.ADAMANTIUM_SICKLE.get());
				tabData.accept(DccModItems.HARPY_SPEAR.get());
				tabData.accept(DccModItems.RAW_OWLBEAR_MEAT.get());
				tabData.accept(DccModItems.COOKED_OWLBEAR_MEAT.get());
				tabData.accept(DccModItems.RAW_ORK_BEEF.get());
				tabData.accept(DccModItems.COOKED_ORK_BEEF.get());
				tabData.accept(DccModItems.PLATIN_COIN.get());
				tabData.accept(DccModItems.GOLD_COIN.get());
				tabData.accept(DccModItems.SILVER_COIN.get());
				tabData.accept(DccModItems.COPPER_COIN.get());
				tabData.accept(DccModItems.POISON_VIAL.get());
				tabData.accept(DccModItems.HEAL_POTION.get());
				tabData.accept(DccModItems.POTIONOFSTRONGHEALING.get());
				tabData.accept(DccModItems.SUPERIOR_POTIONOF_HEALING.get());
				tabData.accept(DccModItems.ULTIMATE_POTIONOFHEALING.get());
				tabData.accept(DccModBlocks.COOKED_OWLBEAR_MEAT_BLOCK.get().asItem());
				tabData.accept(DccModBlocks.COOKEDOWLBEARMEATBLOCK_2.get().asItem());
				tabData.accept(DccModBlocks.COOKEDOWLBEARMEATBLOCK_3.get().asItem());
				tabData.accept(DccModBlocks.COOKEDOWLBEARMEATBLOCK_4.get().asItem());
				tabData.accept(DccModBlocks.RAW_OWLBEARMEAT_BLOCK.get().asItem());
				tabData.accept(DccModItems.SCRAPSHEET.get());
				tabData.accept(DccModBlocks.SCRAPBLOCK.get().asItem());
				tabData.accept(DccModItems.WARG_SPAWN_EGG.get());
				tabData.accept(DccModItems.COOK_SPAWN_EGG.get());
				tabData.accept(DccModItems.ORK_SPAWN_EGG.get());
				tabData.accept(DccModItems.OGRE_SPAWN_EGG.get());
				tabData.accept(DccModItems.HARPY_SPAWN_EGG.get());
				tabData.accept(DccModItems.OWLBEAR_SPAWN_EGG.get());
				tabData.accept(DccModItems.MIMIC_SPAWN_EGG.get());
				tabData.accept(DccModItems.GOBLIN_SPAWN_EGG.get());
				tabData.accept(DccModItems.OCHERJELLY_SPAWN_EGG.get());
				tabData.accept(DccModItems.GOBLIN_CHIEF_SPAWN_EGG.get());
				tabData.accept(DccModItems.BASILISK_SPAWN_EGG.get());
				tabData.accept(DccModItems.INVISIBLE_STALKER_SPAWN_EGG.get());
				tabData.accept(DccModItems.DAILY_RATION.get());
				tabData.accept(DccModItems.OWLBEAR_DRUMSTICKS.get());
				tabData.accept(DccModItems.ORKSTEAAK.get());
				tabData.accept(DccModItems.OWLBEAR_MEAT_STRIPE.get());
				tabData.accept(DccModItems.ANIMAL_BONE.get());
				tabData.accept(DccModItems.IRON_PLATE.get());
				tabData.accept(DccModItems.ANIMAL_FAT.get());
				tabData.accept(DccModItems.SOAP.get());
				tabData.accept(DccModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE.get());
				tabData.accept(DccModItems.HARPY_TOOTH.get());
				tabData.accept(DccModItems.GOBLINS_BACKPACK.get());
				tabData.accept(DccModBlocks.DEEPSLATE_SILVER_ORE.get().asItem());
				tabData.accept(DccModBlocks.SILVER_ORE.get().asItem());
				tabData.accept(DccModItems.SILVER_INGOT.get());
				tabData.accept(DccModItems.RAW_SILVER_ORE.get());
				tabData.accept(DccModBlocks.PLATINUM_ORE.get().asItem());
				tabData.accept(DccModItems.RAWPLATINUMORE.get());
				tabData.accept(DccModItems.PLAINUMINGOT.get());
				tabData.accept(DccModBlocks.ADANTIUM_ORE.get().asItem());
				tabData.accept(DccModItems.RAW_ADAMANTIUM_ORE.get());
				tabData.accept(DccModItems.ADANTIUM_INGOT.get());
				tabData.accept(DccModItems.SPELLBOOK.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(DccModItems.OGRE_SPAWN_EGG.get());
			tabData.accept(DccModItems.ORK_SPAWN_EGG.get());
			tabData.accept(DccModItems.HARPY_SPAWN_EGG.get());
			tabData.accept(DccModItems.OWLBEAR_SPAWN_EGG.get());
			tabData.accept(DccModItems.MIMIC_SPAWN_EGG.get());
			tabData.accept(DccModItems.GOBLIN_SPAWN_EGG.get());
			tabData.accept(DccModItems.GOBLIN_CHIEF_SPAWN_EGG.get());
			tabData.accept(DccModItems.OCHERJELLY_SPAWN_EGG.get());
			tabData.accept(DccModItems.BASILISK_SPAWN_EGG.get());
			tabData.accept(DccModItems.WARG_SPAWN_EGG.get());
			tabData.accept(DccModItems.COOK_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(DccModItems.BANJO.get());
			tabData.accept(DccModItems.DRUMS.get());
			tabData.accept(DccModItems.FEYWILD.get());
		}
	}
}
