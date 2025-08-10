package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.Ogre2Entity;

public class Ogre2Model extends GeoModel<Ogre2Entity> {
	@Override
	public ResourceLocation getAnimationResource(Ogre2Entity entity) {
		return ResourceLocation.parse("dcc:animations/ogre.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Ogre2Entity entity) {
		return ResourceLocation.parse("dcc:geo/ogre.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Ogre2Entity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
