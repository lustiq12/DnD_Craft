/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dcc.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.dcc.entity.WargEntity;
import net.mcreator.dcc.entity.VINESEntity;
import net.mcreator.dcc.entity.ThornEntity;
import net.mcreator.dcc.entity.TentaclesEntity;
import net.mcreator.dcc.entity.SmallOcherjellyEntity;
import net.mcreator.dcc.entity.SlotMachineEntityEntity;
import net.mcreator.dcc.entity.RedCapEntity;
import net.mcreator.dcc.entity.OwlbearEntity;
import net.mcreator.dcc.entity.OrkEntity;
import net.mcreator.dcc.entity.Ogre2Entity;
import net.mcreator.dcc.entity.OcherjellyEntity;
import net.mcreator.dcc.entity.MimicSludgeEntity;
import net.mcreator.dcc.entity.MimicEntity;
import net.mcreator.dcc.entity.LivingSwordEntity;
import net.mcreator.dcc.entity.IronGoblinEntity;
import net.mcreator.dcc.entity.InvisibleStalkerEntity;
import net.mcreator.dcc.entity.HarpyEntity;
import net.mcreator.dcc.entity.GoblinEntity;
import net.mcreator.dcc.entity.GoblinChiefEntity;
import net.mcreator.dcc.entity.GhoulEntity;
import net.mcreator.dcc.entity.Fireball2Entity;
import net.mcreator.dcc.entity.CookEntity;
import net.mcreator.dcc.entity.ColdrayspellEntity;
import net.mcreator.dcc.entity.CarrionCrawlerPoisonEntity;
import net.mcreator.dcc.entity.CarrionCrawlerEntity;
import net.mcreator.dcc.entity.BullywugWarriorEntity;
import net.mcreator.dcc.entity.BullywugTadpoleEntity;
import net.mcreator.dcc.entity.BullywugEntity;
import net.mcreator.dcc.entity.BowblinEntity;
import net.mcreator.dcc.entity.BasiliskEntity;
import net.mcreator.dcc.DccMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DccModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, DccMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<Ogre2Entity>> OGRE = register("ogre",
			EntityType.Builder.<Ogre2Entity>of(Ogre2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(2f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<OrkEntity>> ORK = register("ork", EntityType.Builder.<OrkEntity>of(OrkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HarpyEntity>> HARPY = register("harpy",
			EntityType.Builder.<HarpyEntity>of(HarpyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3)

					.sized(1.4f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<OwlbearEntity>> OWLBEAR = register("owlbear",
			EntityType.Builder.<OwlbearEntity>of(OwlbearEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3)

					.sized(1.9f, 1.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<MimicEntity>> MIMIC = register("mimic",
			EntityType.Builder.<MimicEntity>of(MimicEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.9f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoblinEntity>> GOBLIN = register("goblin",
			EntityType.Builder.<GoblinEntity>of(GoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 1.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronGoblinEntity>> GOBLIN_IRON = register("goblin_iron",
			EntityType.Builder.<IronGoblinEntity>of(IronGoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 1.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoblinChiefEntity>> GOBLIN_CHIEF = register("goblin_chief",
			EntityType.Builder.<GoblinChiefEntity>of(GoblinChiefEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 1.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<Fireball2Entity>> FIREBALL_2 = register("fireball_2",
			EntityType.Builder.<Fireball2Entity>of(Fireball2Entity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ColdrayspellEntity>> COLDRAYSPELL = register("coldrayspell",
			EntityType.Builder.<ColdrayspellEntity>of(ColdrayspellEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<OcherjellyEntity>> OCHERJELLY = register("ocherjelly",
			EntityType.Builder.<OcherjellyEntity>of(OcherjellyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.2f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<MimicSludgeEntity>> MIMIC_SLUDGE = register("mimic_sludge",
			EntityType.Builder.<MimicSludgeEntity>of(MimicSludgeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3)

					.sized(1.1f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvisibleStalkerEntity>> INVISIBLE_STALKER = register("invisible_stalker",
			EntityType.Builder.<InvisibleStalkerEntity>of(InvisibleStalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3)

					.sized(1f, 1.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<BasiliskEntity>> BASILISK = register("basilisk",
			EntityType.Builder.<BasiliskEntity>of(BasiliskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3)

					.sized(3f, 1.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<WargEntity>> WARG = register("warg",
			EntityType.Builder.<WargEntity>of(WargEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(512).setUpdateInterval(3)

					.sized(1.1f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<BowblinEntity>> GOBLIN_BOW = register("goblin_bow",
			EntityType.Builder.<BowblinEntity>of(BowblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 1.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<CookEntity>> COOK = register("cook",
			EntityType.Builder.<CookEntity>of(CookEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.9f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhoulEntity>> GHOUL = register("ghoul",
			EntityType.Builder.<GhoulEntity>of(GhoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<VINESEntity>> VINES = register("vines",
			EntityType.Builder.<VINESEntity>of(VINESEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThornEntity>> THORN = register("thorn",
			EntityType.Builder.<ThornEntity>of(ThornEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LivingSwordEntity>> LIVING_SWORD = register("living_sword",
			EntityType.Builder.<LivingSwordEntity>of(LivingSwordEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SmallOcherjellyEntity>> SMALL_OCHERJELLY = register("small_ocherjelly",
			EntityType.Builder.<SmallOcherjellyEntity>of(SmallOcherjellyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.2f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<CarrionCrawlerEntity>> CARRION_CRAWLER = register("carrion_crawler",
			EntityType.Builder.<CarrionCrawlerEntity>of(CarrionCrawlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.5f, 1.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<CarrionCrawlerPoisonEntity>> CARRION_CRAWLER_POISON = register("carrion_crawler_poison",
			EntityType.Builder.<CarrionCrawlerPoisonEntity>of(CarrionCrawlerPoisonEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TentaclesEntity>> TENTACLES = register("tentacles",
			EntityType.Builder.<TentaclesEntity>of(TentaclesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BullywugEntity>> BULLYWUG = register("bullywug",
			EntityType.Builder.<BullywugEntity>of(BullywugEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BullywugTadpoleEntity>> BULLYWUG_TADPOLE = register("bullywug_tadpole",
			EntityType.Builder.<BullywugTadpoleEntity>of(BullywugTadpoleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<BullywugWarriorEntity>> BULLYWUG_WARRIOR = register("bullywug_warrior",
			EntityType.Builder.<BullywugWarriorEntity>of(BullywugWarriorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<RedCapEntity>> RED_CAP = register("red_cap",
			EntityType.Builder.<RedCapEntity>of(RedCapEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SlotMachineEntityEntity>> SLOT_MACHINE_ENTITY = register("slot_machine_entity",
			EntityType.Builder.<SlotMachineEntityEntity>of(SlotMachineEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.1f, 1.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		Ogre2Entity.init(event);
		OrkEntity.init(event);
		HarpyEntity.init(event);
		OwlbearEntity.init(event);
		MimicEntity.init(event);
		GoblinEntity.init(event);
		IronGoblinEntity.init(event);
		GoblinChiefEntity.init(event);
		OcherjellyEntity.init(event);
		MimicSludgeEntity.init(event);
		InvisibleStalkerEntity.init(event);
		BasiliskEntity.init(event);
		WargEntity.init(event);
		BowblinEntity.init(event);
		CookEntity.init(event);
		GhoulEntity.init(event);
		VINESEntity.init(event);
		LivingSwordEntity.init(event);
		SmallOcherjellyEntity.init(event);
		CarrionCrawlerEntity.init(event);
		TentaclesEntity.init(event);
		BullywugEntity.init(event);
		BullywugTadpoleEntity.init(event);
		BullywugWarriorEntity.init(event);
		RedCapEntity.init(event);
		SlotMachineEntityEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(OGRE.get(), Ogre2Entity.createAttributes().build());
		event.put(ORK.get(), OrkEntity.createAttributes().build());
		event.put(HARPY.get(), HarpyEntity.createAttributes().build());
		event.put(OWLBEAR.get(), OwlbearEntity.createAttributes().build());
		event.put(MIMIC.get(), MimicEntity.createAttributes().build());
		event.put(GOBLIN.get(), GoblinEntity.createAttributes().build());
		event.put(GOBLIN_IRON.get(), IronGoblinEntity.createAttributes().build());
		event.put(GOBLIN_CHIEF.get(), GoblinChiefEntity.createAttributes().build());
		event.put(OCHERJELLY.get(), OcherjellyEntity.createAttributes().build());
		event.put(MIMIC_SLUDGE.get(), MimicSludgeEntity.createAttributes().build());
		event.put(INVISIBLE_STALKER.get(), InvisibleStalkerEntity.createAttributes().build());
		event.put(BASILISK.get(), BasiliskEntity.createAttributes().build());
		event.put(WARG.get(), WargEntity.createAttributes().build());
		event.put(GOBLIN_BOW.get(), BowblinEntity.createAttributes().build());
		event.put(COOK.get(), CookEntity.createAttributes().build());
		event.put(GHOUL.get(), GhoulEntity.createAttributes().build());
		event.put(VINES.get(), VINESEntity.createAttributes().build());
		event.put(LIVING_SWORD.get(), LivingSwordEntity.createAttributes().build());
		event.put(SMALL_OCHERJELLY.get(), SmallOcherjellyEntity.createAttributes().build());
		event.put(CARRION_CRAWLER.get(), CarrionCrawlerEntity.createAttributes().build());
		event.put(TENTACLES.get(), TentaclesEntity.createAttributes().build());
		event.put(BULLYWUG.get(), BullywugEntity.createAttributes().build());
		event.put(BULLYWUG_TADPOLE.get(), BullywugTadpoleEntity.createAttributes().build());
		event.put(BULLYWUG_WARRIOR.get(), BullywugWarriorEntity.createAttributes().build());
		event.put(RED_CAP.get(), RedCapEntity.createAttributes().build());
		event.put(SLOT_MACHINE_ENTITY.get(), SlotMachineEntityEntity.createAttributes().build());
	}
}