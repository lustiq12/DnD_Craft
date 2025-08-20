package net.mcreator.dcc.network;

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

import net.mcreator.dcc.procedures.PaladinOpenProcedure;
import net.mcreator.dcc.procedures.MonkopenProcedure;
import net.mcreator.dcc.procedures.MagieropenProcedure;
import net.mcreator.dcc.procedures.DruidOpenProcedure;
import net.mcreator.dcc.procedures.BardeopenProcedure;
import net.mcreator.dcc.procedures.BarbaropenProcedure;
import net.mcreator.dcc.DccMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record ClassesButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ClassesButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(DccMod.MODID, "classes_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClassesButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ClassesButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ClassesButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ClassesButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ClassesButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			BarbaropenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BardeopenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			DruidOpenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			MagieropenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			MonkopenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			PaladinOpenProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DccMod.addNetworkMessage(ClassesButtonMessage.TYPE, ClassesButtonMessage.STREAM_CODEC, ClassesButtonMessage::handleData);
	}
}