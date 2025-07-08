package difficultxplevel.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DifficultXpLevel implements ModInitializer {
	public static final String MOD_ID = "difficult-xp-level";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (entity instanceof ZombieEntity zombie) {
				ZombieEquipmentManager.tryEquipZombie(zombie, serverWorld);
			}
			Registry<Enchantment> enchantmentRegistry =
					serverWorld.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
			ItemStack sword = new ItemStack(Items.DIAMOND_SWORD);
			RegistryEntry<Enchantment> sharpnessEntry = enchantmentRegistry.getOrThrow(Enchantments.SHARPNESS);
			sword.addEnchantment(sharpnessEntry, 3);





			if (entity instanceof SkeletonEntity skeleton) {
				SkeletonEquipmentManager.tryEquipSkeleton(skeleton, serverWorld);
			}


		});
		}

	}