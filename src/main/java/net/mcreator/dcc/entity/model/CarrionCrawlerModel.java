package net.mcreator.dcc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.dcc.entity.CarrionCrawlerEntity;

public class CarrionCrawlerModel extends GeoModel<CarrionCrawlerEntity> {
	@Override
	public ResourceLocation getAnimationResource(CarrionCrawlerEntity entity) {
		return ResourceLocation.parse("dcc:animations/carrion_crawler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CarrionCrawlerEntity entity) {
		return ResourceLocation.parse("dcc:geo/carrion_crawler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CarrionCrawlerEntity entity) {
		return ResourceLocation.parse("dcc:textures/entities/" + entity.getTexture() + ".png");
	}

}