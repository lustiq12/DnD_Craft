package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;

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
		if (!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
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
		}
	}
}
