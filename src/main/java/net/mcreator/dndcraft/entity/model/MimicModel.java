package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.MimicEntity;

public class MimicModel extends GeoModel<MimicEntity> {
	@Override
	public ResourceLocation getAnimationResource(MimicEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/mimic.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MimicEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/mimic.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MimicEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
