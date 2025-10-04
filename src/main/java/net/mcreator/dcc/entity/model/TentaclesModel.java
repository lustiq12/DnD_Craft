package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.TentaclesEntity;

public class TentaclesModel extends GeoModel<TentaclesEntity> {
	@Override
	public ResourceLocation getAnimationResource(TentaclesEntity entity) {
		return ResourceLocation.parse("dcc:animations/vines.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TentaclesEntity entity) {
		return ResourceLocation.parse("dcc:geo/vines.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TentaclesEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}