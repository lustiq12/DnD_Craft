package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.world.inventory.MagicChooseMenu;
import net.mcreator.dcc.network.DccModVariables;
import net.mcreator.dcc.init.DccModEntities;
import net.mcreator.dcc.entity.Fireball2Entity;
import net.mcreator.dcc.entity.ColdrayspellEntity;
import net.mcreator.dcc.DccMod;

import java.util.List;
import java.util.Comparator;

import io.netty.buffer.Unpooled;

public class MagicWandRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MagicChoose");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MagicChooseMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else {
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician")) {
				if (9 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("firearrow")) {
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getFireball(Level level, double ax, double ay, double az) {
										AbstractHurtingProjectile entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, level);
										entityToSpawn.setDeltaMovement(new Vec3(ax, ay, az));
										entityToSpawn.hasImpulse = true;
										return entityToSpawn;
									}
								}.getFireball(projectileLevel, (entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 7, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 4, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 4, 1, false);
							}
						}
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 10;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("coldray")) {
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ColdrayspellEntity(DccModEntities.COLDRAYSPELL.get(), level) {
											@Override
											public byte getPierceLevel() {
												return piercing;
											}

											@Override
											protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
												if (knockback > 0) {
													double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
													Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
													if (vec3.lengthSqr() > 0.0) {
														livingEntity.push(vec3.x, 0.1, vec3.z);
													}
												}
											}
										};
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, 1, 1, (byte) 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 10;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (19 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("thunderwave")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 4000, 3, 3, 3, 0.5);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 7, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 7, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player)) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 18);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255));
								}
							}
						}
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 20;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (39 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("fireball")) {
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new Fireball2Entity(DccModEntities.FIREBALL_2.get(), level) {
											@Override
											public byte getPierceLevel() {
												return piercing;
											}

											@Override
											protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
												if (knockback > 0) {
													double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
													Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
													if (vec3.lengthSqr() > 0.0) {
														livingEntity.push(vec3.x, 0.1, vec3.z);
													}
												}
											}
										};
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, 15, 1, (byte) 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 7, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 7, 1, false);
							}
						}
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 40;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("snowstorm")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SNOWFLAKE, x, y, z, 7000, 3, 3, 3, 0.001);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player)) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 3));
								}
							}
						}
						DccMod.queueServerWork(10, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1, false);
										}
									}
									if (!(entityiterator instanceof Player)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 3));
									}
								}
							}
						});
						DccMod.queueServerWork(20, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1, false);
										}
									}
									if (!(entityiterator instanceof Player)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 3));
									}
								}
							}
						});
						DccMod.queueServerWork(30, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1, false);
										}
									}
									if (!(entityiterator instanceof Player)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 3));
									}
								}
							}
						});
						DccMod.queueServerWork(40, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, 1, false);
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 7, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 7, 1, false);
										}
									}
									if (!(entityiterator instanceof Player)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 4);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 5));
									}
								}
							}
						});
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 40;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (49 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
						if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("firewall")) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLAME, x, y, z, 12000, 3, 3, 3, 0.001);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1, false);
								}
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator instanceof Player)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
										entityiterator.igniteForSeconds(5);
									}
								}
							}
							DccMod.queueServerWork(5, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, x, y, z, 6000, 3, 3, 3, 0.001);
							});
							DccMod.queueServerWork(10, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, x, y, z, 5000, 3, 3, 3, 0.001);
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1, false);
											}
										}
										if (!(entityiterator instanceof Player)) {
											entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
											entityiterator.igniteForSeconds(5);
										}
									}
								}
							});
							DccMod.queueServerWork(15, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, x, y, z, 6000, 3, 3, 3, 0.001);
							});
							DccMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, x, y, z, 5000, 3, 3, 3, 0.001);
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1, false);
											}
										}
										if (!(entityiterator instanceof Player)) {
											entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 20);
											entityiterator.igniteForSeconds(5);
										}
									}
								}
							});
							DccMod.queueServerWork(25, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, x, y, z, 6000, 3, 3, 3, 0.001);
							});
							DccMod.queueServerWork(30, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, x, y, z, 5000, 3, 3, 3, 0.001);
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.NEUTRAL, 5, 1, false);
											}
										}
										if (!(entityiterator instanceof Player)) {
											entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 30);
											entityiterator.igniteForSeconds(15);
										}
									}
								}
							});
							{
								DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
								_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 50;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
				}
			}
		}
	}
}
