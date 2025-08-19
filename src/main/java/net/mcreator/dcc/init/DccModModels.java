
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.dcc.client.model.Modelthorn;
import net.mcreator.dcc.client.model.Modelrat;
import net.mcreator.dcc.client.model.Modeliron_golem;
import net.mcreator.dcc.client.model.Modelarrow;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DccModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelarrow.LAYER_LOCATION, Modelarrow::createBodyLayer);
		event.registerLayerDefinition(Modelrat.LAYER_LOCATION, Modelrat::createBodyLayer);
		event.registerLayerDefinition(Modelthorn.LAYER_LOCATION, Modelthorn::createBodyLayer);
		event.registerLayerDefinition(Modeliron_golem.LAYER_LOCATION, Modeliron_golem::createBodyLayer);
	}
}
