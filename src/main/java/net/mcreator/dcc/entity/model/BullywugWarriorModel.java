package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.BullywugWarriorEntity;

public class BullywugWarriorModel extends GeoModel<BullywugWarriorEntity> {
	@Override
	public ResourceLocation getAnimationResource(BullywugWarriorEntity entity) {
		return ResourceLocation.parse("dcc:animations/bullywugknight.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BullywugWarriorEntity entity) {
		return ResourceLocation.parse("dcc:geo/bullywugknight.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BullywugWarriorEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}