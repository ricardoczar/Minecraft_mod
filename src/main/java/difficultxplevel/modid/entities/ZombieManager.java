package difficultxplevel.modid.entities;

import difficultxplevel.modid.util.EnchantmentUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;

import java.util.function.BiConsumer;

public class ZombieManager {
    private static void tryApplyEnchant(ServerWorld world, ItemStack item, BiConsumer<ServerWorld, ItemStack> enchantMethod, double chance) {
        if (Math.random() < chance) {
            enchantMethod.accept(world, item);
        }
    }

    public static void tryEquipZombie(ZombieEntity zombie, ServerWorld world) {

        ItemStack EnchantedIronSword = new ItemStack(Items.IRON_SWORD);

        ItemStack EnchantedDiamondHelmet = new ItemStack(Items.DIAMOND_HELMET);
        ItemStack EnchantedDiamondChest = new ItemStack(Items.DIAMOND_CHESTPLATE);
        ItemStack EnchantedDiamondLegging = new ItemStack(Items.DIAMOND_LEGGINGS);
        ItemStack EnchantedDiamondBoots = new ItemStack(Items.DIAMOND_BOOTS);
        ItemStack EnchantedDiamondSword = new ItemStack(Items.DIAMOND_SWORD);

        ItemStack EnchantedNetheriteSword = new ItemStack(Items.NETHERITE_SWORD);
        ItemStack EnchantedNetheriteHelmet = new ItemStack(Items.NETHERITE_HELMET);
        ItemStack EnchantedNetheriteChest = new ItemStack(Items.NETHERITE_CHESTPLATE);
        ItemStack EnchantedNetheriteLegging = new ItemStack(Items.NETHERITE_LEGGINGS);
        ItemStack EnchantedNetheriteBoots = new ItemStack(Items.NETHERITE_BOOTS);



            //NETHERITE WEAPONS/ARMOR
        tryApplyEnchant(world, EnchantedNetheriteSword, EnchantmentUtils::applyFireAspect, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteSword, EnchantmentUtils::applyUnbreaking, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteSword, EnchantmentUtils::applyKnockback, 0.25);

        tryApplyEnchant(world, EnchantedNetheriteHelmet, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteChest, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteChest, EnchantmentUtils::applyThorns, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteLegging, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteBoots, EnchantmentUtils::applyProtection, 0.25);

        for (PlayerEntity player : world.getPlayers()) {
            long time = world.getTimeOfDay() % 24000;
            int xp = player.experienceLevel;

            if (xp >= 60) {
                if (time >= 13000 && time < 24000) {
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*60, 2));
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60, 2));
                } else {
                    zombie.removeStatusEffect(StatusEffects.STRENGTH);
                    zombie.removeStatusEffect(StatusEffects.RESISTANCE);

                }
                if (Math.random() <0.08){
                    equipWith(zombie, EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
                }else if(Math.random() <0.05){
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedNetheriteSword);
                }
                else if (Math.random() < 0.01){
                    equipWith(zombie, EquipmentSlot.HEAD, EnchantedNetheriteHelmet);
                    equipWith(zombie, EquipmentSlot.CHEST, EnchantedNetheriteChest);
                    equipWith(zombie, EquipmentSlot.LEGS, EnchantedNetheriteLegging);
                    equipWith(zombie, EquipmentSlot.FEET, EnchantedNetheriteBoots);
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedNetheriteSword);
                }

            }
            else if (xp >= 30) {
                if (time >= 13000 && time < 24000) {
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*60, 1));
                } else {
                    zombie.removeStatusEffect(StatusEffects.STRENGTH);
                }
                if (Math.random() < 0.1) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
                } else if (Math.random() < 0.05) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedDiamondSword);
                } else if (Math.random() < 0.01) {
                    equipWith(zombie, EquipmentSlot.HEAD, EnchantedDiamondHelmet);
                    equipWith(zombie, EquipmentSlot.CHEST, EnchantedDiamondChest);
                    equipWith(zombie, EquipmentSlot.LEGS, EnchantedDiamondLegging);
                    equipWith(zombie, EquipmentSlot.FEET, EnchantedDiamondBoots);
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedDiamondSword);
                }

            }
            else if (xp >= 20) {
                if (time >= 13000 && time < 24000) {
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*60, 1));
                } else {
                    zombie.removeStatusEffect(StatusEffects.STRENGTH);
                }

                if (Math.random() < 0.1) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
                } else if (Math.random() < 0.05) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedIronSword);
                } else if (Math.random() < 0.01) {
                    equipWith(zombie, EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
                    equipWith(zombie, EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
                    equipWith(zombie, EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
                    equipWith(zombie, EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedIronSword);
                }

            }

            else if (xp >= 10) {
                if (time >= 13000 && time < 24000) {
                } else {
                }

            }

        }
    }

    private static void equipWith(ZombieEntity zombie, EquipmentSlot slot, ItemStack item) {
            zombie.equipStack(slot, item);
            zombie.setEquipmentDropChance(slot, 0.01f);

    }
}