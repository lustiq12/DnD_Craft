package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.Ogre2Entity;

public class Ogre2Model extends GeoModel<Ogre2Entity> {
	@Override
	public ResourceLocation getAnimationResource(Ogre2Entity entity) {
		return ResourceLocation.parse("dcc:animations/ogre.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Ogre2Entity entity) {
		return ResourceLocation.parse("dcc:geo/ogre.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Ogre2Entity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(Ogre2Entity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}