package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.BullywugEntity;

public class BullywugModel extends GeoModel<BullywugEntity> {
	@Override
	public ResourceLocation getAnimationResource(BullywugEntity entity) {
		return ResourceLocation.parse("dcc:animations/bullywug.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BullywugEntity entity) {
		return ResourceLocation.parse("dcc:geo/bullywug.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BullywugEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}