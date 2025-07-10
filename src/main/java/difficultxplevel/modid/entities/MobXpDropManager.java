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

            // Verifica se quem matou foi um jogador
            if (!(source.getAttacker() instanceof net.minecraft.entity.player.PlayerEntity player)) return;

            // Calcula porcentagem de XP bônus com base no nível do jogador
            int level = player.experienceLevel;
            int bonusPercent = (level / 10) * 5; // Ex: nível 30 → 15% extra

            // XP base pode ser estimado (opcional) ou fixo. Aqui usaremos 5 como exemplo base.
            int baseXp = 5; // ou qualquer valor médio que desejar como referência

            // Calcula XP extra com base nos efeitos e equipamentos do mob
            int xpBonusFlat = 0;

            for (StatusEffectInstance effect : living.getStatusEffects()) {
                xpBonusFlat += 1;
            }

            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (!living.getEquippedStack(slot).isEmpty()) {
                    xpBonusFlat += 2;
                }
            }

            // Aplica o bônus percentual baseado no nível do jogador
            int totalXp = baseXp + xpBonusFlat;
            int xpWithBonus = totalXp + (totalXp * bonusPercent / 100);

            if (xpWithBonus > 0) {
                ServerWorld world = (ServerWorld) living.getWorld();
                world.spawnEntity(new ExperienceOrbEntity(
                        world,
                        living.getX(), living.getY(), living.getZ(),
                        xpWithBonus
                ));
            }
        });
    }

}
