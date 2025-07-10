package difficultxplevel.modid.entities;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;

public class MobXpDropManager {

    public static void register() {
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            if (!(entity instanceof LivingEntity living)) return;
            if (living.getWorld().isClient()) return;

            int bonusXp = 0;

            // Adiciona XP baseado nos efeitos ativos
            for (StatusEffectInstance effect : living.getStatusEffects()) {
                if (effect.getEffectType() == StatusEffects.STRENGTH) {
                    bonusXp += 10;
                } else if (effect.getEffectType() == StatusEffects.RESISTANCE) {
                    bonusXp += 10;
                } else if (effect.getEffectType() == StatusEffects.REGENERATION) {
                    bonusXp += 5;
                } else {
                    bonusXp += 1; // qualquer outro efeito dá 1 de XP extra
                }
            }

            // XP adicional por equipamentos
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (!living.getEquippedStack(slot).isEmpty()) {
                    bonusXp += 2;
                }
            }

            // Aplica se houver bônus
            if (bonusXp > 0) {
                ServerWorld world = (ServerWorld) living.getWorld();
                world.spawnEntity(new ExperienceOrbEntity(
                        world,
                        living.getX(), living.getY(), living.getZ(),
                        bonusXp
                ));
            }
        });
    }
}
