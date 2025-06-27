
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.dndcraft.client.model.Modelrat;
import net.mcreator.dndcraft.client.model.Modeliron_golem;
import net.mcreator.dndcraft.client.model.Modelarrow;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DndCraftModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelarrow.LAYER_LOCATION, Modelarrow::createBodyLayer);
		event.registerLayerDefinition(Modelrat.LAYER_LOCATION, Modelrat::createBodyLayer);
		event.registerLayerDefinition(Modeliron_golem.LAYER_LOCATION, Modeliron_golem::createBodyLayer);
	}
}
