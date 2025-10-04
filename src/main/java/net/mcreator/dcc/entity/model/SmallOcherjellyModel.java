package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.SmallOcherjellyEntity;

public class SmallOcherjellyModel extends GeoModel<SmallOcherjellyEntity> {
	@Override
	public ResourceLocation getAnimationResource(SmallOcherjellyEntity entity) {
		return ResourceLocation.parse("dcc:animations/ockergallert.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SmallOcherjellyEntity entity) {
		return ResourceLocation.parse("dcc:geo/ockergallert.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SmallOcherjellyEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}