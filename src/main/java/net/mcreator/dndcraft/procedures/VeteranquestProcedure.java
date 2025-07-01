package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class VeteranquestProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Monsterdelightquest == -1) {
			if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).CookingVeteranquest > -1) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.CookingVeteranquest = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).CookingVeteranquest + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A74 you have ate"), false);
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).CookingVeteranquest == 80) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A74You have completed the cooks quest: Cooking veteran"), false);
				}
			}
		}
	}
}
