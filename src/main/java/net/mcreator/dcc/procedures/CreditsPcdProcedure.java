package net.mcreator.dcc.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class CreditsPcdProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("People who worked on the mods and/or gave ideas for features:" + "\n" + "Luderspieler: Main coder / some art" + "\n" + "Ppotatoe: Main artist / some code" + "\n" + "sogiki king: Creative input")), false);
	}
}