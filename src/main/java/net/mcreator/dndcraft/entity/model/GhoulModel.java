package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.GhoulEntity;

public class GhoulModel extends GeoModel<GhoulEntity> {
	@Override
	public ResourceLocation getAnimationResource(GhoulEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/ghoul.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GhoulEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/ghoul.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GhoulEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
