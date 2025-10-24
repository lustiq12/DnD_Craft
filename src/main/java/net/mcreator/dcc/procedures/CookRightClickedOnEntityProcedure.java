package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.dcc.init.DccModItems;
import net.mcreator.dcc.entity.CookEntity;

public class CookRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double ChooseQuest = 0;
		if ((entity instanceof CookEntity _datEntS ? _datEntS.getEntityData().get(CookEntity.DATA_CurrentQuest) : "").equals("0")) {
			ChooseQuest = Mth.nextInt(RandomSource.create(), 1, 3);
			if (ChooseQuest == 1) {
				if (entity instanceof CookEntity _datEntSetS)
					_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "1");
			} else if (ChooseQuest == 2) {
				if (entity instanceof CookEntity _datEntSetS)
					_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "2");
			} else if (ChooseQuest == 3) {
				if (entity instanceof CookEntity _datEntSetS)
					_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "3");
			} else if (ChooseQuest == 4) {
				if (entity instanceof CookEntity _datEntSetS)
					_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "4");
			} else if (ChooseQuest == 5) {
				if (entity instanceof CookEntity _datEntSetS)
					_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "5");
			}
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("[NPC | COOK]: Oh... I think i have something to do for you."), false);
		} else {
			if ((entity instanceof CookEntity _datEntS ? _datEntS.getEntityData().get(CookEntity.DATA_CurrentQuest) : "").equals("1")) {
				if (!(entity instanceof CookEntity _datEntL9 && _datEntL9.getEntityData().get(CookEntity.DATA_FirstTimeAsking))) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Right, Could i get like 15 raw beef?"), false);
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, true);
				} else if (Items.BEEF == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
						&& 15 <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount()) {
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(15);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Oh, thank you, i also got something for you."), false);
					for (int index0 = 0; index0 < 4; index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.GOLD_COIN.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					for (int index1 = 0; index1 < 2; index1++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.COOKED_ORK_BEEF.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (entity instanceof CookEntity _datEntSetS)
						_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "0");
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, false);
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Thats not what i want... I asked for 15 raw beef."), false);
				}
			} else if ((entity instanceof CookEntity _datEntS ? _datEntS.getEntityData().get(CookEntity.DATA_CurrentQuest) : "").equals("2")) {
				if (!(entity instanceof CookEntity _datEntL25 && _datEntL25.getEntityData().get(CookEntity.DATA_FirstTimeAsking))) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Could you please bring me 5 owlbear meat?"), false);
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, true);
				} else if (DccModItems.RAW_OWLBEAR_MEAT.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
						&& 5 <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount()) {
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(5);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Oh, thank you, i also got something for you."), false);
					for (int index2 = 0; index2 < 6; index2++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.GOLD_COIN.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					for (int index3 = 0; index3 < 12; index3++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.OWLBEAR_MEAT_STRIPE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (entity instanceof CookEntity _datEntSetS)
						_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "0");
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, false);
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Thats not what i want... you dont know what i mean? T[NPC | COOK]: Thats not what i want... I asked for 5 owlbear meat."), false);
				}
			} else if ((entity instanceof CookEntity _datEntS ? _datEntS.getEntityData().get(CookEntity.DATA_CurrentQuest) : "").equals("3")) {
				if (!(entity instanceof CookEntity _datEntL41 && _datEntL41.getEntityData().get(CookEntity.DATA_FirstTimeAsking))) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: I really need 10 sugar right now, could you do that?"), false);
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, true);
				} else if (Items.SUGAR == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
						&& 10 <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount()) {
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(10);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Oh, thank you, i also got something for you."), false);
					for (int index4 = 0; index4 < 2; index4++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.GOLD_COIN.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					for (int index5 = 0; index5 < 1; index5++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.CAKE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (entity instanceof CookEntity _datEntSetS)
						_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "0");
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Thats not what i want... you dont know what i mean? T[NPC | COOK]: Thats not what i want... I asked for 10 sugar."), false);
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, false);
				}
			} else if ((entity instanceof CookEntity _datEntS ? _datEntS.getEntityData().get(CookEntity.DATA_CurrentQuest) : "").equals("4")) {
				if (!(entity instanceof CookEntity _datEntL57 && _datEntL57.getEntityData().get(CookEntity.DATA_FirstTimeAsking))) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: oh yes, theres something i need, could you bring me 6 raw ork beef?"), false);
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, true);
				} else if (DccModItems.RAW_ORK_BEEF.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
						&& 6 <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount()) {
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(6);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Oh, thank you, i also got something for you."), false);
					for (int index6 = 0; index6 < 5; index6++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.GOLD_COIN.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					for (int index7 = 0; index7 < 3; index7++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DccModItems.ORKSTEAAK.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (entity instanceof CookEntity _datEntSetS)
						_datEntSetS.getEntityData().set(CookEntity.DATA_CurrentQuest, "0");
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("[NPC | COOK]: Thats not what i want... you dont know what i mean? T[NPC | COOK]: Thats not what i want... I asked for 6 raw ork beef."), false);
					if (entity instanceof CookEntity _datEntSetL)
						_datEntSetL.getEntityData().set(CookEntity.DATA_FirstTimeAsking, false);
				}
			}
		}
	}
}