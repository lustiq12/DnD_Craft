package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.GoblinEntity;

public class GoblinModel extends GeoModel<GoblinEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoblinEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoblinEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoblinEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
