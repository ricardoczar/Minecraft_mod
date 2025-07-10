package difficultxplevel.modid;

import difficultxplevel.modid.entities.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DifficultXpLevel implements ModInitializer {
	public static final String MOD_ID = "difficult-xp-level";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		MobXpDropManager.register();

		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (entity instanceof ZombieEntity zombie) {
				ZombieManager.tryEquipZombie(zombie, serverWorld);
			}

			if (entity instanceof SkeletonEntity skeleton) {
				SkeletonManager.tryEquipSkeleton(skeleton, serverWorld);
			}
			if (entity instanceof EndermanEntity enderman){
				EndermanManager.EndermanStatus(enderman, serverWorld);
			}
			if (entity instanceof CreeperEntity creeper){

			}


		});
		}

	}