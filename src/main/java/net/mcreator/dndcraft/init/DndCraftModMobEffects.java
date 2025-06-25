
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.dndcraft.potion.SlimyMobEffect;
import net.mcreator.dndcraft.potion.KiEffectMobEffect;
import net.mcreator.dndcraft.potion.KiEffect2MobEffect;
import net.mcreator.dndcraft.potion.JellyMobEffect;
import net.mcreator.dndcraft.potion.FreezingMobEffect;
import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DndCraftMod.MODID);
	public static final RegistryObject<MobEffect> SLIMY = REGISTRY.register("slimy", () -> new SlimyMobEffect());
	public static final RegistryObject<MobEffect> JELLY = REGISTRY.register("jelly", () -> new JellyMobEffect());
	public static final RegistryObject<MobEffect> FREEZING = REGISTRY.register("freezing", () -> new FreezingMobEffect());
	public static final RegistryObject<MobEffect> KI_EFFECT = REGISTRY.register("ki_effect", () -> new KiEffectMobEffect());
	public static final RegistryObject<MobEffect> KI_EFFECT_2 = REGISTRY.register("ki_effect_2", () -> new KiEffect2MobEffect());
}
