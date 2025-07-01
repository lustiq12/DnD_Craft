
package net.mcreator.dndcraft.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
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

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MagicChooseButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<MagicChooseButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(DndCraftMod.MODID, "magic_choose_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MagicChooseButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MagicChooseButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new MagicChooseButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<MagicChooseButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MagicChooseButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
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
		DndCraftMod.addNetworkMessage(MagicChooseButtonMessage.TYPE, MagicChooseButtonMessage.STREAM_CODEC, MagicChooseButtonMessage::handleData);
	}
}
