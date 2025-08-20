package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.dcc.network.DccModVariables;
import net.mcreator.dcc.DccMod;

import java.util.Comparator;

public class DrumsrichtclickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Bard")) {
			if (29 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.basedrum")), SoundSource.NEUTRAL, 8, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.basedrum")), SoundSource.NEUTRAL, 8, 1, false);
					}
				}
				DccMod.queueServerWork(5, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.basedrum")), SoundSource.NEUTRAL, 8, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.basedrum")), SoundSource.NEUTRAL, 8, 1, false);
						}
					}
				});
				DccMod.queueServerWork(10, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.basedrum")), SoundSource.NEUTRAL, 8, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.basedrum")), SoundSource.NEUTRAL, 8, 1, false);
						}
					}
				});
				DccMod.queueServerWork(15, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.guitar")), SoundSource.NEUTRAL, 4, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.guitar")), SoundSource.NEUTRAL, 4, 1, false);
						}
					}
				});
				if (entity.isShiftKeyDown()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, 1000, 3, 3, 3, 1);
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), 6);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 400, 1));
							}
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 200);
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0));
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 300);
				}
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 20;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}