package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.network.DccModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LifeextraperlevelProcedure {
	@SubscribeEvent
	public static void onPlayerXPChange(PlayerXpEvent.XpChange event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		{
			DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
			_vars.Lvlxp = entity.getData(DccModVariables.PLAYER_VARIABLES).Lvlxp + amount;
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(DccModVariables.PLAYER_VARIABLES).Lvlxp >= Math.pow(entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel, 2) * 35) {
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.Lvlxp = entity.getData(DccModVariables.PLAYER_VARIABLES).Lvlxp - Math.pow(entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel, 2) * 35;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.PlayerLevel = entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.MaxMana = entity.getData(DccModVariables.PLAYER_VARIABLES).MaxMana + 20;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.MaxKi = entity.getData(DccModVariables.PLAYER_VARIABLES).MaxKi + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity1.getAttribute(Attributes.MAX_HEALTH)
						.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity0.getAttribute(Attributes.MAX_HEALTH).getValue() : 0) + 1));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.NEUTRAL, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.NEUTRAL, 2, 1, false);
				}
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A74You leveled up! You are now level " + Math.round(entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel))), false);
		}
		{
			DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
			_vars.XpPercent = (entity.getData(DccModVariables.PLAYER_VARIABLES).Lvlxp / (Math.pow(entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel, 2) * 35)) * 100;
			_vars.syncPlayerVariables(entity);
		}
	}
}