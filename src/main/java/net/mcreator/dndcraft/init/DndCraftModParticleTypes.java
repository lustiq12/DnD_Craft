
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DndCraftMod.MODID);
	public static final RegistryObject<SimpleParticleType> SHIELD_PARTICLE = REGISTRY.register("shield_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SLIMYPARTICLE = REGISTRY.register("slimyparticle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BLOOD = REGISTRY.register("blood", () -> new SimpleParticleType(false));
}
