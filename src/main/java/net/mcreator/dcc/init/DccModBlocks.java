/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.dcc.block.SilverOreBlock;
import net.mcreator.dcc.block.ScrapblockBlock;
import net.mcreator.dcc.block.SanctifiedBeaconBlock;
import net.mcreator.dcc.block.RawOwlbearmeatBlockBlock;
import net.mcreator.dcc.block.PlatinumOreBlock;
import net.mcreator.dcc.block.GlimmerLeavesBlock;
import net.mcreator.dcc.block.FeywildPortalBlock;
import net.mcreator.dcc.block.DeepslateSilverOreBlock;
import net.mcreator.dcc.block.Cookedowlbearmeatblock4Block;
import net.mcreator.dcc.block.Cookedowlbearmeatblock3Block;
import net.mcreator.dcc.block.Cookedowlbearmeatblock2Block;
import net.mcreator.dcc.block.CookedOwlbearMeatBlockBlock;
import net.mcreator.dcc.block.CarrioncrawlercocoonBlock;
import net.mcreator.dcc.block.CarrionCrawlerCocoonInactiveBlock;
import net.mcreator.dcc.block.AdantiumOreBlock;
import net.mcreator.dcc.DccMod;

public class DccModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(DccMod.MODID);
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
	public static final DeferredBlock<Block> GLIMMER_LEAVES = REGISTRY.register("glimmer_leaves", GlimmerLeavesBlock::new);
	public static final DeferredBlock<Block> FEYWILD_PORTAL = REGISTRY.register("feywild_portal", FeywildPortalBlock::new);
	public static final DeferredBlock<Block> SANCTIFIED_BEACON = REGISTRY.register("sanctified_beacon", SanctifiedBeaconBlock::new);
	public static final DeferredBlock<Block> CARRIONCRAWLERCOCOON = REGISTRY.register("carrioncrawlercocoon", CarrioncrawlercocoonBlock::new);
	public static final DeferredBlock<Block> CARRION_CRAWLER_COCOON_INACTIVE = REGISTRY.register("carrion_crawler_cocoon_inactive", CarrionCrawlerCocoonInactiveBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}