/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.dcc.client.particle.SlimyparticleParticle;
import net.mcreator.dcc.client.particle.ShieldParticleParticle;
import net.mcreator.dcc.client.particle.BloodParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DccModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(DccModParticleTypes.SHIELD_PARTICLE.get(), ShieldParticleParticle::provider);
		event.registerSpriteSet(DccModParticleTypes.SLIMYPARTICLE.get(), SlimyparticleParticle::provider);
		event.registerSpriteSet(DccModParticleTypes.BLOOD.get(), BloodParticle::provider);
	}
}