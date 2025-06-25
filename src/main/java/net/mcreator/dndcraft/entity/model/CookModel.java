package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.CookEntity;

public class CookModel extends GeoModel<CookEntity> {
	@Override
	public ResourceLocation getAnimationResource(CookEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/cook.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CookEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/cook.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CookEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
