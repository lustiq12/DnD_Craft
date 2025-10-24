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

import net.mcreator.dcc.world.inventory.ClassesMenu;
import net.mcreator.dcc.network.ClassesButtonMessage;
import net.mcreator.dcc.init.DccModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ClassesScreen extends AbstractContainerScreen<ClassesMenu> implements DccModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_barbarian;
	Button button_bard;
	Button button_druid;
	Button button_magician;
	Button button_monk;
	Button button_paladin;

	public ClassesScreen(ClassesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 219;
		this.imageHeight = 189;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("dcc:textures/screens/classes.png");

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
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/barbaricon.png"), this.leftPos + 7, this.topPos + 9, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/christiano_ronaldo_horn.png"), this.leftPos + 7, this.topPos + 36, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/druidstaff2.png"), this.leftPos + 106, this.topPos + 36, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/zauberstab.png"), this.leftPos + 7, this.topPos + 63, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/bruh.png"), this.leftPos + 106, this.topPos + 9, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/paladin.png"), this.leftPos + 7, this.topPos + 90, 0, 0, 16, 16, 16, 16);
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
	}

	@Override
	public void init() {
		super.init();
		button_barbarian = Button.builder(Component.translatable("gui.dcc.classes.button_barbarian"), e -> {
			int x = ClassesScreen.this.x;
			int y = ClassesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ClassesButtonMessage(0, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 9, 72, 20).build();
		this.addRenderableWidget(button_barbarian);
		button_bard = Button.builder(Component.translatable("gui.dcc.classes.button_bard"), e -> {
			int x = ClassesScreen.this.x;
			int y = ClassesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ClassesButtonMessage(1, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 36, 46, 20).build();
		this.addRenderableWidget(button_bard);
		button_druid = Button.builder(Component.translatable("gui.dcc.classes.button_druid"), e -> {
			int x = ClassesScreen.this.x;
			int y = ClassesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ClassesButtonMessage(2, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 124, this.topPos + 36, 51, 20).build();
		this.addRenderableWidget(button_druid);
		button_magician = Button.builder(Component.translatable("gui.dcc.classes.button_magician"), e -> {
			int x = ClassesScreen.this.x;
			int y = ClassesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ClassesButtonMessage(3, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 63, 67, 20).build();
		this.addRenderableWidget(button_magician);
		button_monk = Button.builder(Component.translatable("gui.dcc.classes.button_monk"), e -> {
			int x = ClassesScreen.this.x;
			int y = ClassesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ClassesButtonMessage(4, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 124, this.topPos + 9, 46, 20).build();
		this.addRenderableWidget(button_monk);
		button_paladin = Button.builder(Component.translatable("gui.dcc.classes.button_paladin"), e -> {
			int x = ClassesScreen.this.x;
			int y = ClassesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ClassesButtonMessage(5, x, y, z));
				ClassesButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 90, 61, 20).build();
		this.addRenderableWidget(button_paladin);
	}
}