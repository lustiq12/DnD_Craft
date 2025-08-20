package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.MimicEntity;

public class MimicModel extends GeoModel<MimicEntity> {
	@Override
	public ResourceLocation getAnimationResource(MimicEntity entity) {
		return ResourceLocation.parse("dcc:animations/mimic.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MimicEntity entity) {
		return ResourceLocation.parse("dcc:geo/mimic.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MimicEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}