package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.SlotMachineEntityEntity;

public class SlotMachineEntityModel extends GeoModel<SlotMachineEntityEntity> {
	@Override
	public ResourceLocation getAnimationResource(SlotMachineEntityEntity entity) {
		return ResourceLocation.parse("dcc:animations/gamblingmachine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SlotMachineEntityEntity entity) {
		return ResourceLocation.parse("dcc:geo/gamblingmachine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SlotMachineEntityEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}