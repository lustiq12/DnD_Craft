package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.IronGoblinEntity;

public class IronGoblinModel extends GeoModel<IronGoblinEntity> {
	@Override
	public ResourceLocation getAnimationResource(IronGoblinEntity entity) {
		return ResourceLocation.parse("dnd_craft:animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IronGoblinEntity entity) {
		return ResourceLocation.parse("dnd_craft:geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IronGoblinEntity entity) {
		return ResourceLocation.parse("dnd_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
