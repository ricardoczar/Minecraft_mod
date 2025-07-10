package difficultxplevel.modid.entities;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class EndermanManager {

    public static void EndermanStatus(EndermanEntity enderman, ServerWorld world) {

        for (PlayerEntity player : world.getPlayers()) {
            enderman.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*60,2));

        }

    }

}
