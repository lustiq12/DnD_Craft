
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndcraft.entity.WargEntity;
import net.mcreator.dndcraft.entity.OwlbearEntity;
import net.mcreator.dndcraft.entity.OrkEntity;
import net.mcreator.dndcraft.entity.Ogre2Entity;
import net.mcreator.dndcraft.entity.OcherjellyEntity;
import net.mcreator.dndcraft.entity.Ocherjally2Entity;
import net.mcreator.dndcraft.entity.MimicSludgeEntity;
import net.mcreator.dndcraft.entity.MimicEntity;
import net.mcreator.dndcraft.entity.IronGoblinEntity;
import net.mcreator.dndcraft.entity.InvisibleStalkerEntity;
import net.mcreator.dndcraft.entity.HarpyEntity;
import net.mcreator.dndcraft.entity.GoblinEntity;
import net.mcreator.dndcraft.entity.GoblinChiefEntity;
import net.mcreator.dndcraft.entity.GhoulEntity;
import net.mcreator.dndcraft.entity.Fireball2Entity;
import net.mcreator.dndcraft.entity.CookEntity;
import net.mcreator.dndcraft.entity.ColdrayspellEntity;
import net.mcreator.dndcraft.entity.BowblinEntityProjectile;
import net.mcreator.dndcraft.entity.BowblinEntity;
import net.mcreator.dndcraft.entity.BasiliskEntity;
import net.mcreator.dndcraft.entity.ArrowEntity;
import net.mcreator.dndcraft.DndCraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DndCraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DndCraftMod.MODID);
	public static final RegistryObject<EntityType<Ogre2Entity>> OGRE = register("ogre",
			EntityType.Builder.<Ogre2Entity>of(Ogre2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Ogre2Entity::new)

					.sized(2f, 2.5f));
	public static final RegistryObject<EntityType<OrkEntity>> ORK = register("ork",
			EntityType.Builder.<OrkEntity>of(OrkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OrkEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HarpyEntity>> HARPY = register("harpy",
			EntityType.Builder.<HarpyEntity>of(HarpyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(HarpyEntity::new)

					.sized(1.4f, 2f));
	public static final RegistryObject<EntityType<OwlbearEntity>> OWLBEAR = register("owlbear",
			EntityType.Builder.<OwlbearEntity>of(OwlbearEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(OwlbearEntity::new)

					.sized(1.9f, 1.3f));
	public static final RegistryObject<EntityType<MimicEntity>> MIMIC = register("mimic",
			EntityType.Builder.<MimicEntity>of(MimicEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MimicEntity::new)

					.sized(0.9f, 0.9f));
	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN = register("goblin",
			EntityType.Builder.<GoblinEntity>of(GoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinEntity::new)

					.sized(0.7f, 1.4f));
	public static final RegistryObject<EntityType<IronGoblinEntity>> IRON_GOBLIN = register("iron_goblin",
			EntityType.Builder.<IronGoblinEntity>of(IronGoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IronGoblinEntity::new)

					.sized(0.7f, 1.4f));
	public static final RegistryObject<EntityType<GoblinChiefEntity>> GOBLIN_CHIEF = register("goblin_chief",
			EntityType.Builder.<GoblinChiefEntity>of(GoblinChiefEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinChiefEntity::new)

					.sized(0.7f, 1.4f));
	public static final RegistryObject<EntityType<Fireball2Entity>> FIREBALL_2 = register("fireball_2",
			EntityType.Builder.<Fireball2Entity>of(Fireball2Entity::new, MobCategory.MISC).setCustomClientFactory(Fireball2Entity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ColdrayspellEntity>> COLDRAYSPELL = register("coldrayspell",
			EntityType.Builder.<ColdrayspellEntity>of(ColdrayspellEntity::new, MobCategory.MISC).setCustomClientFactory(ColdrayspellEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OcherjellyEntity>> OCHERJELLY = register("ocherjelly",
			EntityType.Builder.<OcherjellyEntity>of(OcherjellyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OcherjellyEntity::new)

					.sized(1.2f, 1f));
	public static final RegistryObject<EntityType<Ocherjally2Entity>> OCHERJALLY_2 = register("ocherjally_2",
			EntityType.Builder.<Ocherjally2Entity>of(Ocherjally2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Ocherjally2Entity::new)

					.sized(1.2f, 1f));
	public static final RegistryObject<EntityType<MimicSludgeEntity>> MIMIC_SLUDGE = register("mimic_sludge",
			EntityType.Builder.<MimicSludgeEntity>of(MimicSludgeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(MimicSludgeEntity::new)

					.sized(1.1f, 0.9f));
	public static final RegistryObject<EntityType<InvisibleStalkerEntity>> INVISIBLE_STALKER = register("invisible_stalker",
			EntityType.Builder.<InvisibleStalkerEntity>of(InvisibleStalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(InvisibleStalkerEntity::new)

					.sized(1f, 1.6f));
	public static final RegistryObject<EntityType<BasiliskEntity>> BASILISK = register("basilisk",
			EntityType.Builder.<BasiliskEntity>of(BasiliskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(BasiliskEntity::new)

					.sized(3f, 1.7f));
	public static final RegistryObject<EntityType<WargEntity>> WARG = register("warg",
			EntityType.Builder.<WargEntity>of(WargEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(512).setUpdateInterval(3).setCustomClientFactory(WargEntity::new)

					.sized(1.1f, 0.9f));
	public static final RegistryObject<EntityType<BowblinEntity>> BOWBLIN = register("bowblin",
			EntityType.Builder.<BowblinEntity>of(BowblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BowblinEntity::new)

					.sized(0.7f, 1.4f));
	public static final RegistryObject<EntityType<BowblinEntityProjectile>> BOWBLIN_PROJECTILE = register("projectile_bowblin", EntityType.Builder.<BowblinEntityProjectile>of(BowblinEntityProjectile::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(BowblinEntityProjectile::new).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ArrowEntity>> ARROW = register("arrow",
			EntityType.Builder.<ArrowEntity>of(ArrowEntity::new, MobCategory.MISC).setCustomClientFactory(ArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.3f, 0.5f));
	public static final RegistryObject<EntityType<CookEntity>> COOK = register("cook",
			EntityType.Builder.<CookEntity>of(CookEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CookEntity::new)

					.sized(0.9f, 1.5f));
	public static final RegistryObject<EntityType<GhoulEntity>> GHOUL = register("ghoul",
			EntityType.Builder.<GhoulEntity>of(GhoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GhoulEntity::new)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			Ogre2Entity.init();
			OrkEntity.init();
			HarpyEntity.init();
			OwlbearEntity.init();
			MimicEntity.init();
			GoblinEntity.init();
			IronGoblinEntity.init();
			GoblinChiefEntity.init();
			OcherjellyEntity.init();
			Ocherjally2Entity.init();
			MimicSludgeEntity.init();
			InvisibleStalkerEntity.init();
			BasiliskEntity.init();
			WargEntity.init();
			BowblinEntity.init();
			CookEntity.init();
			GhoulEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(OGRE.get(), Ogre2Entity.createAttributes().build());
		event.put(ORK.get(), OrkEntity.createAttributes().build());
		event.put(HARPY.get(), HarpyEntity.createAttributes().build());
		event.put(OWLBEAR.get(), OwlbearEntity.createAttributes().build());
		event.put(MIMIC.get(), MimicEntity.createAttributes().build());
		event.put(GOBLIN.get(), GoblinEntity.createAttributes().build());
		event.put(IRON_GOBLIN.get(), IronGoblinEntity.createAttributes().build());
		event.put(GOBLIN_CHIEF.get(), GoblinChiefEntity.createAttributes().build());
		event.put(OCHERJELLY.get(), OcherjellyEntity.createAttributes().build());
		event.put(OCHERJALLY_2.get(), Ocherjally2Entity.createAttributes().build());
		event.put(MIMIC_SLUDGE.get(), MimicSludgeEntity.createAttributes().build());
		event.put(INVISIBLE_STALKER.get(), InvisibleStalkerEntity.createAttributes().build());
		event.put(BASILISK.get(), BasiliskEntity.createAttributes().build());
		event.put(WARG.get(), WargEntity.createAttributes().build());
		event.put(BOWBLIN.get(), BowblinEntity.createAttributes().build());
		event.put(COOK.get(), CookEntity.createAttributes().build());
		event.put(GHOUL.get(), GhoulEntity.createAttributes().build());
	}
}
