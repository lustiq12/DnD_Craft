package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.GoblinEntity;

public class GoblinModel extends GeoModel<GoblinEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoblinEntity entity) {
		return ResourceLocation.parse("dcc:animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoblinEntity entity) {
		return ResourceLocation.parse("dcc:geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoblinEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
