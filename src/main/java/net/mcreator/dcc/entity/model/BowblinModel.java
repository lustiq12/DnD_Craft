package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.BowblinEntity;

public class BowblinModel extends GeoModel<BowblinEntity> {
	@Override
	public ResourceLocation getAnimationResource(BowblinEntity entity) {
		return ResourceLocation.parse("dcc:animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BowblinEntity entity) {
		return ResourceLocation.parse("dcc:geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BowblinEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}