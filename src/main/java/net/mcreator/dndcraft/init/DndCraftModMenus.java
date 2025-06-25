
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.dndcraft.world.inventory.MonkGuiMenu;
import net.mcreator.dndcraft.world.inventory.MagierguiMenu;
import net.mcreator.dndcraft.world.inventory.MagicChooseMenu;
import net.mcreator.dndcraft.world.inventory.KiMenu;
import net.mcreator.dndcraft.world.inventory.CookGuiMenu;
import net.mcreator.dndcraft.world.inventory.ClassesMenu;
import net.mcreator.dndcraft.world.inventory.BardeguiMenu;
import net.mcreator.dndcraft.world.inventory.BarbarGuiMenu;
import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DndCraftMod.MODID);
	public static final RegistryObject<MenuType<ClassesMenu>> CLASSES = REGISTRY.register("classes", () -> IForgeMenuType.create(ClassesMenu::new));
	public static final RegistryObject<MenuType<BarbarGuiMenu>> BARBAR_GUI = REGISTRY.register("barbar_gui", () -> IForgeMenuType.create(BarbarGuiMenu::new));
	public static final RegistryObject<MenuType<BardeguiMenu>> BARDEGUI = REGISTRY.register("bardegui", () -> IForgeMenuType.create(BardeguiMenu::new));
	public static final RegistryObject<MenuType<MagicChooseMenu>> MAGIC_CHOOSE = REGISTRY.register("magic_choose", () -> IForgeMenuType.create(MagicChooseMenu::new));
	public static final RegistryObject<MenuType<MagierguiMenu>> MAGIERGUI = REGISTRY.register("magiergui", () -> IForgeMenuType.create(MagierguiMenu::new));
	public static final RegistryObject<MenuType<MonkGuiMenu>> MONK_GUI = REGISTRY.register("monk_gui", () -> IForgeMenuType.create(MonkGuiMenu::new));
	public static final RegistryObject<MenuType<KiMenu>> KI = REGISTRY.register("ki", () -> IForgeMenuType.create(KiMenu::new));
	public static final RegistryObject<MenuType<CookGuiMenu>> COOK_GUI = REGISTRY.register("cook_gui", () -> IForgeMenuType.create(CookGuiMenu::new));
}
