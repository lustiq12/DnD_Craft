package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.VINESEntity;

public class VINESModel extends GeoModel<VINESEntity> {
	@Override
	public ResourceLocation getAnimationResource(VINESEntity entity) {
		return ResourceLocation.parse("dcc:animations/vines.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VINESEntity entity) {
		return ResourceLocation.parse("dcc:geo/vines.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VINESEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
