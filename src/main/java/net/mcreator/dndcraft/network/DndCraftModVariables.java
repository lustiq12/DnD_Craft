package net.mcreator.dndcraft.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.dndcraft.DndCraftMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DndCraftModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DndCraftMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.first_join = original.first_join;
			if (!event.isWasDeath()) {
				clone.Class_Variable = original.Class_Variable;
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
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("dnd_craft", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String Class_Variable = "false";
		public boolean first_join = true;
		public boolean wutrausch = false;
		public double cooldown = 0;
		public double PlayerLevel = 0;
		public String Spell = "\"\"";
		public double Mana = 100.0;
		public boolean Dogde = false;
		public double Ki = 0;
		public double Lvlxp = 0;
		public double DailyRationQuest = 0;
		public double Monsterdelightquest = 0;
		public double CookingVeteranquest = 0.0;
		public double MaxMana = 100.0;
		public double MaxKi = 2.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				DndCraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
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
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
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
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Class_Variable = message.data.Class_Variable;
					variables.first_join = message.data.first_join;
					variables.wutrausch = message.data.wutrausch;
					variables.cooldown = message.data.cooldown;
					variables.PlayerLevel = message.data.PlayerLevel;
					variables.Spell = message.data.Spell;
					variables.Mana = message.data.Mana;
					variables.Dogde = message.data.Dogde;
					variables.Ki = message.data.Ki;
					variables.Lvlxp = message.data.Lvlxp;
					variables.DailyRationQuest = message.data.DailyRationQuest;
					variables.Monsterdelightquest = message.data.Monsterdelightquest;
					variables.CookingVeteranquest = message.data.CookingVeteranquest;
					variables.MaxMana = message.data.MaxMana;
					variables.MaxKi = message.data.MaxKi;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
