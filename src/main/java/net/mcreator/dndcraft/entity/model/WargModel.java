package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.WargEntity;

public class WargModel extends GeoModel<WargEntity> {
	@Override
	public ResourceLocation getAnimationResource(WargEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/warg.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WargEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/warg.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WargEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
