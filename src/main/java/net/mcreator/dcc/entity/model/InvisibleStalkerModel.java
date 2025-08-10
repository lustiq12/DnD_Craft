package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.InvisibleStalkerEntity;

public class InvisibleStalkerModel extends GeoModel<InvisibleStalkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(InvisibleStalkerEntity entity) {
		return ResourceLocation.parse("dcc:animations/invisiblestalker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InvisibleStalkerEntity entity) {
		return ResourceLocation.parse("dcc:geo/invisiblestalker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InvisibleStalkerEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
