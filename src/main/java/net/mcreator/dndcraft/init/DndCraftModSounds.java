
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.dndcraft.DndCraftMod;

public class DndCraftModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, DndCraftMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> OGRE_DEATH = REGISTRY.register("ogre_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("dnd_craft", "ogre_death")));
}
