package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.LivingSwordEntity;

public class LivingSwordModel extends GeoModel<LivingSwordEntity> {
	@Override
	public ResourceLocation getAnimationResource(LivingSwordEntity entity) {
		return ResourceLocation.parse("dcc:animations/magicsword.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LivingSwordEntity entity) {
		return ResourceLocation.parse("dcc:geo/magicsword.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LivingSwordEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}