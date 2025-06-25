package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.Ogre2Entity;

public class Ogre2Model extends GeoModel<Ogre2Entity> {
	@Override
	public ResourceLocation getAnimationResource(Ogre2Entity entity) {
		return new ResourceLocation("dnd_craft", "animations/ogre.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Ogre2Entity entity) {
		return new ResourceLocation("dnd_craft", "geo/ogre.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Ogre2Entity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
