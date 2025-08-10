package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.GhoulEntity;

public class GhoulModel extends GeoModel<GhoulEntity> {
	@Override
	public ResourceLocation getAnimationResource(GhoulEntity entity) {
		return ResourceLocation.parse("dcc:animations/ghoul.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GhoulEntity entity) {
		return ResourceLocation.parse("dcc:geo/ghoul.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GhoulEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
