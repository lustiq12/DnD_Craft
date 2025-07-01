
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.dndcraft.potion.SlimyMobEffect;
import net.mcreator.dndcraft.potion.KiEffectMobEffect;
import net.mcreator.dndcraft.potion.KiEffect2MobEffect;
import net.mcreator.dndcraft.potion.JellyMobEffect;
import net.mcreator.dndcraft.potion.FreezingMobEffect;
import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, DndCraftMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> SLIMY = REGISTRY.register("slimy", () -> new SlimyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JELLY = REGISTRY.register("jelly", () -> new JellyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FREEZING = REGISTRY.register("freezing", () -> new FreezingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> KI_EFFECT = REGISTRY.register("ki_effect", () -> new KiEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> KI_EFFECT_2 = REGISTRY.register("ki_effect_2", () -> new KiEffect2MobEffect());
}
