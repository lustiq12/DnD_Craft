package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;
import net.mcreator.dcc.init.DccModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ResetVariablesProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getLevelData().getGameRules().getBoolean(DccModGameRules.KEEP_CLASS_LEVELS_AND_GET_NO_STARTERITEMS_ON_RESPAWN)) {
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.cooldown = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.PlayerLevel = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.Mana = 100;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.Ki = 2;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.Lvlxp = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.MaxMana = 100;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.MaxKi = 2;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.XpPercent = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.Spell = "";
				_vars.syncPlayerVariables(entity);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.Class_Variable = "false";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(2);
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity2.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		}
	}
}