
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.dcc.world.inventory.MonkGuiMenu;
import net.mcreator.dcc.world.inventory.MagierguiMenu;
import net.mcreator.dcc.world.inventory.MagicChooseMenu;
import net.mcreator.dcc.world.inventory.KiMenu;
import net.mcreator.dcc.world.inventory.DruidGuiMenu;
import net.mcreator.dcc.world.inventory.CookGuiMenu;
import net.mcreator.dcc.world.inventory.ClassesMenu;
import net.mcreator.dcc.world.inventory.BardeguiMenu;
import net.mcreator.dcc.world.inventory.BarbarGuiMenu;
import net.mcreator.dcc.DccMod;

public class DccModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, DccMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<ClassesMenu>> CLASSES = REGISTRY.register("classes", () -> IMenuTypeExtension.create(ClassesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BarbarGuiMenu>> BARBAR_GUI = REGISTRY.register("barbar_gui", () -> IMenuTypeExtension.create(BarbarGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BardeguiMenu>> BARDEGUI = REGISTRY.register("bardegui", () -> IMenuTypeExtension.create(BardeguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MagicChooseMenu>> MAGIC_CHOOSE = REGISTRY.register("magic_choose", () -> IMenuTypeExtension.create(MagicChooseMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MagierguiMenu>> MAGIERGUI = REGISTRY.register("magiergui", () -> IMenuTypeExtension.create(MagierguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MonkGuiMenu>> MONK_GUI = REGISTRY.register("monk_gui", () -> IMenuTypeExtension.create(MonkGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KiMenu>> KI = REGISTRY.register("ki", () -> IMenuTypeExtension.create(KiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CookGuiMenu>> COOK_GUI = REGISTRY.register("cook_gui", () -> IMenuTypeExtension.create(CookGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DruidGuiMenu>> DRUID_GUI = REGISTRY.register("druid_gui", () -> IMenuTypeExtension.create(DruidGuiMenu::new));
}
