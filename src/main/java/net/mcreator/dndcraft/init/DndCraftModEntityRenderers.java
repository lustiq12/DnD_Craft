
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.dndcraft.client.renderer.WargRenderer;
import net.mcreator.dndcraft.client.renderer.OwlbearRenderer;
import net.mcreator.dndcraft.client.renderer.OrkRenderer;
import net.mcreator.dndcraft.client.renderer.Ogre2Renderer;
import net.mcreator.dndcraft.client.renderer.OcherjellyRenderer;
import net.mcreator.dndcraft.client.renderer.Ocherjally2Renderer;
import net.mcreator.dndcraft.client.renderer.MimicSludgeRenderer;
import net.mcreator.dndcraft.client.renderer.MimicRenderer;
import net.mcreator.dndcraft.client.renderer.IronGoblinRenderer;
import net.mcreator.dndcraft.client.renderer.InvisibleStalkerRenderer;
import net.mcreator.dndcraft.client.renderer.HarpyRenderer;
import net.mcreator.dndcraft.client.renderer.GoblinRenderer;
import net.mcreator.dndcraft.client.renderer.GoblinChiefRenderer;
import net.mcreator.dndcraft.client.renderer.GhoulRenderer;
import net.mcreator.dndcraft.client.renderer.CookRenderer;
import net.mcreator.dndcraft.client.renderer.BowblinRenderer;
import net.mcreator.dndcraft.client.renderer.BasiliskRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DndCraftModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DndCraftModEntities.OGRE.get(), Ogre2Renderer::new);
		event.registerEntityRenderer(DndCraftModEntities.ORK.get(), OrkRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.HARPY.get(), HarpyRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.OWLBEAR.get(), OwlbearRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.MIMIC.get(), MimicRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.GOBLIN.get(), GoblinRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.IRON_GOBLIN.get(), IronGoblinRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.GOBLIN_CHIEF.get(), GoblinChiefRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.FIREBALL_2.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.COLDRAYSPELL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.OCHERJELLY.get(), OcherjellyRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.OCHERJALLY_2.get(), Ocherjally2Renderer::new);
		event.registerEntityRenderer(DndCraftModEntities.MIMIC_SLUDGE.get(), MimicSludgeRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.INVISIBLE_STALKER.get(), InvisibleStalkerRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.BASILISK.get(), BasiliskRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.WARG.get(), WargRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.BOWBLIN.get(), BowblinRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.BOWBLIN_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.ARROW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.COOK.get(), CookRenderer::new);
		event.registerEntityRenderer(DndCraftModEntities.GHOUL.get(), GhoulRenderer::new);
	}
}
