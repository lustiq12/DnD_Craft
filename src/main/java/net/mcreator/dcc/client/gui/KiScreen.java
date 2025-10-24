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

import net.mcreator.dcc.world.inventory.KiMenu;
import net.mcreator.dcc.network.KiButtonMessage;
import net.mcreator.dcc.init.DccModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class KiScreen extends AbstractContainerScreen<KiMenu> implements DccModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
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

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("dcc:textures/screens/ki.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 7 && mouseX < leftPos + 31 && mouseY > topPos + 27 && mouseY < topPos + 51) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.ki.tooltip_get_higher_attack_speed_and_spee"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 7 && mouseX < leftPos + 31 && mouseY > topPos + 54 && mouseY < topPos + 78) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.dcc.ki.tooltip_get_max_armor_and_speed_for_5_se"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.dcc.ki.label_ki_abilitys"), 52, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_strong_fist = Button.builder(Component.translatable("gui.dcc.ki.button_strong_fist"), e -> {
			int x = KiScreen.this.x;
			int y = KiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new KiButtonMessage(0, x, y, z));
				KiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 27, 82, 20).build();
		this.addRenderableWidget(button_strong_fist);
		button_better_defense = Button.builder(Component.translatable("gui.dcc.ki.button_better_defense"), e -> {
			int x = KiScreen.this.x;
			int y = KiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new KiButtonMessage(1, x, y, z));
				KiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 54, 98, 20).build();
		this.addRenderableWidget(button_better_defense);
	}
}