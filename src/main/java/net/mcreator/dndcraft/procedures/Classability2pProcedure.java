package net.mcreator.dndcraft.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.dndcraft.network.DndCraftModVariables;
import net.mcreator.dndcraft.init.DndCraftModItems;
import net.mcreator.dndcraft.init.DndCraftModEntities;
import net.mcreator.dndcraft.entity.VINESEntity;
import net.mcreator.dndcraft.DndCraftMod;

import java.util.List;
import java.util.Comparator;

public class Classability2pProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity vines_entity = null;
		if (4 < (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).PlayerLevel) {
			if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Bard")) {
				if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown < 0.05) {
					{
						double _setval = 30;
						entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
							}
						}
					}
					DndCraftMod.queueServerWork(10, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
								}
							}
						}
						DndCraftMod.queueServerWork(10, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
									}
								}
							}
							DndCraftMod.queueServerWork(10, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
										}
									}
								}
							});
						});
					});
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Barbarian")) {
				if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown < 0.05) {
					{
						double _setval = 45;
						entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DndCraftModItems.GHOST_AXE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					DndCraftMod.queueServerWork(500, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(DndCraftModItems.GHOST_AXE.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Monk")) {
				if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown < 0.05) {
					if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Ki > 0) {
						if (4 > (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)) {
							{
								double _setval = 30;
								entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.cooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Ki - 1;
								entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Ki = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1));
						}
					}
				}
			} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Druid")) {
				if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown < 0.05) {
					{
						double _setval = 30;
						entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof Player)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 115, 254, false, false));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 115, 254, false, false));
								{
									Entity _ent = entityiterator;
									_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = DndCraftModEntities.VINES.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								if (((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof VINESEntity) {
									((VINESEntity) ((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream()
											.sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null))).setAnimation("attack");
								}
								DndCraftMod.queueServerWork(25, () -> {
									if (((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof VINESEntity) {
										((VINESEntity) ((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream()
												.sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null))).setAnimation("idleReal");
									}
									DndCraftMod.queueServerWork(40, () -> {
										if (((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof VINESEntity) {
											((VINESEntity) ((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream()
													.sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null))).setAnimation("idleReal");
										}
										DndCraftMod.queueServerWork(40, () -> {
											if (((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof VINESEntity) {
												((VINESEntity) ((Entity) world.getEntitiesOfClass(VINESEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 4, 4, 4), e -> true).stream()
														.sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null))).setAnimation("despawn");
											}
										});
									});
								});
							}
						}
					}
				}
			}
		}
	}
}
