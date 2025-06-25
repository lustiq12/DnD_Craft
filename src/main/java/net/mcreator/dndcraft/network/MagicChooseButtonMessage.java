
package net.mcreator.dndcraft.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.dndcraft.world.inventory.MagicChooseMenu;
import net.mcreator.dndcraft.procedures.ThunderwaveProcedure;
import net.mcreator.dndcraft.procedures.StronginvisibilityProcedure;
import net.mcreator.dndcraft.procedures.SnowstormProcedure;
import net.mcreator.dndcraft.procedures.NightvisionProcedure;
import net.mcreator.dndcraft.procedures.IvisibilityProcedure;
import net.mcreator.dndcraft.procedures.FirewallProcedure;
import net.mcreator.dndcraft.procedures.FireballProcedure;
import net.mcreator.dndcraft.procedures.FirearrowProcedure;
import net.mcreator.dndcraft.procedures.FakelifeProcedure;
import net.mcreator.dndcraft.procedures.ColdrayProcedure;
import net.mcreator.dndcraft.DndCraftMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagicChooseButtonMessage {
	private final int buttonID, x, y, z;

	public MagicChooseButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MagicChooseButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MagicChooseButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MagicChooseButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = MagicChooseMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			FirearrowProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ColdrayProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ThunderwaveProcedure.execute(entity);
		}
		if (buttonID == 3) {

			FakelifeProcedure.execute(entity);
		}
		if (buttonID == 4) {

			IvisibilityProcedure.execute(entity);
		}
		if (buttonID == 5) {

			NightvisionProcedure.execute(entity);
		}
		if (buttonID == 6) {

			FireballProcedure.execute(entity);
		}
		if (buttonID == 7) {

			SnowstormProcedure.execute(entity);
		}
		if (buttonID == 8) {

			FirewallProcedure.execute(entity);
		}
		if (buttonID == 9) {

			StronginvisibilityProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DndCraftMod.addNetworkMessage(MagicChooseButtonMessage.class, MagicChooseButtonMessage::buffer, MagicChooseButtonMessage::new, MagicChooseButtonMessage::handler);
	}
}
