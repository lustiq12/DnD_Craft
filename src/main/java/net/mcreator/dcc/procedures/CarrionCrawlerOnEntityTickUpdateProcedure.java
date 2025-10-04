package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.dcc.init.DccModEntities;
import net.mcreator.dcc.entity.TentaclesEntity;
import net.mcreator.dcc.entity.CarrionCrawlerPoisonEntity;
import net.mcreator.dcc.entity.CarrionCrawlerEntity;
import net.mcreator.dcc.DccMod;

import java.util.Comparator;

public class CarrionCrawlerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		double Vx = 0;
		double vy = 0;
		double chance = 0;
		double vz = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double Px = 0;
		double py = 0;
		double pz = 0;
		double radius = 0;
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getDouble("SpitCd") == 0) {
				entity.getPersistentData().putDouble("SpitCd", 1);
			} else {
				entity.getPersistentData().putDouble("SpitCd", (entity.getPersistentData().getDouble("SpitCd") + 1));
			}
			if (entity.getPersistentData().getDouble("SpitCd") == 200) {
				if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
					if (entity instanceof CarrionCrawlerEntity) {
						((CarrionCrawlerEntity) entity).setAnimation("tentecalinground");
					}
					DccMod.queueServerWork(25, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof Player) {
									if (entityiterator instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
										_livingEntity10.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
												.setBaseValue((((entityiterator instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
														? _livingEntity9.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
														: 0) + 1) * 100));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 115, 254, false, false));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 115, 1, false, false));
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = DccModEntities.TENTACLES.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										Entity _ent = (findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4));
										_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
									}
									if ((findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof TentaclesEntity) {
										((TentaclesEntity) (findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("attack");
									}
									DccMod.queueServerWork(25, () -> {
										if ((findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof TentaclesEntity) {
											((TentaclesEntity) (findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("idleReal");
										}
										DccMod.queueServerWork(40, () -> {
											if ((findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof TentaclesEntity) {
												((TentaclesEntity) (findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("idleReal");
											}
											DccMod.queueServerWork(40, () -> {
												if ((findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4)) instanceof TentaclesEntity) {
													((TentaclesEntity) (findEntityInWorldRange(world, TentaclesEntity.class, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4))).setAnimation("despawn");
												}
												if (entityiterator.isAlive()) {
													if (entityiterator instanceof LivingEntity _livingEntity47 && _livingEntity47.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
														_livingEntity47.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
																.setBaseValue(((entityiterator instanceof LivingEntity _livingEntity46 && _livingEntity46.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
																		? _livingEntity46.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
																		: 0) / 100 - 1));
												}
											});
										});
									});
								}
							}
						}
					});
				} else if (true) {
					entity.getPersistentData().putDouble("SpitCd", 1);
					if (entity instanceof CarrionCrawlerEntity) {
						((CarrionCrawlerEntity) entity).setAnimation("poisonspit");
					}
					DccMod.queueServerWork(20, () -> {
						if (!((findEntityInWorldRange(world, Player.class, x, y, z, 20)) == null)) {
							entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((findEntityInWorldRange(world, Player.class, x, y, z, 20)).getX()), ((findEntityInWorldRange(world, Player.class, x, y, z, 20)).getY() + 2),
									((findEntityInWorldRange(world, Player.class, x, y, z, 20)).getZ())));
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = initArrowProjectile(
											new CarrionCrawlerPoisonEntity(DccModEntities.CARRION_CRAWLER_POISON.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, (int) 0.1, (byte) 0)), entity, 3, true, false, false,
											AbstractArrow.Pickup.DISALLOWED);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
					});
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static ItemStack createArrowWeaponItemStack(Level level, int knockback, byte piercing) {
		ItemStack weapon = new ItemStack(Items.ARROW);
		if (knockback > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), knockback);
		if (piercing > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), piercing);
		return weapon;
	}
}