package net.mcreator.dcc.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModBlocks;
import net.mcreator.dcc.entity.SlotMachineEntityEntity;

import java.util.Random;

public class SlotMachineEntityRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Random = 0;
		if (entity != null) {
			if (entity instanceof SlotMachineEntityEntity _datEntL0 && _datEntL0.getEntityData().get(SlotMachineEntityEntity.DATA_Clicked)) {
				if (entity instanceof SlotMachineEntityEntity _datEntSetL)
					_datEntSetL.getEntityData().set(SlotMachineEntityEntity.DATA_Clicked, false);
				Random = Mth.nextInt(RandomSource.create(), 1, 6);
				if (Random == 1) {
					if (entity instanceof SlotMachineEntityEntity) {
						((SlotMachineEntityEntity) entity).setAnimation("1");
					}
				} else if (true) {
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
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + Random)), false);
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