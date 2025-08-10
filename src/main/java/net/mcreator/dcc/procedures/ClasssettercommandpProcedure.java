package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.dcc.network.DccModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class ClasssettercommandpProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Old class: " + entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable + "\n" + "Class set to: " + StringArgumentType.getString(arguments, "classname") + "\n"
					+ "This only works if the class name is one from the ones you" + "\n" + "can choose in the gui and if the first letter is capital.")), false);
		{
			DccModVariables.PlayerVariables _vars = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "Player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getData(DccModVariables.PLAYER_VARIABLES);
			_vars.Class_Variable = StringArgumentType.getString(arguments, "classname");
			_vars.syncPlayerVariables((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "Player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()));
		}
	}
}
