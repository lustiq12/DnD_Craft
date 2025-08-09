package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.network.DndCraftModVariables;

public class ResetVariablesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.PlayerLevel = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.Mana = 100;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.Ki = 2;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.Lvlxp = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.MaxMana = 100;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.MaxKi = 2;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.XpPercent = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.Spell = "";
					_vars.syncPlayerVariables(entity);
				}
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.Class_Variable = "";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
