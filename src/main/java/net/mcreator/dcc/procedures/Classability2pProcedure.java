package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.network.DccModVariables;
import net.mcreator.dcc.init.DccModItems;
import net.mcreator.dcc.init.DccModEntities;
import net.mcreator.dcc.init.DccModBlocks;
import net.mcreator.dcc.entity.VINESEntity;
import net.mcreator.dcc.DccMod;

import java.util.Comparator;

public class Classability2pProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity vines_entity = null;
		if (4 < entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel) {
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Bard")) {
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.cooldown = 30;
						_vars.syncPlayerVariables(entity);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
							}
						}
					}
					DccMod.queueServerWork(10, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (!(entityiterator == entity)) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
								}
							}
						}
						DccMod.queueServerWork(10, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (!(entityiterator == entity)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
									}
								}
							}
							DccMod.queueServerWork(10, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, 3000, 3, 3, 3, 0.5);
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (!(entityiterator == entity)) {
											entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
										}
									}
								}
							});
						});
					});
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Barbarian")) {
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.cooldown = 45;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DccModItems.GHOST_AXE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					DccMod.queueServerWork(500, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(DccModItems.GHOST_AXE.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Monk")) {
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
					if (entity.getData(DccModVariables.PLAYER_VARIABLES).Ki > 0) {
						if (4 > (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)) {
							{
								DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
								_vars.cooldown = 30;
								_vars.syncPlayerVariables(entity);
							}
							{
								DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
								_vars.Ki = entity.getData(DccModVariables.PLAYER_VARIABLES).Ki - 1;
								_vars.syncPlayerVariables(entity);
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1));
						}
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Druid")) {
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.cooldown = 30;
						_vars.syncPlayerVariables(entity);
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator instanceof Player)) {
								if (entityiterator instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
									_livingEntity30.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
											.setBaseValue((((entityiterator instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
													? _livingEntity29.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
													: 0) + 1) * 100));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 115, 254, false, false));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 115, 254, false, false));
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = DccModEntities.VINES.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								{
									Entity _ent = (findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4));
									_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
								}
								if ((findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof VINESEntity) {
									((VINESEntity) (findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("attack");
								}
								DccMod.queueServerWork(25, () -> {
									if ((findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof VINESEntity) {
										((VINESEntity) (findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("idleReal");
									}
									DccMod.queueServerWork(40, () -> {
										if ((findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof VINESEntity) {
											((VINESEntity) (findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("idleReal");
										}
										DccMod.queueServerWork(40, () -> {
											if ((findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof VINESEntity) {
												((VINESEntity) (findEntityInWorldRange(world, VINESEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("despawn");
											}
											if (entityiterator.isAlive()) {
												if (entityiterator instanceof LivingEntity _livingEntity67 && _livingEntity67.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
													_livingEntity67.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
															.setBaseValue(((entityiterator instanceof LivingEntity _livingEntity66 && _livingEntity66.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
																	? _livingEntity66.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
																	: 0) / 100 - 1));
											}
										});
									});
								});
							}
						}
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Paladin")) {
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
					if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR) {
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.cooldown = 30;
							_vars.syncPlayerVariables(entity);
						}
						world.setBlock(BlockPos.containing(x, y + 2, z), DccModBlocks.SANCTIFIED_BEACON.get().defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y + 2, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75 Not possible! block above you is NOT air!"), false);
					}
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}