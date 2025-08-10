package net.mcreator.dcc.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;

import net.mcreator.dcc.init.DccModItems;

public class Poisoneddagger2LivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(DccModItems.POISONED_DAGGER.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 2));
		if (sourceentity instanceof Player _player)
			_player.getCooldowns().addCooldown(DccModItems.POISONED_DAGGER.get(), 500);
	}
}
