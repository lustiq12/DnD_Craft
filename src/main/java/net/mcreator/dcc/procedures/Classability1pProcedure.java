package net.mcreator.dcc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.dcc.world.inventory.KiMenu;
import net.mcreator.dcc.network.DccModVariables;
import net.mcreator.dcc.init.DccModEntities;
import net.mcreator.dcc.entity.ThornEntity;
import net.mcreator.dcc.DccMod;

import io.netty.buffer.Unpooled;

public class Classability1pProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(DccModVariables.PLAYER_VARIABLES).cooldown < 0.05) {
			if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Barbarian")) {
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 30;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 2000, 2, 2, 2, 0.6);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.wutrausch = true;
					_vars.syncPlayerVariables(entity);
				}
				DccMod.queueServerWork(200, () -> {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.wutrausch = false;
						_vars.syncPlayerVariables(entity);
					}
				});
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Bard")) {
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 20;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 2));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 1));
				if (entity.getData(DccModVariables.PLAYER_VARIABLES).PlayerLevel > 19) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 9));
				}
				DccMod.queueServerWork(100, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.NEUTRAL, 100, 1, false);
						}
					}
				});
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Magician")) {
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 30;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 7, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 7, 1, false);
					}
				}
				DccMod.queueServerWork(5, () -> {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DccMod.queueServerWork(10, () -> {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DccMod.queueServerWork(15, () -> {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DccMod.queueServerWork(20, () -> {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DccMod.queueServerWork(25, () -> {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
				DccMod.queueServerWork(30, () -> {
					{
						DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
						_vars.Mana = entity.getData(DccModVariables.PLAYER_VARIABLES).Mana + 10;
						_vars.syncPlayerVariables(entity);
					}
				});
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Druid")) {
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 30;
					_vars.syncPlayerVariables(entity);
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = initArrowProjectile(new ThornEntity(DccModEntities.THORN.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 2, (byte) 1)), entity, 5, true, false, true,
								AbstractArrow.Pickup.DISALLOWED);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.azalea.break")), SoundSource.NEUTRAL, 7, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.azalea.break")), SoundSource.NEUTRAL, 7, 1, false);
					}
				}
			} else if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Paladin")) {
				{
					DccModVariables.PlayerVariables _vars = entity.getData(DccModVariables.PLAYER_VARIABLES);
					_vars.cooldown = 30;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.ARMOR))
					_livingEntity22.getAttribute(Attributes.ARMOR)
							.setBaseValue(((entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity21.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 8));
				DccMod.queueServerWork(200, () -> {
					if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.ARMOR))
						_livingEntity24.getAttribute(Attributes.ARMOR)
								.setBaseValue(((entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity23.getAttribute(Attributes.ARMOR).getBaseValue() : 0) - 8));
				});
			}
		}
		if ((entity.getData(DccModVariables.PLAYER_VARIABLES).Class_Variable).equals("Monk")) {
			if (entity.getData(DccModVariables.PLAYER_VARIABLES).Ki > 0) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Ki");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new KiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static ItemStack createArrowWeaponItemStack(Level level, int knockback, byte piercing) {
		ItemStack weapon = new ItemStack(Items.ARROW);
		if (knockback > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), knockback);
		if (piercing > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), piercing);
		return weapon;
	}
}