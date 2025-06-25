package net.mcreator.dndcraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

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
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.dndcraft.network.DndCraftModVariables;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PassiveabilitysProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
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
		if (9 < (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).PlayerLevel) {
			if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Barbarian")) {
				if (8 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Bard")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 0));
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Monk")) {
				if (1 > (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown) {
					if (1 < (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Ki) {
						if (10 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 6, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 6, 1, false);
								}
							}
							{
								double _setval = (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Ki - 1;
								entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Ki = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CHERRY_LEAVES, x, y, z, 2000, 5, 5, 3, 0.01);
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									{
										double _setval = 25;
										entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.cooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
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
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Druid")) {
				if (Mth.nextInt(RandomSource.create(), 1, 40) == 1) {
					sx = -3;
					found = false;
					for (int index0 = 0; index0 < 6; index0++) {
						sy = -3;
						for (int index1 = 0; index1 < 6; index1++) {
							sz = -3;
							for (int index2 = 0; index2 < 6; index2++) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("" + (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("dnd_craft:druid_plants"))))), false);
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("dnd_craft:druid_plants")))) {
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
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 1, false, false));
					}
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Sorcerer")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Fighter")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
			}
		}
		if (19 < (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).PlayerLevel) {
			if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Barbarian")) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "attribute @p minecraft:generic.attack_damage base set 4");
					}
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Monk")) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BLINDNESS);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HUNGER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WITHER);
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Druid")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Sorcerer")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Fighter")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
			}
		}
	}
}
