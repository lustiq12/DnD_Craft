package net.mcreator.dcc.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.dcc.procedures.ButterflyCurseOnEntityHurtProcedure;
import net.mcreator.dcc.procedures.ButterflyCurseOnEffectActiveTickProcedure;

import java.util.Set;

public class ButterflyCurseMobEffect extends MobEffect {
	public ButterflyCurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -3407668);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ButterflyCurseOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return super.applyEffectTick(entity, amplifier);
	}

	@Override
	public void onMobHurt(LivingEntity entity, int amplifier, DamageSource damagesource, float damage) {
		ButterflyCurseOnEntityHurtProcedure.execute(entity);
	}
}