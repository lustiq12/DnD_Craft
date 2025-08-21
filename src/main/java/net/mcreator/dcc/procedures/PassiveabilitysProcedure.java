package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.dcc.network.DccModVariables;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class PassiveabilitysProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (9 < entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel) {
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Barbarian")) {
				if (8 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0));
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Bard")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25, 0));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 25, 0));
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Monk")) {
				if (1 > entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown) {
					if (1 < entity.getData(DccModVariables.PLAYER_VARIABLES).Ki) {
						if (5 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
							{
								DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
								_vars.Ki = entity.getData(DccModVariables.PLAYER_VARIABLES).Ki - 1;
								_vars.syncPlayerVariables(entity);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 6, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 6, 1, false);
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CHERRY_LEAVES, x, y, z, 2000, 5, 5, 3, 0.01);
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									{
										DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
										_vars.cooldown = 25;
										_vars.syncPlayerVariables(entity);
									}
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 5));
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 1));
										entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
										entityiterator.setDeltaMovement(new Vec3((0 - entityiterator.getLookAngle().x), 0, (0 - entityiterator.getLookAngle().z)));
									}
								}
							}
						}
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Druid")) {
				if (Mth.nextInt(RandomSource.create(), 1, 40) == 1) {
					sx = -3;
					found = false;
					for (int index0 = 0; index0 < 6; index0++) {
						sy = -3;
						for (int index1 = 0; index1 < 6; index1++) {
							sz = -3;
							for (int index2 = 0; index2 < 6; index2++) {
								if ((world.getBlockState(BlockPos.containing(Math.round(x) + sx, Math.round(y) + sy, Math.round(z) + sz))).is(BlockTags.create(ResourceLocation.parse("dcc:druid_plants")))) {
									found = true;
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1, false, false));
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Paladin")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 25, 1, false, false));
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Fighter")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
			}
		}
		if (19 < entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel) {
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Barbarian")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1, false, false));
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Monk")) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BLINDNESS);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HUNGER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WITHER);
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Druid")) {
				if (Mth.nextInt(RandomSource.create(), 1, 40) == 1) {
					sx = -5;
					found = false;
					for (int index3 = 0; index3 < 10; index3++) {
						sy = -5;
						for (int index4 = 0; index4 < 10; index4++) {
							sz = -5;
							for (int index5 = 0; index5 < 10; index5++) {
								if ((world.getBlockState(BlockPos.containing(Math.round(x) + sx, Math.round(y) + sy, Math.round(z) + sz))).is(BlockTags.create(ResourceLocation.parse("dcc:druid_plants")))) {
									found = true;
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 2, false, false));
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Paladin")) {
				if (entity.getPersistentData().getBoolean("Fly") && entity.getPersistentData().getBoolean("EnoughMana") && entity.getData(DccModVariables.PLAYER_VARIABLES).Mana >= 1) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 0.5;
						_vars.syncPlayerVariables(entity);
					}
					entity.setDeltaMovement(new Vec3((entity.getLookAngle().x / 3), 0.2, (entity.getLookAngle().z / 3)));
				} else {
					if (entity.getData(DccModVariables.PLAYER_VARIABLES).Mana >= 20) {
						entity.getPersistentData().putBoolean("EnoughMana", true);
					} else {
						entity.getPersistentData().putBoolean("EnoughMana", false);
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Fighter")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
			}
		}
	}
}