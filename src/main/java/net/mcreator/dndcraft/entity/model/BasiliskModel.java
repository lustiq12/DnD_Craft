package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.BasiliskEntity;

public class BasiliskModel extends GeoModel<BasiliskEntity> {
	@Override
	public ResourceLocation getAnimationResource(BasiliskEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/basilisk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BasiliskEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/basilisk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BasiliskEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
