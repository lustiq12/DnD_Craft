package net.mcreator.dcc.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.init.DccModItems;
import net.mcreator.dcc.init.DccModBlocks;

public class DaggerRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == DccModBlocks.COOKED_OWLBEAR_MEAT_BLOCK.get()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = DccModBlocks.COOKEDOWLBEARMEATBLOCK_2.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				for (int index0 = 0; index0 < 2; index0++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.OWLBEAR_MEAT_STRIPE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == DccModBlocks.COOKEDOWLBEARMEATBLOCK_2.get()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = DccModBlocks.COOKEDOWLBEARMEATBLOCK_3.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				for (int index1 = 0; index1 < 2; index1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.OWLBEAR_MEAT_STRIPE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == DccModBlocks.COOKEDOWLBEARMEATBLOCK_3.get()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = DccModBlocks.COOKEDOWLBEARMEATBLOCK_4.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				for (int index2 = 0; index2 < 2; index2++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.OWLBEAR_MEAT_STRIPE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
			}
		}
	}
}