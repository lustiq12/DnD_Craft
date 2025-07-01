
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.dndcraft.block.SilverOreBlock;
import net.mcreator.dndcraft.block.ScrapblockBlock;
import net.mcreator.dndcraft.block.RawOwlbearmeatBlockBlock;
import net.mcreator.dndcraft.block.PlatinumOreBlock;
import net.mcreator.dndcraft.block.DeepslateSilverOreBlock;
import net.mcreator.dndcraft.block.Cookedowlbearmeatblock4Block;
import net.mcreator.dndcraft.block.Cookedowlbearmeatblock3Block;
import net.mcreator.dndcraft.block.Cookedowlbearmeatblock2Block;
import net.mcreator.dndcraft.block.CookedOwlbearMeatBlockBlock;
import net.mcreator.dndcraft.block.AdantiumOreBlock;
import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(DndCraftMod.MODID);
	public static final DeferredBlock<Block> ADANTIUM_ORE = REGISTRY.register("adantium_ore", AdantiumOreBlock::new);
	public static final DeferredBlock<Block> COOKED_OWLBEAR_MEAT_BLOCK = REGISTRY.register("cooked_owlbear_meat_block", CookedOwlbearMeatBlockBlock::new);
	public static final DeferredBlock<Block> RAW_OWLBEARMEAT_BLOCK = REGISTRY.register("raw_owlbearmeat_block", RawOwlbearmeatBlockBlock::new);
	public static final DeferredBlock<Block> COOKEDOWLBEARMEATBLOCK_2 = REGISTRY.register("cookedowlbearmeatblock_2", Cookedowlbearmeatblock2Block::new);
	public static final DeferredBlock<Block> COOKEDOWLBEARMEATBLOCK_3 = REGISTRY.register("cookedowlbearmeatblock_3", Cookedowlbearmeatblock3Block::new);
	public static final DeferredBlock<Block> COOKEDOWLBEARMEATBLOCK_4 = REGISTRY.register("cookedowlbearmeatblock_4", Cookedowlbearmeatblock4Block::new);
	public static final DeferredBlock<Block> PLATINUM_ORE = REGISTRY.register("platinum_ore", PlatinumOreBlock::new);
	public static final DeferredBlock<Block> SCRAPBLOCK = REGISTRY.register("scrapblock", ScrapblockBlock::new);
	public static final DeferredBlock<Block> SILVER_ORE = REGISTRY.register("silver_ore", SilverOreBlock::new);
	public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = REGISTRY.register("deepslate_silver_ore", DeepslateSilverOreBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
