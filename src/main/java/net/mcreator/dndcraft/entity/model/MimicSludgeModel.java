package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.MimicSludgeEntity;

public class MimicSludgeModel extends GeoModel<MimicSludgeEntity> {
	@Override
	public ResourceLocation getAnimationResource(MimicSludgeEntity entity) {
		return ResourceLocation.parse("dnd_craft:animations/mimicsludge.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MimicSludgeEntity entity) {
		return ResourceLocation.parse("dnd_craft:geo/mimicsludge.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MimicSludgeEntity entity) {
		return ResourceLocation.parse("dnd_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
