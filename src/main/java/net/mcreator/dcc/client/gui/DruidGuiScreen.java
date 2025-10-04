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

import net.mcreator.dcc.world.inventory.DruidGuiMenu;
import net.mcreator.dcc.procedures.DisplaybuttonProcedure;
import net.mcreator.dcc.network.DruidGuiButtonMessage;
import net.mcreator.dcc.init.DccModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class DruidGuiScreen extends AbstractContainerScreen<DruidGuiMenu> implements DccModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_choose;
	Button button_exit;

	public DruidGuiScreen(DruidGuiMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("dcc:textures/screens/druid_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 27 && mouseY < topPos + 51) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.druid_gui.tooltip_shoot_a_thorn_that_deals_75_hea"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 54 && mouseY < topPos + 78) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.druid_gui.tooltip_let_roots_come_out_of_the_earth"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 81 && mouseY < topPos + 105) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.druid_gui.tooltip_when_you_are_near_plants_you_ge"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 135 && mouseY < topPos + 159) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.druid_gui.tooltip_you_get_a_higher_regeneration_le"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 34 && mouseX < leftPos + 58 && mouseY > topPos + 108 && mouseY < topPos + 132) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.druid_gui.tooltip_summon_5_strong_wolves_that_supp"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_0_level"), 34, 27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_rage"), 34, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_10_level"), 34, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_ghost_axe"), 34, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_40_level"), 34, 81, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_survival_instinct"), 34, 90, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_level_60"), 34, 108, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_invincibility"), 34, 117, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_level_80_passive"), 34, 135, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_barbarian_strenght"), 34, 144, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.druid_gui.label_barbarian"), 79, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_choose = Button.builder(Component.translatable("gui.dcc.druid_gui.button_choose"), e -> {
			if (DisplaybuttonProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new DruidGuiButtonMessage(0, x, y, z));
				DruidGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 162, 56, 20).build();
		this.addRenderableWidget(button_choose);
		button_exit = Button.builder(Component.translatable("gui.dcc.druid_gui.button_exit"), e -> {
			if (DisplaybuttonProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new DruidGuiButtonMessage(1, x, y, z));
				DruidGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
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