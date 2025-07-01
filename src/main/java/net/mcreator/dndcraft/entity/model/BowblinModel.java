package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.BowblinEntity;

public class BowblinModel extends GeoModel<BowblinEntity> {
	@Override
	public ResourceLocation getAnimationResource(BowblinEntity entity) {
		return ResourceLocation.parse("dnd_craft:animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BowblinEntity entity) {
		return ResourceLocation.parse("dnd_craft:geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BowblinEntity entity) {
		return ResourceLocation.parse("dnd_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
