package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.Ocherjally2Entity;

public class Ocherjally2Model extends GeoModel<Ocherjally2Entity> {
	@Override
	public ResourceLocation getAnimationResource(Ocherjally2Entity entity) {
		return new ResourceLocation("dnd_craft", "animations/ockergallert.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Ocherjally2Entity entity) {
		return new ResourceLocation("dnd_craft", "geo/ockergallert.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Ocherjally2Entity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
