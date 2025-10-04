/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.dcc.client.gui.PaladinGuiScreen;
import net.mcreator.dcc.client.gui.MonkGuiScreen;
import net.mcreator.dcc.client.gui.MagierguiScreen;
import net.mcreator.dcc.client.gui.MagicChooseScreen;
import net.mcreator.dcc.client.gui.KiScreen;
import net.mcreator.dcc.client.gui.DruidGuiScreen;
import net.mcreator.dcc.client.gui.CookGuiScreen;
import net.mcreator.dcc.client.gui.ClassesScreen;
import net.mcreator.dcc.client.gui.BardeguiScreen;
import net.mcreator.dcc.client.gui.BarbarGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DccModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(DccModMenus.CLASSES.get(), ClassesScreen::new);
		event.register(DccModMenus.BARBAR_GUI.get(), BarbarGuiScreen::new);
		event.register(DccModMenus.BARDEGUI.get(), BardeguiScreen::new);
		event.register(DccModMenus.MAGIC_CHOOSE.get(), MagicChooseScreen::new);
		event.register(DccModMenus.MAGIERGUI.get(), MagierguiScreen::new);
		event.register(DccModMenus.MONK_GUI.get(), MonkGuiScreen::new);
		event.register(DccModMenus.KI.get(), KiScreen::new);
		event.register(DccModMenus.COOK_GUI.get(), CookGuiScreen::new);
		event.register(DccModMenus.DRUID_GUI.get(), DruidGuiScreen::new);
		event.register(DccModMenus.PALADIN_GUI.get(), PaladinGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}