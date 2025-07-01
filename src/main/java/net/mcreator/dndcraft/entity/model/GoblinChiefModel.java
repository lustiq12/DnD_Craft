package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.GoblinChiefEntity;

public class GoblinChiefModel extends GeoModel<GoblinChiefEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoblinChiefEntity entity) {
		return ResourceLocation.parse("dnd_craft:animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoblinChiefEntity entity) {
		return ResourceLocation.parse("dnd_craft:geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoblinChiefEntity entity) {
		return ResourceLocation.parse("dnd_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
