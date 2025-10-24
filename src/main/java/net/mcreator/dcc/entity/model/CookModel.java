package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.CookEntity;

public class CookModel extends GeoModel<CookEntity> {
	@Override
	public ResourceLocation getAnimationResource(CookEntity entity) {
		return ResourceLocation.parse("dcc:animations/cook2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CookEntity entity) {
		return ResourceLocation.parse("dcc:geo/cook2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CookEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}