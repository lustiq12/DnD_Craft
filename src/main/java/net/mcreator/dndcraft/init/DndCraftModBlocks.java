
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.dndcraft.block.SilverOreBlock;
import net.mcreator.dndcraft.block.ShadowfellPortalBlock;
import net.mcreator.dndcraft.block.ScrapblockBlock;
import net.mcreator.dndcraft.block.RawOwlbearmeatBlockBlock;
import net.mcreator.dndcraft.block.PlatinumOreBlock;
import net.mcreator.dndcraft.block.FeywildPortalBlock;
import net.mcreator.dndcraft.block.DeepslateSilverOreBlock;
import net.mcreator.dndcraft.block.Cookedowlbearmeatblock4Block;
import net.mcreator.dndcraft.block.Cookedowlbearmeatblock3Block;
import net.mcreator.dndcraft.block.Cookedowlbearmeatblock2Block;
import net.mcreator.dndcraft.block.CookedOwlbearMeatBlockBlock;
import net.mcreator.dndcraft.block.AdantiumOreBlock;
import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DndCraftMod.MODID);
	public static final RegistryObject<Block> ADANTIUM_ORE = REGISTRY.register("adantium_ore", () -> new AdantiumOreBlock());
	public static final RegistryObject<Block> COOKED_OWLBEAR_MEAT_BLOCK = REGISTRY.register("cooked_owlbear_meat_block", () -> new CookedOwlbearMeatBlockBlock());
	public static final RegistryObject<Block> RAW_OWLBEARMEAT_BLOCK = REGISTRY.register("raw_owlbearmeat_block", () -> new RawOwlbearmeatBlockBlock());
	public static final RegistryObject<Block> COOKEDOWLBEARMEATBLOCK_2 = REGISTRY.register("cookedowlbearmeatblock_2", () -> new Cookedowlbearmeatblock2Block());
	public static final RegistryObject<Block> COOKEDOWLBEARMEATBLOCK_3 = REGISTRY.register("cookedowlbearmeatblock_3", () -> new Cookedowlbearmeatblock3Block());
	public static final RegistryObject<Block> COOKEDOWLBEARMEATBLOCK_4 = REGISTRY.register("cookedowlbearmeatblock_4", () -> new Cookedowlbearmeatblock4Block());
	public static final RegistryObject<Block> PLATINUM_ORE = REGISTRY.register("platinum_ore", () -> new PlatinumOreBlock());
	public static final RegistryObject<Block> SCRAPBLOCK = REGISTRY.register("scrapblock", () -> new ScrapblockBlock());
	public static final RegistryObject<Block> FEYWILD_PORTAL = REGISTRY.register("feywild_portal", () -> new FeywildPortalBlock());
	public static final RegistryObject<Block> SILVER_ORE = REGISTRY.register("silver_ore", () -> new SilverOreBlock());
	public static final RegistryObject<Block> SHADOWFELL_PORTAL = REGISTRY.register("shadowfell_portal", () -> new ShadowfellPortalBlock());
	public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = REGISTRY.register("deepslate_silver_ore", () -> new DeepslateSilverOreBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
