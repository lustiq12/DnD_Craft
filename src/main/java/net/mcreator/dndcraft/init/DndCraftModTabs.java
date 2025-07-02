
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

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

import net.mcreator.dndcraft.DndCraftMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DndCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DndCraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DN_D = REGISTRY.register("dn_d",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.dnd_craft.dn_d")).icon(() -> new ItemStack(DndCraftModItems.MAGICSCROLL_FIREARROW.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DndCraftModItems.MONSTER_DAGGER.get());
				tabData.accept(DndCraftModItems.POISONED_DAGGER.get());
				tabData.accept(DndCraftModItems.RUSTY_MACE.get());
				tabData.accept(DndCraftModItems.DAGGER.get());
				tabData.accept(DndCraftModItems.AX.get());
				tabData.accept(DndCraftModItems.LIGHT_HAMMER.get());
				tabData.accept(DndCraftModItems.BATTLE_STAFF.get());
				tabData.accept(DndCraftModItems.CLUB.get());
				tabData.accept(DndCraftModItems.ZWO_HANDED_CLUB.get());
				tabData.accept(DndCraftModItems.SPEAR.get());
				tabData.accept(DndCraftModItems.MACE.get());
				tabData.accept(DndCraftModItems.METAL_ROD.get());
				tabData.accept(DndCraftModItems.GLADIUS.get());
				tabData.accept(DndCraftModItems.CLAYMORE.get());
				tabData.accept(DndCraftModItems.TWO_HANDEDHAMMER.get());
				tabData.accept(DndCraftModItems.WAR_HAMMER.get());
				tabData.accept(DndCraftModItems.TWO_HANDED_AXE.get());
				tabData.accept(DndCraftModItems.BATTLE_AXE.get());
				tabData.accept(DndCraftModItems.TWO_HANDED_CLAYMORE.get());
				tabData.accept(DndCraftModItems.SCIMITAR.get());
				tabData.accept(DndCraftModItems.SICKLE.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_DAGGER.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_AX.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_CLAYMORE.get());
				tabData.accept(DndCraftModItems.LIGHT_ADAMANTIUM_HAMMER.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_SPEAR.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_MACE.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_GLADIUS.get());
				tabData.accept(DndCraftModItems.TWO_HANDED_ADAMANTIUM_HAMMER.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_WAR_HAMMER.get());
				tabData.accept(DndCraftModItems.TWO_HANDED_ADAMANTIUM_AXE.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_BATTLE_AXE.get());
				tabData.accept(DndCraftModItems.TWO_HANDED_ADAMANTIUM_CLAYMORE.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_SCIMITAR.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_SICKLE.get());
				tabData.accept(DndCraftModItems.HARPY_SPEAR.get());
				tabData.accept(DndCraftModItems.RAW_OWLBEAR_MEAT.get());
				tabData.accept(DndCraftModItems.COOKED_OWLBEAR_MEAT.get());
				tabData.accept(DndCraftModItems.RAW_ORK_BEEF.get());
				tabData.accept(DndCraftModItems.COOKED_ORK_BEEF.get());
				tabData.accept(DndCraftModItems.PLATIN_COIN.get());
				tabData.accept(DndCraftModItems.GOLD_COIN.get());
				tabData.accept(DndCraftModItems.SILVER_COIN.get());
				tabData.accept(DndCraftModItems.COPPER_COIN.get());
				tabData.accept(DndCraftModItems.POISON_VIAL.get());
				tabData.accept(DndCraftModItems.HEAL_POTION.get());
				tabData.accept(DndCraftModItems.POTIONOFSTRONGHEALING.get());
				tabData.accept(DndCraftModItems.SUPERIOR_POTIONOF_HEALING.get());
				tabData.accept(DndCraftModItems.ULTIMATE_POTIONOFHEALING.get());
				tabData.accept(DndCraftModBlocks.COOKED_OWLBEAR_MEAT_BLOCK.get().asItem());
				tabData.accept(DndCraftModBlocks.COOKEDOWLBEARMEATBLOCK_2.get().asItem());
				tabData.accept(DndCraftModBlocks.COOKEDOWLBEARMEATBLOCK_3.get().asItem());
				tabData.accept(DndCraftModBlocks.COOKEDOWLBEARMEATBLOCK_4.get().asItem());
				tabData.accept(DndCraftModBlocks.RAW_OWLBEARMEAT_BLOCK.get().asItem());
				tabData.accept(DndCraftModItems.SCRAPSHEET.get());
				tabData.accept(DndCraftModBlocks.SCRAPBLOCK.get().asItem());
				tabData.accept(DndCraftModItems.WARG_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.COOK_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.ORK_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.OGRE_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.HARPY_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.OWLBEAR_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.MIMIC_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.GOBLIN_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.OCHERJELLY_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.GOBLIN_CHIEF_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.BASILISK_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.INVISIBLE_STALKER_SPAWN_EGG.get());
				tabData.accept(DndCraftModItems.DAILY_RATION.get());
				tabData.accept(DndCraftModItems.OWLBEAR_DRUMSTICKS.get());
				tabData.accept(DndCraftModItems.ORKSTEAAK.get());
				tabData.accept(DndCraftModItems.OWLBEAR_MEAT_STRIPE.get());
				tabData.accept(DndCraftModItems.ANIMAL_BONE.get());
				tabData.accept(DndCraftModItems.IRON_PLATE.get());
				tabData.accept(DndCraftModItems.ANIMAL_FAT.get());
				tabData.accept(DndCraftModItems.SOAP.get());
				tabData.accept(DndCraftModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE.get());
				tabData.accept(DndCraftModItems.HARPY_TOOTH.get());
				tabData.accept(DndCraftModItems.GOBLINS_BACKPACK.get());
				tabData.accept(DndCraftModBlocks.DEEPSLATE_SILVER_ORE.get().asItem());
				tabData.accept(DndCraftModBlocks.SILVER_ORE.get().asItem());
				tabData.accept(DndCraftModItems.SILVER_INGOT.get());
				tabData.accept(DndCraftModItems.RAW_SILVER_ORE.get());
				tabData.accept(DndCraftModBlocks.PLATINUM_ORE.get().asItem());
				tabData.accept(DndCraftModItems.RAWPLATINUMORE.get());
				tabData.accept(DndCraftModItems.PLAINUMINGOT.get());
				tabData.accept(DndCraftModBlocks.ADANTIUM_ORE.get().asItem());
				tabData.accept(DndCraftModItems.RAW_ADAMANTIUM_ORE.get());
				tabData.accept(DndCraftModItems.ADANTIUM_INGOT.get());
				tabData.accept(DndCraftModItems.SPELLBOOK.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(DndCraftModItems.OGRE_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.ORK_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.HARPY_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.OWLBEAR_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.MIMIC_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.GOBLIN_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.GOBLIN_CHIEF_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.OCHERJELLY_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.BASILISK_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.WARG_SPAWN_EGG.get());
			tabData.accept(DndCraftModItems.COOK_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(DndCraftModItems.BANJO.get());
			tabData.accept(DndCraftModItems.DRUMS.get());
			tabData.accept(DndCraftModItems.FEYWILD.get());
		}
	}
}
