package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.RedCapEntity;

public class RedCapModel extends GeoModel<RedCapEntity> {
	@Override
	public ResourceLocation getAnimationResource(RedCapEntity entity) {
		return ResourceLocation.parse("dcc:animations/redcap.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedCapEntity entity) {
		return ResourceLocation.parse("dcc:geo/redcap.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedCapEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}