package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.VINESEntity;

public class VINESModel extends GeoModel<VINESEntity> {
	@Override
	public ResourceLocation getAnimationResource(VINESEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/vines.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VINESEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/vines.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VINESEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
