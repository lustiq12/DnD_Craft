package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.OcherjellyEntity;

public class OcherjellyModel extends GeoModel<OcherjellyEntity> {
	@Override
	public ResourceLocation getAnimationResource(OcherjellyEntity entity) {
		return ResourceLocation.parse("dcc:animations/ockergallert.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OcherjellyEntity entity) {
		return ResourceLocation.parse("dcc:geo/ockergallert.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OcherjellyEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
