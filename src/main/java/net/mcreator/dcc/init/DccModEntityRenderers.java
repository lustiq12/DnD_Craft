/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.dcc.client.renderer.WargRenderer;
import net.mcreator.dcc.client.renderer.VINESRenderer;
import net.mcreator.dcc.client.renderer.ThornRenderer;
import net.mcreator.dcc.client.renderer.TentaclesRenderer;
import net.mcreator.dcc.client.renderer.SmallOcherjellyRenderer;
import net.mcreator.dcc.client.renderer.OwlbearRenderer;
import net.mcreator.dcc.client.renderer.OrkRenderer;
import net.mcreator.dcc.client.renderer.Ogre2Renderer;
import net.mcreator.dcc.client.renderer.OcherjellyRenderer;
import net.mcreator.dcc.client.renderer.MimicSludgeRenderer;
import net.mcreator.dcc.client.renderer.MimicRenderer;
import net.mcreator.dcc.client.renderer.LivingSwordRenderer;
import net.mcreator.dcc.client.renderer.IronGoblinRenderer;
import net.mcreator.dcc.client.renderer.InvisibleStalkerRenderer;
import net.mcreator.dcc.client.renderer.HarpyRenderer;
import net.mcreator.dcc.client.renderer.GoblinRenderer;
import net.mcreator.dcc.client.renderer.GoblinChiefRenderer;
import net.mcreator.dcc.client.renderer.GhoulRenderer;
import net.mcreator.dcc.client.renderer.CookRenderer;
import net.mcreator.dcc.client.renderer.CarrionCrawlerRenderer;
import net.mcreator.dcc.client.renderer.BullywugWarriorRenderer;
import net.mcreator.dcc.client.renderer.BullywugTadpoleRenderer;
import net.mcreator.dcc.client.renderer.BullywugRenderer;
import net.mcreator.dcc.client.renderer.BowblinRenderer;
import net.mcreator.dcc.client.renderer.BasiliskRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DccModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DccModEntities.OGRE.get(), Ogre2Renderer::new);
		event.registerEntityRenderer(DccModEntities.ORK.get(), OrkRenderer::new);
		event.registerEntityRenderer(DccModEntities.HARPY.get(), HarpyRenderer::new);
		event.registerEntityRenderer(DccModEntities.OWLBEAR.get(), OwlbearRenderer::new);
		event.registerEntityRenderer(DccModEntities.MIMIC.get(), MimicRenderer::new);
		event.registerEntityRenderer(DccModEntities.GOBLIN.get(), GoblinRenderer::new);
		event.registerEntityRenderer(DccModEntities.GOBLIN_IRON.get(), IronGoblinRenderer::new);
		event.registerEntityRenderer(DccModEntities.GOBLIN_CHIEF.get(), GoblinChiefRenderer::new);
		event.registerEntityRenderer(DccModEntities.FIREBALL_2.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DccModEntities.COLDRAYSPELL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DccModEntities.OCHERJELLY.get(), OcherjellyRenderer::new);
		event.registerEntityRenderer(DccModEntities.MIMIC_SLUDGE.get(), MimicSludgeRenderer::new);
		event.registerEntityRenderer(DccModEntities.INVISIBLE_STALKER.get(), InvisibleStalkerRenderer::new);
		event.registerEntityRenderer(DccModEntities.BASILISK.get(), BasiliskRenderer::new);
		event.registerEntityRenderer(DccModEntities.WARG.get(), WargRenderer::new);
		event.registerEntityRenderer(DccModEntities.GOBLIN_BOW.get(), BowblinRenderer::new);
		event.registerEntityRenderer(DccModEntities.COOK.get(), CookRenderer::new);
		event.registerEntityRenderer(DccModEntities.GHOUL.get(), GhoulRenderer::new);
		event.registerEntityRenderer(DccModEntities.VINES.get(), VINESRenderer::new);
		event.registerEntityRenderer(DccModEntities.THORN.get(), ThornRenderer::new);
		event.registerEntityRenderer(DccModEntities.LIVING_SWORD.get(), LivingSwordRenderer::new);
		event.registerEntityRenderer(DccModEntities.SMALL_OCHERJELLY.get(), SmallOcherjellyRenderer::new);
		event.registerEntityRenderer(DccModEntities.CARRION_CRAWLER.get(), CarrionCrawlerRenderer::new);
		event.registerEntityRenderer(DccModEntities.CARRION_CRAWLER_POISON.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DccModEntities.TENTACLES.get(), TentaclesRenderer::new);
		event.registerEntityRenderer(DccModEntities.BULLYWUG.get(), BullywugRenderer::new);
		event.registerEntityRenderer(DccModEntities.BULLYWUG_TADPOLE.get(), BullywugTadpoleRenderer::new);
		event.registerEntityRenderer(DccModEntities.BULLYWUG_WARRIOR.get(), BullywugWarriorRenderer::new);
	}
}