package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.BullywugTadpoleEntity;

public class BullywugTadpoleModel extends GeoModel<BullywugTadpoleEntity> {
	@Override
	public ResourceLocation getAnimationResource(BullywugTadpoleEntity entity) {
		return ResourceLocation.parse("dcc:animations/bullywugtadpole2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BullywugTadpoleEntity entity) {
		return ResourceLocation.parse("dcc:geo/bullywugtadpole2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BullywugTadpoleEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}