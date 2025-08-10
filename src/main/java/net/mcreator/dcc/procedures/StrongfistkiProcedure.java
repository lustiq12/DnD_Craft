package net.mcreator.dcc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.dcc.network.DccModVariables;
import net.mcreator.dcc.init.DccModMobEffects;
import net.mcreator.dcc.DccMod;

public class StrongfistkiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 2, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 2, 1, false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(DccModMobEffects.KI_EFFECT_2, 100, 2));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 50, 0));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CHERRY_LEAVES, x, y, z, 250, 2, 2, 2, 0.03);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"attribute @p minecraft:generic.attack_speed base set 8");
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
			_vars.Ki = entity.getData(DccModVariables.PLAYER_VARIABLES).Ki - 1;
			_vars.syncPlayerVariables(entity);
		}
		{
			DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
			_vars.cooldown = 15;
			_vars.syncPlayerVariables(entity);
		}
		DccMod.queueServerWork(100, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"attribute @p minecraft:generic.attack_speed base set 4.3");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 2, 1, false);
				}
			}
		});
	}
}
