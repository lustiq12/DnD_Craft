package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.OcherjellyEntity;

public class OcherjellyModel extends GeoModel<OcherjellyEntity> {
	@Override
	public ResourceLocation getAnimationResource(OcherjellyEntity entity) {
		return ResourceLocation.parse("dnd_craft:animations/ockergallert.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OcherjellyEntity entity) {
		return ResourceLocation.parse("dnd_craft:geo/ockergallert.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OcherjellyEntity entity) {
		return ResourceLocation.parse("dnd_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
