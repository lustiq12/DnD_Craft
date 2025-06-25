package net.mcreator.dndcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.dndcraft.world.inventory.KiMenu;
import net.mcreator.dndcraft.network.KiButtonMessage;
import net.mcreator.dndcraft.DndCraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class KiScreen extends AbstractContainerScreen<KiMenu> {
	private final static HashMap<String, Object> guistate = KiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_strong_fist;
	Button button_better_defense;

	public KiScreen(KiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 189;
	}

	private static final ResourceLocation texture = new ResourceLocation("dnd_craft:textures/screens/ki.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.ki.label_ki_abilitys"), 52, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_strong_fist = Button.builder(Component.translatable("gui.dnd_craft.ki.button_strong_fist"), e -> {
			if (true) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new KiButtonMessage(0, x, y, z));
				KiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 27, 82, 20).build();
		guistate.put("button:button_strong_fist", button_strong_fist);
		this.addRenderableWidget(button_strong_fist);
		button_better_defense = Button.builder(Component.translatable("gui.dnd_craft.ki.button_better_defense"), e -> {
			if (true) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new KiButtonMessage(1, x, y, z));
				KiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 54, 98, 20).build();
		guistate.put("button:button_better_defense", button_better_defense);
		this.addRenderableWidget(button_better_defense);
	}
}
