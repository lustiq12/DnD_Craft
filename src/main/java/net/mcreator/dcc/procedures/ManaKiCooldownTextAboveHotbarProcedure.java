package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.dcc.world.inventory.PaladinGuiMenu;
import net.mcreator.dcc.world.inventory.MonkGuiMenu;
import net.mcreator.dcc.world.inventory.MagierguiMenu;
import net.mcreator.dcc.world.inventory.DruidGuiMenu;
import net.mcreator.dcc.world.inventory.ClassesMenu;
import net.mcreator.dcc.world.inventory.BardeguiMenu;
import net.mcreator.dcc.world.inventory.BarbarGuiMenu;
import net.mcreator.dcc.network.DccModVariables;

import javax.annotation.Nullable;

import com.ibm.icu.util.Output;

@EventBusSubscriber
public class ManaKiCooldownTextAboveHotbarProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		String Output = "";
		if (entity.isAlive()) {
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("false")) {
				if (!(entity instanceof Player _plr0 && _plr0.containerMenu instanceof ClassesMenu || entity instanceof Player _plr1 && _plr1.containerMenu instanceof BarbarGuiMenu
						|| entity instanceof Player _plr2 && _plr2.containerMenu instanceof BardeguiMenu || entity instanceof Player _plr3 && _plr3.containerMenu instanceof MagierguiMenu
						|| entity instanceof Player _plr4 && _plr4.containerMenu instanceof MonkGuiMenu || entity instanceof Player _plr5 && _plr5.containerMenu instanceof DruidGuiMenu
						|| entity instanceof Player _plr6 && _plr6.containerMenu instanceof PaladinGuiMenu || false)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Choose a class using the key \"O\" or what you changed it to in the settings."), true);
				}
			}
			if (0 < entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown) {
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.cooldown = entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown - 0.05;
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician") || (entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Paladin")
					|| (entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Bard")) {
				Output = "\u00A79Mana: " + Math.round(entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) + " " + "\u00A76Cooldown: " + Math.round(entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown);
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).MaxMana < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).MaxMana;
						_vars.syncPlayerVariables(entity);
					}
				} else if (entity.getData(DccModVariables.PLAYER_VARIABLES).MaxMana > entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana + 0.1;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Monk")) {
				Output = "\u00A73Ki: " + Math.round(entity.getData(DccModVariables.PLAYER_VARIABLES).Ki) + " " + "\u00A76Cooldown: " + Math.round(entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown);
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).MaxKi > entity.getData(DccModVariables.PLAYER_VARIABLES).Ki) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Ki = entity.getData(DccModVariables.PLAYER_VARIABLES).Ki + 0.00025;
						_vars.syncPlayerVariables(entity);
					}
				} else if (entity.getData(DccModVariables.PLAYER_VARIABLES).MaxKi < entity.getData(DccModVariables.PLAYER_VARIABLES).Ki) {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Ki = entity.getData(DccModVariables.PLAYER_VARIABLES).MaxKi;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else {
				Output = "\u00A76Cooldown: " + Math.round(entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown);
			}
			{
				DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
				_vars.InfoText = Output;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}