package net.mcreator.dndcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.dndcraft.network.DndCraftModVariables;
import net.mcreator.dndcraft.init.DndCraftModParticleTypes;
import net.mcreator.dndcraft.DndCraftMod;

public class MagicWandRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician")) {
			if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana > 19) {
					if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Spell).equals("fakelife")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (DndCraftModParticleTypes.SHIELD_PARTICLE.get()), x, y, z, 1000, 2, 2, 2, 1);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 3));
						{
							DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana - 20;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana > 29) {
					if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Spell).equals("invisibility")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 1000, 2, 2, 2, 1);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 300, 1));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2));
						{
							DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana - 30;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Spell).equals("nightvision")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 1000, 2, 2, 2, 1);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 1));
						if (!(world instanceof Level _lvl9 && _lvl9.isDay())) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 150, 1));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 500, 1));
						}
						{
							DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana - 30;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana > 49) {
					if ((entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Spell).equals("stronginvisibility")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 1000, 2, 2, 2, 1);
						if (entity instanceof Player _player) {
							_player.getAbilities().invulnerable = true;
							_player.onUpdateAbilities();
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 1));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2));
						{
							DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
							_vars.Dogde = true;
							_vars.syncPlayerVariables(entity);
						}
						DndCraftMod.queueServerWork(200, () -> {
							{
								DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
								_vars.Dogde = false;
								_vars.syncPlayerVariables(entity);
							}
						});
						DndCraftMod.queueServerWork(25, () -> {
							if (entity instanceof Player _player) {
								_player.getAbilities().invulnerable = false;
								_player.onUpdateAbilities();
							}
						});
						{
							DndCraftModVariables.PlayerVariables _vars = entity.getData(DndCraftModVariables.PLAYER_VARIABLES);
							_vars.Mana = entity.getData(DndCraftModVariables.PLAYER_VARIABLES).Mana - 50;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
		}
	}
}
