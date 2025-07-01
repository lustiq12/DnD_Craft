package net.mcreator.dndcraft.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.dndcraft.world.inventory.MonkGuiMenu;
import net.mcreator.dndcraft.world.inventory.MagierguiMenu;
import net.mcreator.dndcraft.world.inventory.DruidGuiMenu;
import net.mcreator.dndcraft.world.inventory.ClassesMenu;
import net.mcreator.dndcraft.world.inventory.BardeguiMenu;
import net.mcreator.dndcraft.world.inventory.BarbarGuiMenu;
import net.mcreator.dndcraft.network.DndCraftModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ManaProcedure {
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
		if (entity.isAlive()) {
			if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("false")) {
				if (!(entity instanceof Player _plr0 && _plr0.containerMenu instanceof BarbarGuiMenu || entity instanceof Player _plr1 && _plr1.containerMenu instanceof ClassesMenu
						|| entity instanceof Player _plr2 && _plr2.containerMenu instanceof BardeguiMenu || entity instanceof Player _plr3 && _plr3.containerMenu instanceof MagierguiMenu
						|| entity instanceof Player _plr4 && _plr4.containerMenu instanceof MonkGuiMenu || entity instanceof Player _plr5 && _plr5.containerMenu instanceof DruidGuiMenu || false)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Choose a class using the key \"V\" or what you changed it to in the settings."), true);
				}
			}
			if (0 < entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown) {
				{
					DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
					_vars.cooldown = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown - 0.05;
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician") || (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Bard")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(("\u00A79Mana: " + Math.round(entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana) + " " + "\u00A76Cooldown: " + Math.round(entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown))), true);
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).MaxMana < entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana) {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).MaxMana;
						_vars.syncPlayerVariables(entity);
					}
				} else if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).MaxMana > entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana) {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana + 0.1;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Monk")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(("\u00A73Ki: " + Math.round(entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Ki) + " " + "\u00A76Cooldown: " + Math.round(entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown))), true);
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).MaxKi > entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Ki) {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Ki = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Ki + 0.00025;
						_vars.syncPlayerVariables(entity);
					}
				} else if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).MaxKi < entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Ki) {
					{
						DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
						_vars.Ki = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).MaxKi;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A76Cooldown: " + Math.round(entity.getData(DndCraftModVariables.PLAYER_VARIABLES).cooldown))), true);
			}
		}
	}
}
