package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.IronGoblinEntity;

public class IronGoblinModel extends GeoModel<IronGoblinEntity> {
	@Override
	public ResourceLocation getAnimationResource(IronGoblinEntity entity) {
		return ResourceLocation.parse("dcc:animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IronGoblinEntity entity) {
		return ResourceLocation.parse("dcc:geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IronGoblinEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
