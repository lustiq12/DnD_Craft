package net.mcreator.dcc.procedures;

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

import net.mcreator.dcc.world.inventory.MagicChooseMenu;
import net.mcreator.dcc.network.DccModVariables;

import io.netty.buffer.Unpooled;

public class MagicWandRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MagicChoose");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MagicChooseMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else {
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician")) {
				if (9 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("firearrow")) {
						FirearrowCastProcedure.execute(world, x, y, z, entity);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 10;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("coldray")) {
						ColdrayCastProcedure.execute(entity);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 10;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (19 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("thunderwave")) {
						ThunderwaveCastProcedure.execute(world, x, y, z);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 20;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (39 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("fireball")) {
						FireballCastProcedure.execute(world, x, y, z, entity);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 40;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("snowstorm")) {
						SnowstormCastProcedure.execute(world, x, y, z);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 40;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (49 < entity.getData(DccModVariables.PLAYER_VARIABLES).Mana) {
						if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("firewall")) {
							FirewallCastProcedure.execute(world, x, y, z);
							{
								DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
								_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 50;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
				}
			}
		}
	}
}
