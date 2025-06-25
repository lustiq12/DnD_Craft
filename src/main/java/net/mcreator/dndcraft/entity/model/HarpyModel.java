package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.HarpyEntity;

public class HarpyModel extends GeoModel<HarpyEntity> {
	@Override
	public ResourceLocation getAnimationResource(HarpyEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/harpy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HarpyEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/harpy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HarpyEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(HarpyEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
