package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.dcc.network.DccModVariables;

public class DailyRationQuestProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DccModVariables.PLAYER_VARIABLES).DailyRationQuest > -1) {
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.DailyRationQuest = entity.getData(DccModVariables.PLAYER_VARIABLES).DailyRationQuest + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(DccModVariables.PLAYER_VARIABLES).DailyRationQuest == 12) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You have completed the cooks quest: Daily eater"), false);
			}
		}
	}
}