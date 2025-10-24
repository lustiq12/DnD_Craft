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

import net.mcreator.dcc.world.inventory.BardeguiMenu;
import net.mcreator.dcc.procedures.DisplaybuttonProcedure;
import net.mcreator.dcc.network.BardeguiButtonMessage;
import net.mcreator.dcc.init.DccModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class BardeguiScreen extends AbstractContainerScreen<BardeguiMenu> implements DccModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_choose;
	Button button_exit;

	public BardeguiScreen(BardeguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 189;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("dcc:textures/screens/bardegui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 27 && mouseY < topPos + 51) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.bardegui.tooltip_get_regen_3_and_saturation_2_for"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 135 && mouseY < topPos + 159) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.bardegui.tooltip_get_regen_10_instead_of_3_for_5"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 54 && mouseY < topPos + 78) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.bardegui.tooltip_deal_4_hearts_damage_to_every_en"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 81 && mouseY < topPos + 105) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.bardegui.tooltip_permanent_speed_and_haste_1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 108 && mouseY < topPos + 132) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.bardegui.tooltip_remove_your_cooldown_for_10_seco"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 54, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 81, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 108, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("dcc:textures/screens/experience_bottle.png"), this.leftPos + 16, this.topPos + 135, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_0_level"), 34, 27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_rage"), 34, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_10_level"), 34, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_ghost_axe"), 34, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_40_level"), 34, 81, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_survival_instinct"), 34, 90, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_level_60"), 34, 108, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_invincibility"), 34, 117, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_level_80_passive"), 34, 135, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_barbarian_strenght"), 34, 144, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.bardegui.label_barbarian"), 79, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_choose = Button.builder(Component.translatable("gui.dcc.bardegui.button_choose"), e -> {
			int x = BardeguiScreen.this.x;
			int y = BardeguiScreen.this.y;
			if (DisplaybuttonProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new BardeguiButtonMessage(0, x, y, z));
				BardeguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 162, 56, 20).build();
		this.addRenderableWidget(button_choose);
		button_exit = Button.builder(Component.translatable("gui.dcc.bardegui.button_exit"), e -> {
			int x = BardeguiScreen.this.x;
			int y = BardeguiScreen.this.y;
			if (DisplaybuttonProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new BardeguiButtonMessage(1, x, y, z));
				BardeguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 115, this.topPos + 162, 46, 20).build();
		this.addRenderableWidget(button_exit);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_choose.visible = DisplaybuttonProcedure.execute(entity);
		this.button_exit.visible = DisplaybuttonProcedure.execute(entity);
	}
}