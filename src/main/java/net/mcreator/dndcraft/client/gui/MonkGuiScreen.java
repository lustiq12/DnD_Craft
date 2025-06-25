package net.mcreator.dndcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.dndcraft.world.inventory.MonkGuiMenu;
import net.mcreator.dndcraft.procedures.DisplaybuttonProcedure;
import net.mcreator.dndcraft.network.MonkGuiButtonMessage;
import net.mcreator.dndcraft.DndCraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MonkGuiScreen extends AbstractContainerScreen<MonkGuiMenu> {
	private final static HashMap<String, Object> guistate = MonkGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_choose;
	Button button_exit;

	public MonkGuiScreen(MonkGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 189;
	}

	private static final ResourceLocation texture = new ResourceLocation("dnd_craft:textures/screens/monk_gui.png");

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

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 27, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 54, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 81, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 108, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("dnd_craft:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 135, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_0_level"), 34, 27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_rage"), 34, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_10_level"), 34, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_ghost_axe"), 34, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_40_level"), 34, 81, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_survival_instinct"), 34, 90, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_level_60"), 34, 108, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_invincibility"), 34, 117, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_level_80_passive"), 34, 135, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_barbarian_strenght"), 34, 144, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dnd_craft.monk_gui.label_barbarian"), 79, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_choose = Button.builder(Component.translatable("gui.dnd_craft.monk_gui.button_choose"), e -> {
			if (DisplaybuttonProcedure.execute(entity)) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new MonkGuiButtonMessage(0, x, y, z));
				MonkGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 162, 56, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = DisplaybuttonProcedure.execute(entity);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_choose", button_choose);
		this.addRenderableWidget(button_choose);
		button_exit = Button.builder(Component.translatable("gui.dnd_craft.monk_gui.button_exit"), e -> {
			if (DisplaybuttonProcedure.execute(entity)) {
				DndCraftMod.PACKET_HANDLER.sendToServer(new MonkGuiButtonMessage(1, x, y, z));
				MonkGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 115, this.topPos + 162, 46, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = DisplaybuttonProcedure.execute(entity);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_exit", button_exit);
		this.addRenderableWidget(button_exit);
	}
}
