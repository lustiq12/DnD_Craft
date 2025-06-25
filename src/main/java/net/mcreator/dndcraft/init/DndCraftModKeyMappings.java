
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.dndcraft.network.DodgeMessage;
import net.mcreator.dndcraft.network.ClassabilityopnguiMessage;
import net.mcreator.dndcraft.network.Classability3Message;
import net.mcreator.dndcraft.network.Classability2Message;
import net.mcreator.dndcraft.network.Classability1Message;
import net.mcreator.dndcraft.DndCraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DndCraftModKeyMappings {
	public static final KeyMapping CLASSABILITY_1 = new KeyMapping("key.dnd_craft.classability_1", GLFW.GLFW_KEY_Y, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new Classability1Message(0, 0));
				Classability1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLASSABILITY_2 = new KeyMapping("key.dnd_craft.classability_2", GLFW.GLFW_KEY_X, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new Classability2Message(0, 0));
				Classability2Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLASSABILITY_3 = new KeyMapping("key.dnd_craft.classability_3", GLFW.GLFW_KEY_C, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new Classability3Message(0, 0));
				Classability3Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLASSABILITYOPNGUI = new KeyMapping("key.dnd_craft.classabilityopngui", GLFW.GLFW_KEY_O, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new ClassabilityopnguiMessage(0, 0));
				ClassabilityopnguiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DODGE = new KeyMapping("key.dnd_craft.dodge", GLFW.GLFW_KEY_SLASH, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new DodgeMessage(0, 0));
				DodgeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(CLASSABILITY_1);
		event.register(CLASSABILITY_2);
		event.register(CLASSABILITY_3);
		event.register(CLASSABILITYOPNGUI);
		event.register(DODGE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				CLASSABILITY_1.consumeClick();
				CLASSABILITY_2.consumeClick();
				CLASSABILITY_3.consumeClick();
				CLASSABILITYOPNGUI.consumeClick();
				DODGE.consumeClick();
			}
		}
	}
}
