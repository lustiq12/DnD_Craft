package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.dcc.network.DccModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetLevelPcdProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
			_vars.MaxMana = entity.getData(DccModVariables.PLAYER_VARIABLES).MaxMana + 20 * (DoubleArgumentType.getDouble(arguments, "level") - entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel);
			_vars.syncPlayerVariables(entity);
		}
		{
			DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
			_vars.MaxKi = entity.getData(DccModVariables.PLAYER_VARIABLES).Ki + 1 * (DoubleArgumentType.getDouble(arguments, "level") - entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel);
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
			_livingEntity4.getAttribute(Attributes.MAX_HEALTH)
					.setBaseValue(((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity2.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0)
							+ 1 * (DoubleArgumentType.getDouble(arguments, "level") - entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel)));
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
			_vars.PlayerLevel = DoubleArgumentType.getDouble(arguments, "level");
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
		if (entity instanceof Player _player)
			_player.giveExperiencePoints((int) 0.91);
		if (entity instanceof Player _player)
			_player.giveExperiencePoints(-((int) 0.91));
	}
}
