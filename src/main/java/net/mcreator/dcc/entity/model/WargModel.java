package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.WargEntity;

public class WargModel extends GeoModel<WargEntity> {
	@Override
	public ResourceLocation getAnimationResource(WargEntity entity) {
		return ResourceLocation.parse("dcc:animations/warg.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WargEntity entity) {
		return ResourceLocation.parse("dcc:geo/warg.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WargEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
