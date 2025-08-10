package net.mcreator.dndcraft.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.dndcraft.DndCraftMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DndCraftModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, DndCraftMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DndCraftMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.Class_Variable = original.Class_Variable;
			clone.first_join = original.first_join;
			clone.wutrausch = original.wutrausch;
			clone.cooldown = original.cooldown;
			clone.PlayerLevel = original.PlayerLevel;
			clone.Spell = original.Spell;
			clone.Mana = original.Mana;
			clone.Dogde = original.Dogde;
			clone.Ki = original.Ki;
			clone.Lvlxp = original.Lvlxp;
			clone.DailyRationQuest = original.DailyRationQuest;
			clone.Monsterdelightquest = original.Monsterdelightquest;
			clone.CookingVeteranquest = original.CookingVeteranquest;
			clone.MaxMana = original.MaxMana;
			clone.MaxKi = original.MaxKi;
			clone.XpPercent = original.XpPercent;
			if (!event.isWasDeath()) {
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public String Class_Variable = "false";
		public boolean first_join = true;
		public boolean wutrausch = false;
		public double cooldown = 0;
		public double PlayerLevel = 0;
		public String Spell = "\"\"";
		public double Mana = 100.0;
		public boolean Dogde = false;
		public double Ki = 2.0;
		public double Lvlxp = 0.0;
		public double DailyRationQuest = 0.0;
		public double Monsterdelightquest = 0;
		public double CookingVeteranquest = 0.0;
		public double MaxMana = 100.0;
		public double MaxKi = 2.0;
		public double XpPercent = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Class_Variable", Class_Variable);
			nbt.putBoolean("first_join", first_join);
			nbt.putBoolean("wutrausch", wutrausch);
			nbt.putDouble("cooldown", cooldown);
			nbt.putDouble("PlayerLevel", PlayerLevel);
			nbt.putString("Spell", Spell);
			nbt.putDouble("Mana", Mana);
			nbt.putBoolean("Dogde", Dogde);
			nbt.putDouble("Ki", Ki);
			nbt.putDouble("Lvlxp", Lvlxp);
			nbt.putDouble("DailyRationQuest", DailyRationQuest);
			nbt.putDouble("Monsterdelightquest", Monsterdelightquest);
			nbt.putDouble("CookingVeteranquest", CookingVeteranquest);
			nbt.putDouble("MaxMana", MaxMana);
			nbt.putDouble("MaxKi", MaxKi);
			nbt.putDouble("XpPercent", XpPercent);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			Class_Variable = nbt.getString("Class_Variable");
			first_join = nbt.getBoolean("first_join");
			wutrausch = nbt.getBoolean("wutrausch");
			cooldown = nbt.getDouble("cooldown");
			PlayerLevel = nbt.getDouble("PlayerLevel");
			Spell = nbt.getString("Spell");
			Mana = nbt.getDouble("Mana");
			Dogde = nbt.getBoolean("Dogde");
			Ki = nbt.getDouble("Ki");
			Lvlxp = nbt.getDouble("Lvlxp");
			DailyRationQuest = nbt.getDouble("DailyRationQuest");
			Monsterdelightquest = nbt.getDouble("Monsterdelightquest");
			CookingVeteranquest = nbt.getDouble("CookingVeteranquest");
			MaxMana = nbt.getDouble("MaxMana");
			MaxKi = nbt.getDouble("MaxKi");
			XpPercent = nbt.getDouble("XpPercent");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(DndCraftMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
