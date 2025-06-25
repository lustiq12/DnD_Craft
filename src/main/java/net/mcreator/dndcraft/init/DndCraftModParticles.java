
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.dndcraft.client.particle.SlimyparticleParticle;
import net.mcreator.dndcraft.client.particle.ShieldParticleParticle;
import net.mcreator.dndcraft.client.particle.BloodParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DndCraftModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(DndCraftModParticleTypes.SHIELD_PARTICLE.get(), ShieldParticleParticle::provider);
		event.registerSpriteSet(DndCraftModParticleTypes.SLIMYPARTICLE.get(), SlimyparticleParticle::provider);
		event.registerSpriteSet(DndCraftModParticleTypes.BLOOD.get(), BloodParticle::provider);
	}
}
