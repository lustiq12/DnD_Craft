package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
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

import net.mcreator.dndcraft.world.inventory.KiMenu;
import net.mcreator.dndcraft.network.DndCraftModVariables;
import net.mcreator.dndcraft.DndCraftMod;

import io.netty.buffer.Unpooled;

public class Classability1pProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Barbarian")) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 30;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 2000, 2, 2, 2, 0.6);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.wutrausch = true;
					_vars.syncPlayerVariables(entity);
				}
				DndCraftMod.queueServerWork(200, () -> {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.wutrausch = false;
						_vars.syncPlayerVariables(entity);
					}
				});
			}
		} else if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Bard")) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 20;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 1));
				if (79 < (entity instanceof Player _plr ? _plr.experienceLevel : 0)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 10));
				}
				DndCraftMod.queueServerWork(100, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1, false);
						}
					}
				});
			}
		} else if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician")) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 30;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 7, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 7, 1, false);
					}
				}
				DndCraftMod.queueServerWork(5, () -> {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DndCraftMod.queueServerWork(10, () -> {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DndCraftMod.queueServerWork(15, () -> {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DndCraftMod.queueServerWork(20, () -> {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DndCraftMod.queueServerWork(25, () -> {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DndCraftMod.queueServerWork(30, () -> {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
			}
		} else if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Monk")) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Ki > 0) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Ki");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new KiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Druid")) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 30;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
