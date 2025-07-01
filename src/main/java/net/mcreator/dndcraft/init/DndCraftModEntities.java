
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.dndcraft.entity.WargEntity;
import net.mcreator.dndcraft.entity.VINESEntity;
import net.mcreator.dndcraft.entity.OwlbearEntity;
import net.mcreator.dndcraft.entity.OrkEntity;
import net.mcreator.dndcraft.entity.Ogre2Entity;
import net.mcreator.dndcraft.entity.OcherjellyEntity;
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
import net.mcreator.dndcraft.entity.BowblinEntity;
import net.mcreator.dndcraft.entity.BasiliskEntity;
import net.mcreator.dndcraft.entity.ArrowEntity;
import net.mcreator.dndcraft.DndCraftMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DndCraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, DndCraftMod.MODID);
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
	public static final DeferredHolder<EntityType<?>, EntityType<ArrowEntity>> ARROW = register("arrow",
			EntityType.Builder.<ArrowEntity>of(ArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.3f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CookEntity>> COOK = register("cook",
			EntityType.Builder.<CookEntity>of(CookEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.9f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhoulEntity>> GHOUL = register("ghoul",
			EntityType.Builder.<GhoulEntity>of(GhoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<VINESEntity>> VINES = register("vines",
			EntityType.Builder.<VINESEntity>of(VINESEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerEntity(Capabilities.ItemHandler.ENTITY, COOK.get(), (living, context) -> living.getInventory());
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
	}
}
