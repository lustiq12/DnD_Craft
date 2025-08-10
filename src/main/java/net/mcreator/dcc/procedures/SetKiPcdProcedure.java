package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.dcc.network.DccModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetKiPcdProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			DccModVariables.PlayerVariables _vars = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "Player_name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getData(DccModVariables.PLAYER_VARIABLES);
			_vars.Ki = DoubleArgumentType.getDouble(arguments, "ki");
			_vars.syncPlayerVariables((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "Player_name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()));
		}
	}
}
