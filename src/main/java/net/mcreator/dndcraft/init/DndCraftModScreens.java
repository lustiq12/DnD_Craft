
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.dndcraft.client.gui.MonkGuiScreen;
import net.mcreator.dndcraft.client.gui.MagierguiScreen;
import net.mcreator.dndcraft.client.gui.MagicChooseScreen;
import net.mcreator.dndcraft.client.gui.KiScreen;
import net.mcreator.dndcraft.client.gui.DruidGuiScreen;
import net.mcreator.dndcraft.client.gui.CookGuiScreen;
import net.mcreator.dndcraft.client.gui.ClassesScreen;
import net.mcreator.dndcraft.client.gui.BardeguiScreen;
import net.mcreator.dndcraft.client.gui.BarbarGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DndCraftModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DndCraftModMenus.CLASSES.get(), ClassesScreen::new);
			MenuScreens.register(DndCraftModMenus.BARBAR_GUI.get(), BarbarGuiScreen::new);
			MenuScreens.register(DndCraftModMenus.BARDEGUI.get(), BardeguiScreen::new);
			MenuScreens.register(DndCraftModMenus.MAGIC_CHOOSE.get(), MagicChooseScreen::new);
			MenuScreens.register(DndCraftModMenus.MAGIERGUI.get(), MagierguiScreen::new);
			MenuScreens.register(DndCraftModMenus.MONK_GUI.get(), MonkGuiScreen::new);
			MenuScreens.register(DndCraftModMenus.KI.get(), KiScreen::new);
			MenuScreens.register(DndCraftModMenus.COOK_GUI.get(), CookGuiScreen::new);
			MenuScreens.register(DndCraftModMenus.DRUID_GUI.get(), DruidGuiScreen::new);
		});
	}
}
