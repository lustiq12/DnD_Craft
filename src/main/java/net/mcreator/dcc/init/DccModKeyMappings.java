/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.dcc.network.PaladinFlyMessage;
import net.mcreator.dcc.network.DodgeMessage;
import net.mcreator.dcc.network.ClassabilityopnguiMessage;
import net.mcreator.dcc.network.Classability3Message;
import net.mcreator.dcc.network.Classability2Message;
import net.mcreator.dcc.network.Classability1Message;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DccModKeyMappings {
	public static final KeyMapping CLASSABILITY_1 = new KeyMapping("key.dcc.classability_1", GLFW.GLFW_KEY_Y, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Classability1Message(0, 0));
				Classability1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLASSABILITY_2 = new KeyMapping("key.dcc.classability_2", GLFW.GLFW_KEY_X, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Classability2Message(0, 0));
				Classability2Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLASSABILITY_3 = new KeyMapping("key.dcc.classability_3", GLFW.GLFW_KEY_C, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Classability3Message(0, 0));
				Classability3Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLASSABILITYOPNGUI = new KeyMapping("key.dcc.classabilityopngui", GLFW.GLFW_KEY_O, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ClassabilityopnguiMessage(0, 0));
				ClassabilityopnguiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DODGE = new KeyMapping("key.dcc.dodge", GLFW.GLFW_KEY_SLASH, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new DodgeMessage(0, 0));
				DodgeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PALADIN_FLY = new KeyMapping("key.dcc.paladin_fly", GLFW.GLFW_KEY_B, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new PaladinFlyMessage(0, 0));
				PaladinFlyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				PALADIN_FLY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - PALADIN_FLY_LASTPRESS);
				PacketDistributor.sendToServer(new PaladinFlyMessage(1, dt));
				PaladinFlyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long PALADIN_FLY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(CLASSABILITY_1);
		event.register(CLASSABILITY_2);
		event.register(CLASSABILITY_3);
		event.register(CLASSABILITYOPNGUI);
		event.register(DODGE);
		event.register(PALADIN_FLY);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				CLASSABILITY_1.consumeClick();
				CLASSABILITY_2.consumeClick();
				CLASSABILITY_3.consumeClick();
				CLASSABILITYOPNGUI.consumeClick();
				DODGE.consumeClick();
				PALADIN_FLY.consumeClick();
			}
		}
	}
}