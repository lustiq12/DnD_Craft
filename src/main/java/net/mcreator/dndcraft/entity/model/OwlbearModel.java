package net.mcreator.dndcraft.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.dndcraft.entity.OwlbearEntity;

public class OwlbearModel extends GeoModel<OwlbearEntity> {
	@Override
	public ResourceLocation getAnimationResource(OwlbearEntity entity) {
		return new ResourceLocation("dnd_craft", "animations/owlbear.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OwlbearEntity entity) {
		return new ResourceLocation("dnd_craft", "geo/owlbear.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OwlbearEntity entity) {
		return new ResourceLocation("dnd_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(OwlbearEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
