package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.GoblinChiefEntity;

public class GoblinChiefModel extends GeoModel<GoblinChiefEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoblinChiefEntity entity) {
		return ResourceLocation.parse("dcc:animations/goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoblinChiefEntity entity) {
		return ResourceLocation.parse("dcc:geo/goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoblinChiefEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}
