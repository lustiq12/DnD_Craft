package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.InvisibleStalkerEntity;

public class InvisibleStalkerModel extends GeoModel<InvisibleStalkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(InvisibleStalkerEntity entity) {
		return ResourceLocation.parse("dnd_craft:animations/invisiblestalker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InvisibleStalkerEntity entity) {
		return ResourceLocation.parse("dnd_craft:geo/invisiblestalker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InvisibleStalkerEntity entity) {
		return ResourceLocation.parse("dnd_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
