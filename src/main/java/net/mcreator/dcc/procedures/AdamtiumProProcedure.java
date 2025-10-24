package net.mcreator.dcc.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.dcc.init.DccModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AdamtiumProProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getEntity(), event.getCrafting());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == DccModItems.ADAMANTIUM_AX.get() || itemstack.getItem() == DccModItems.ADAMANTIUM_BATTLE_AXE.get() || itemstack.getItem() == DccModItems.ADAMANTIUM_CLAYMORE.get()
				|| itemstack.getItem() == DccModItems.ADAMANTIUM_DAGGER.get() || itemstack.getItem() == DccModItems.ADAMANTIUM_GLADIUS.get() || itemstack.getItem() == DccModItems.ADAMANTIUM_MACE.get()
				|| itemstack.getItem() == DccModItems.ADAMANTIUM_SCIMITAR.get() || itemstack.getItem() == DccModItems.ADAMANTIUM_SICKLE.get() || itemstack.getItem() == DccModItems.ADAMANTIUM_SPEAR.get()
				|| itemstack.getItem() == DccModItems.ADAMANTIUM_WAR_HAMMER.get() || itemstack.getItem() == DccModItems.LIGHT_ADAMANTIUM_HAMMER.get() || itemstack.getItem() == DccModItems.TWO_HANDED_ADAMANTIUM_AXE.get()
				|| itemstack.getItem() == DccModItems.TWO_HANDED_ADAMANTIUM_CLAYMORE.get() || itemstack.getItem() == DccModItems.TWO_HANDED_ADAMANTIUM_HAMMER.get()) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("dcc:adamantium"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}