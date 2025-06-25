
package net.mcreator.dndcraft.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class JellyMobEffect extends MobEffect {
	public JellyMobEffect() {
		super(MobEffectCategory.HARMFUL, -5376);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
