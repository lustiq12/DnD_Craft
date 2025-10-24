package net.mcreator.dcc.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.dcc.world.inventory.MagicChooseMenu;
import net.mcreator.dcc.network.MagicChooseButtonMessage;
import net.mcreator.dcc.init.DccModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class MagicChooseScreen extends AbstractContainerScreen<MagicChooseMenu> implements DccModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_fire_arrow;
	Button button_cold_ray;
	Button button_thunderwave;
	Button button_fake_life;
	Button button_invisibility;
	Button button_night_vision;
	Button button_fireball;
	Button button_snowstorm;
	Button button_fire_wall;
	Button button_strong_invisibility;

	public MagicChooseScreen(MagicChooseMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 416;
		this.imageHeight = 225;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("dcc:textures/screens/magic_choose.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_spell_chooser"), 8, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_0"), 9, 27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_01"), 9, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_5"), 9, 81, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_51"), 9, 108, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_10"), 9, 135, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_101"), 9, 162, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_40"), 9, 189, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_401"), 144, 27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_80"), 144, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.magic_choose.label_level_45"), 144, 81, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_fire_arrow = Button.builder(Component.translatable("gui.dcc.magic_choose.button_fire_arrow"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(0, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 27, 77, 20).build();
		this.addRenderableWidget(button_fire_arrow);
		button_cold_ray = Button.builder(Component.translatable("gui.dcc.magic_choose.button_cold_ray"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(1, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 54, 66, 20).build();
		this.addRenderableWidget(button_cold_ray);
		button_thunderwave = Button.builder(Component.translatable("gui.dcc.magic_choose.button_thunderwave"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(2, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 108, 82, 20).build();
		this.addRenderableWidget(button_thunderwave);
		button_fake_life = Button.builder(Component.translatable("gui.dcc.magic_choose.button_fake_life"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(3, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 81, 72, 20).build();
		this.addRenderableWidget(button_fake_life);
		button_invisibility = Button.builder(Component.translatable("gui.dcc.magic_choose.button_invisibility"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(4, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 135, 88, 20).build();
		this.addRenderableWidget(button_invisibility);
		button_night_vision = Button.builder(Component.translatable("gui.dcc.magic_choose.button_night_vision"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(5, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 162, 87, 20).build();
		this.addRenderableWidget(button_night_vision);
		button_fireball = Button.builder(Component.translatable("gui.dcc.magic_choose.button_fireball"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(6, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 189, 67, 20).build();
		this.addRenderableWidget(button_fireball);
		button_snowstorm = Button.builder(Component.translatable("gui.dcc.magic_choose.button_snowstorm"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(7, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 189, this.topPos + 27, 72, 20).build();
		this.addRenderableWidget(button_snowstorm);
		button_fire_wall = Button.builder(Component.translatable("gui.dcc.magic_choose.button_fire_wall"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(8, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 189, this.topPos + 81, 72, 20).build();
		this.addRenderableWidget(button_fire_wall);
		button_strong_invisibility = Button.builder(Component.translatable("gui.dcc.magic_choose.button_strong_invisibility"), e -> {
			int x = MagicChooseScreen.this.x;
			int y = MagicChooseScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MagicChooseButtonMessage(9, x, y, z));
				MagicChooseButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 189, this.topPos + 54, 124, 20).build();
		this.addRenderableWidget(button_strong_invisibility);
	}
}