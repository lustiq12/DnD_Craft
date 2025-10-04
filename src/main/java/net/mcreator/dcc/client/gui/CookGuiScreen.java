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

import net.mcreator.dcc.world.inventory.CookGuiMenu;
import net.mcreator.dcc.procedures.VeteranquestshowProcedure;
import net.mcreator.dcc.procedures.VeteranquestshowLootProcedure;
import net.mcreator.dcc.procedures.MonsterquestunlockProcedure;
import net.mcreator.dcc.procedures.MonsterquestshowProcedure;
import net.mcreator.dcc.procedures.IfnoQuestProcedure;
import net.mcreator.dcc.network.CookGuiButtonMessage;
import net.mcreator.dcc.init.DccModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CookGuiScreen extends AbstractContainerScreen<CookGuiMenu> implements DccModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_loot_quest;
	Button button_loot_quest1;
	Button button_loot_quest2;

	public CookGuiScreen(CookGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 200;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("dcc:textures/screens/cook_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.cook_gui.label_quests"), 7, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.cook_gui.label_eat_10_fish"), 16, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.cook_gui.label_ss4daily_eater"), 25, 24, -12829636, false);
		if (MonsterquestunlockProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.dcc.cook_gui.label_sscmonster_delight"), 25, 51, -12829636, false);
		if (MonsterquestunlockProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.dcc.cook_gui.label_eat_40_ork_beefs"), 16, 60, -12829636, false);
		if (VeteranquestshowProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.dcc.cook_gui.label_ssc"), 25, 78, -12829636, false);
		if (VeteranquestshowProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.dcc.cook_gui.label_craft_every_food_item_of_dnd"), 16, 87, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_loot_quest = Button.builder(Component.translatable("gui.dcc.cook_gui.button_loot_quest"), e -> {
			if (IfnoQuestProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new CookGuiButtonMessage(0, x, y, z));
				CookGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 142, this.topPos + 24, 77, 20).build();
		this.addRenderableWidget(button_loot_quest);
		button_loot_quest1 = Button.builder(Component.translatable("gui.dcc.cook_gui.button_loot_quest1"), e -> {
			if (MonsterquestshowProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new CookGuiButtonMessage(1, x, y, z));
				CookGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 142, this.topPos + 51, 77, 20).build();
		this.addRenderableWidget(button_loot_quest1);
		button_loot_quest2 = Button.builder(Component.translatable("gui.dcc.cook_gui.button_loot_quest2"), e -> {
			if (VeteranquestshowLootProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new CookGuiButtonMessage(2, x, y, z));
				CookGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 142, this.topPos + 78, 77, 20).build();
		this.addRenderableWidget(button_loot_quest2);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_loot_quest.visible = IfnoQuestProcedure.execute(entity);
		this.button_loot_quest1.visible = MonsterquestshowProcedure.execute(entity);
		this.button_loot_quest2.visible = VeteranquestshowLootProcedure.execute(entity);
	}
}