package net.mcreator.dndcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.dndcraft.world.inventory.ClassesMenu;
import net.mcreator.dndcraft.network.ClassesButtonMessage;
import net.mcreator.dndcraft.DndCraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ClassesScreen extends AbstractContainerScreen<ClassesMenu> {
	private final static HashMap<String, Object> guistate = ClassesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_barbarian;
	Button button_bard;
	Button button_druid;
	Button button_magician;
	Button button_monk;

	public ClassesScreen(ClassesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 189;
	}

	private static final ResourceLocation texture = new ResourceLocation("dnd_craft:textures/screens/classes.png");

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

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/barbaricon.png"), this.leftPos + 7, this.topPos + 9, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/christiano_ronaldo_horn.png"), this.leftPos + 7, this.topPos + 36, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/druidbruhscreen.png"), this.leftPos + 7, this.topPos + 63, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/zauberstab.png"), this.leftPos + 7, this.topPos + 90, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/bruh.png"), this.leftPos + 106, this.topPos + 9, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.classes.label_druid_and_magician_arent_workin"), 7, 117, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.classes.label_working_right_now_but_will_be_ad"), 7, 126, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.classes.label_added_soon"), 7, 135, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_barbarian = Button.builder(Component.translatable("gui.dnd_craft.classes.button_barbarian"), e -> {
			if (true) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new ClassesButtonMessage(0, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 9, 72, 20).build();
		guistate.put("button:button_barbarian", button_barbarian);
		this.addRenderableWidget(button_barbarian);
		button_bard = Button.builder(Component.translatable("gui.dnd_craft.classes.button_bard"), e -> {
			if (true) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new ClassesButtonMessage(1, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 36, 46, 20).build();
		guistate.put("button:button_bard", button_bard);
		this.addRenderableWidget(button_bard);
		button_druid = Button.builder(Component.translatable("gui.dnd_craft.classes.button_druid"), e -> {
		}).bounds(this.leftPos + 25, this.topPos + 63, 51, 20).build();
		guistate.put("button:button_druid", button_druid);
		this.addRenderableWidget(button_druid);
		button_magician = Button.builder(Component.translatable("gui.dnd_craft.classes.button_magician"), e -> {
			if (true) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new ClassesButtonMessage(3, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 90, 67, 20).build();
		guistate.put("button:button_magician", button_magician);
		this.addRenderableWidget(button_magician);
		button_monk = Button.builder(Component.translatable("gui.dnd_craft.classes.button_monk"), e -> {
			if (true) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new ClassesButtonMessage(4, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 124, this.topPos + 9, 46, 20).build();
		guistate.put("button:button_monk", button_monk);
		this.addRenderableWidget(button_monk);
	}
}
