package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class MonsterdelightquestProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).DailyRationQuest == -1) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Monsterdelightquest > -1) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.Monsterdelightquest = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Monsterdelightquest + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Monsterdelightquest == 40) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A74You have completed the cooks quest: Monster delight"), false);
				}
			}
		}
	}
}
