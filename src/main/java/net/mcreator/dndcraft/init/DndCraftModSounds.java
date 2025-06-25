
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DndCraftMod.MODID);
	public static final RegistryObject<SoundEvent> OGRE_DEATH = REGISTRY.register("ogre_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("dnd_craft", "ogre_death")));
}
