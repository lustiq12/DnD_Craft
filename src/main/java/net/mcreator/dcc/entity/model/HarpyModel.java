package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.HarpyEntity;

public class HarpyModel extends GeoModel<HarpyEntity> {
	@Override
	public ResourceLocation getAnimationResource(HarpyEntity entity) {
		return ResourceLocation.parse("dcc:animations/harpy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HarpyEntity entity) {
		return ResourceLocation.parse("dcc:geo/harpy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HarpyEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(HarpyEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
