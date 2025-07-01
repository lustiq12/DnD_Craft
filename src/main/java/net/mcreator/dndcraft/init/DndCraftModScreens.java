
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.dndcraft.client.gui.MonkGuiScreen;
import net.mcreator.dndcraft.client.gui.MagierguiScreen;
import net.mcreator.dndcraft.client.gui.MagicChooseScreen;
import net.mcreator.dndcraft.client.gui.KiScreen;
import net.mcreator.dndcraft.client.gui.DruidGuiScreen;
import net.mcreator.dndcraft.client.gui.CookGuiScreen;
import net.mcreator.dndcraft.client.gui.ClassesScreen;
import net.mcreator.dndcraft.client.gui.BardeguiScreen;
import net.mcreator.dndcraft.client.gui.BarbarGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DndCraftModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(DndCraftModMenus.CLASSES.get(), ClassesScreen::new);
		event.register(DndCraftModMenus.BARBAR_GUI.get(), BarbarGuiScreen::new);
		event.register(DndCraftModMenus.BARDEGUI.get(), BardeguiScreen::new);
		event.register(DndCraftModMenus.MAGIC_CHOOSE.get(), MagicChooseScreen::new);
		event.register(DndCraftModMenus.MAGIERGUI.get(), MagierguiScreen::new);
		event.register(DndCraftModMenus.MONK_GUI.get(), MonkGuiScreen::new);
		event.register(DndCraftModMenus.KI.get(), KiScreen::new);
		event.register(DndCraftModMenus.COOK_GUI.get(), CookGuiScreen::new);
		event.register(DndCraftModMenus.DRUID_GUI.get(), DruidGuiScreen::new);
	}
}
