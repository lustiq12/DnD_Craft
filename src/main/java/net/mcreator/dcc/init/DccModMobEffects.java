/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.dcc.potion.SlimyMobEffect;
import net.mcreator.dcc.potion.KiEffectMobEffect;
import net.mcreator.dcc.potion.KiEffect2MobEffect;
import net.mcreator.dcc.potion.JellyMobEffect;
import net.mcreator.dcc.potion.FreezingMobEffect;
import net.mcreator.dcc.DccMod;

public class DccModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, DccMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> SLIMY = REGISTRY.register("slimy", () -> new SlimyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JELLY = REGISTRY.register("jelly", () -> new JellyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FREEZING = REGISTRY.register("freezing", () -> new FreezingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> KI_EFFECT = REGISTRY.register("ki_effect", () -> new KiEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> KI_EFFECT_2 = REGISTRY.register("ki_effect_2", () -> new KiEffect2MobEffect());
}