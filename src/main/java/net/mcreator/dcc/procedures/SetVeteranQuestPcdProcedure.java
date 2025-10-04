package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.dcc.network.DccModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetVeteranQuestPcdProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			DccModVariables.PlayerVariables _vars = (commandParameterEntity(arguments, "Player_name")).getData(DccModVariables.PLAYER_VARIABLES);
			_vars.CookingVeteranquest = DoubleArgumentType.getDouble(arguments, "mana");
			_vars.syncPlayerVariables((commandParameterEntity(arguments, "Player_name")));
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}