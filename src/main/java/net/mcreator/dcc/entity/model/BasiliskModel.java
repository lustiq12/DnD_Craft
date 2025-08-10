package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.BasiliskEntity;

public class BasiliskModel extends GeoModel<BasiliskEntity> {
	@Override
	public ResourceLocation getAnimationResource(BasiliskEntity entity) {
		return ResourceLocation.parse("dcc:animations/basilisk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BasiliskEntity entity) {
		return ResourceLocation.parse("dcc:geo/basilisk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BasiliskEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
