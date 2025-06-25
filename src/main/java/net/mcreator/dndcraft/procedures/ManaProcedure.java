package net.mcreator.dndcraft.procedures;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.dndcraft.world.inventory.MonkGuiMenu;
import net.mcreator.dndcraft.world.inventory.MagierguiMenu;
import net.mcreator.dndcraft.world.inventory.DruidGuiMenu;
import net.mcreator.dndcraft.world.inventory.ClassesMenu;
import net.mcreator.dndcraft.world.inventory.BardeguiMenu;
import net.mcreator.dndcraft.world.inventory.BarbarGuiMenu;
import net.mcreator.dndcraft.network.DndCraftModVariables;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@Mod.EventBusSubscriber
public class ManaProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("false")) {
			if (entity.isAlive() && !(entity instanceof Player _plr0 && _plr0.containerMenu instanceof BarbarGuiMenu || entity instanceof Player _plr1 && _plr1.containerMenu instanceof ClassesMenu
					|| entity instanceof Player _plr2 && _plr2.containerMenu instanceof BardeguiMenu || entity instanceof Player _plr3 && _plr3.containerMenu instanceof MagierguiMenu
					|| entity instanceof Player _plr4 && _plr4.containerMenu instanceof MonkGuiMenu || entity instanceof Player _plr5 && _plr5.containerMenu instanceof DruidGuiMenu || false)) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Classes");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ClassesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if (0 < (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown) {
			{
				double _setval = (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown - 0.05;
				entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Magician")
				|| ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Bard")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A79Mana: " + Math.round((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Mana) + " "
						+ "\u00A76Cooldown: " + Math.round((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown))), true);
			if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).MaxMana < (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DndCraftModVariables.PlayerVariables())).Mana) {
				{
					double _setval = (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).MaxMana;
					entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).MaxMana > (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DndCraftModVariables.PlayerVariables())).Mana) {
				{
					double _setval = (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Mana + 0.1;
					entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Class_Variable).equals("Monk")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A73Ki: " + Math.round((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Ki) + " "
						+ "\u00A76Cooldown: " + Math.round((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown))), true);
			if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).MaxKi > (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DndCraftModVariables.PlayerVariables())).Ki) {
				{
					double _setval = (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).Ki + 0.00025;
					entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Ki = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).MaxKi < (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DndCraftModVariables.PlayerVariables())).Ki) {
				{
					double _setval = (entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).MaxKi;
					entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Ki = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A76Cooldown: " + Math.round((entity.getCapability(DndCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndCraftModVariables.PlayerVariables())).cooldown))), true);
		}
	}
}
