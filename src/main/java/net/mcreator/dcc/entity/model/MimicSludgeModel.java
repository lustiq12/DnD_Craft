package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.MimicSludgeEntity;

public class MimicSludgeModel extends GeoModel<MimicSludgeEntity> {
	@Override
	public ResourceLocation getAnimationResource(MimicSludgeEntity entity) {
		return ResourceLocation.parse("dcc:animations/mimicsludge.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MimicSludgeEntity entity) {
		return ResourceLocation.parse("dcc:geo/mimicsludge.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MimicSludgeEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}