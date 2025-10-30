package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModItems;
import net.mcreator.dcc.init.DccModBlocks;
import net.mcreator.dcc.entity.SlotMachineEntityEntity;
import net.mcreator.dcc.DccMod;

import java.util.Random;
import java.util.Comparator;

public class SlotMachineEntityRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Random = 0;
		double DropX = 0;
		double DropZ = 0;
		if (entity != null) {
			if (entity instanceof SlotMachineEntityEntity _datEntL0 && _datEntL0.getEntityData().get(SlotMachineEntityEntity.DATA_Clicked)) {
				if (entity instanceof SlotMachineEntityEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SlotMachineEntityEntity.DATA_Clicked, false);
				if (findEntityInWorldRange(world, Player.class, x, y, z, 10) != null && (entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_Random) : 0) == 0) {
					if (((findEntityInWorldRange(world, Player.class, x, y, z, 10)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == DccModItems.CARNIVAL_TICKET.get()) {
						((findEntityInWorldRange(world, Player.class, x, y, z, 10)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
						Random = Mth.nextInt(RandomSource.create(), 1, 6);
						if (Random == 1) {
							if (entity instanceof SlotMachineEntityEntity) {
								((SlotMachineEntityEntity) entity).setAnimation("1");
							}
						} else if (Random == 2) {
							if (entity instanceof SlotMachineEntityEntity) {
								((SlotMachineEntityEntity) entity).setAnimation("2");
							}
						} else if (Random == 3) {
							if (entity instanceof SlotMachineEntityEntity) {
								((SlotMachineEntityEntity) entity).setAnimation("3");
							}
						} else if (Random == 4) {
							if (entity instanceof SlotMachineEntityEntity) {
								((SlotMachineEntityEntity) entity).setAnimation("4");
							}
						} else if (Random == 5) {
							if (entity instanceof SlotMachineEntityEntity) {
								((SlotMachineEntityEntity) entity).setAnimation("5");
							}
						} else if (Random == 6) {
							if (entity instanceof SlotMachineEntityEntity) {
								((SlotMachineEntityEntity) entity).setAnimation("6");
							}
						}
						if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropX, (int) (x + 0));
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropZ, (int) (z - 1));
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropX, (int) (x + 1));
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropZ, (int) (z + 0));
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropX, (int) (x + 0));
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropZ, (int) (z + 1));
						} else {
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropX, (int) (x - 1));
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_DropZ, (int) (z + 0));
						}
						if (entity instanceof SlotMachineEntityEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_Random, (int) Random);
						DccMod.queueServerWork(60, () -> {
							if (entity != null) {
								if ((entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_Random) : 0) == 1) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
										}
									}
									DccMod.queueServerWork(5, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
											}
										}
										DccMod.queueServerWork(5, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
												}
											}
											DccMod.queueServerWork(5, () -> {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
													}
												}
												DccMod.queueServerWork(5, () -> {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropX) : 0), (y + 1),
																(entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropZ) : 0), new ItemStack(DccModItems.PLATIN_COIN.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
												});
											});
										});
									});
								} else if ((entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_Random) : 0) == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
										}
									}
									DccMod.queueServerWork(5, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
											}
										}
										DccMod.queueServerWork(5, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
												}
											}
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, (entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropX) : 0), (y + 1),
														(entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropZ) : 0), new ItemStack(DccModItems.GOLD_COIN.get()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
										});
									});
								} else if ((entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_Random) : 0) == 3) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
										}
									}
									DccMod.queueServerWork(5, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
											}
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropX) : 0), (y + 1),
													(entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropZ) : 0), new ItemStack(DccModItems.SILVER_COIN.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									});
								} else if ((entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_Random) : 0) == 4) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
										}
									}
									DccMod.queueServerWork(5, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
											}
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropX) : 0), (y + 1),
													(entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropZ) : 0), new ItemStack(DccModItems.SILVER_COIN.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									});
								} else if ((entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_Random) : 0) == 5) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropX) : 0), (y + 1),
												(entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropZ) : 0), new ItemStack(DccModItems.COPPER_COIN.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if ((entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_Random) : 0) == 6) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropX) : 0), (y + 1),
												(entity instanceof SlotMachineEntityEntity _datEntI ? _datEntI.getEntityData().get(SlotMachineEntityEntity.DATA_DropZ) : 0), new ItemStack(DccModItems.COPPER_COIN.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
							}
							if (entity instanceof SlotMachineEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SlotMachineEntityEntity.DATA_Random, 0);
						});
					} else {
						if ((findEntityInWorldRange(world, Player.class, x, y, z, 4)) instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c You need carnival tickets to play."), true);
					}
				}
			}
			if (entity != null) {
				if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
					{
						Entity _ent = entity;
						_ent.setYRot(180);
						_ent.setXRot(0);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
					{
						Entity _ent = entity;
						_ent.setYRot(270);
						_ent.setXRot(0);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
					{
						Entity _ent = entity;
						_ent.setYRot(0);
						_ent.setXRot(0);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				} else {
					{
						Entity _ent = entity;
						_ent.setYRot(90);
						_ent.setXRot(0);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				}
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == DccModBlocks.SLOT_MACHINE.get())) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}