package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dcc.network.DccModVariables;

public class MagicWandRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician")) {
			if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).Mana > 19) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("fakelife")) {
						FakelifeCastProcedure.execute(world, x, y, z, entity);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 20;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).Mana > 29) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("invisibility")) {
						InvisibilityCastProcedure.execute(world, x, y, z, entity);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 30;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("nightvision")) {
						NightvisionCastProcedure.execute(world, x, y, z, entity);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 30;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).Mana > 49) {
					if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Spell).equals("stronginvisibility")) {
						StronginvisibilityCastProcedure.execute(world, x, y, z, entity);
						{
							DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana - 50;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
		}
	}
}