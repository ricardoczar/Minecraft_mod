package difficultxplevel.modid.entities;

import difficultxplevel.modid.util.EnchantmentUtils;
import jdk.jshell.Snippet;
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

        ItemStack EnchantedIronSword = new ItemStack(Items.IRON_SWORD);
        ItemStack EnchantedIronHelmet = new ItemStack(Items.IRON_HELMET);
        ItemStack EnchantedIronChest = new ItemStack(Items.IRON_CHESTPLATE);
        ItemStack EnchantedIronLegging = new ItemStack(Items.IRON_LEGGINGS);
        ItemStack EnchantedIronBoots = new ItemStack(Items.IRON_BOOTS);



        //NETHERITE WEAPONS/ARMOR
        tryApplyEnchant(world, EnchantedNetheriteSword, EnchantmentUtils::applyFireAspect, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteSword, EnchantmentUtils::applyUnbreaking, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteSword, EnchantmentUtils::applyKnockback, 0.25);

        tryApplyEnchant(world, EnchantedNetheriteHelmet, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteChest, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteChest, EnchantmentUtils::applyThorns, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteLegging, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedNetheriteBoots, EnchantmentUtils::applyProtection, 0.25);

        //DIAMOUND WEAPONS/ARMOR
        tryApplyEnchant(world, EnchantedDiamondSword, EnchantmentUtils::applyFireAspect, 0.25);
        tryApplyEnchant(world, EnchantedDiamondSword, EnchantmentUtils::applyUnbreaking, 0.25);
        tryApplyEnchant(world, EnchantedDiamondSword, EnchantmentUtils::applyKnockback, 0.25);

        tryApplyEnchant(world, EnchantedDiamondHelmet, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedDiamondChest, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedDiamondChest, EnchantmentUtils::applyThorns, 0.25);
        tryApplyEnchant(world, EnchantedDiamondLegging, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedDiamondBoots, EnchantmentUtils::applyProtection, 0.25);

        //IRON WEAPONS/ARMOR
        tryApplyEnchant(world, EnchantedDiamondSword, EnchantmentUtils::applyFireAspect, 0.25);
        tryApplyEnchant(world, EnchantedDiamondSword, EnchantmentUtils::applyUnbreaking, 0.25);
        tryApplyEnchant(world, EnchantedDiamondSword, EnchantmentUtils::applyKnockback, 0.25);

        tryApplyEnchant(world, EnchantedIronHelmet, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedIronChest, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedIronChest, EnchantmentUtils::applyThorns, 0.25);
        tryApplyEnchant(world, EnchantedIronLegging, EnchantmentUtils::applyProtection, 0.25);
        tryApplyEnchant(world, EnchantedIronBoots, EnchantmentUtils::applyProtection, 0.25);

        for (PlayerEntity player : world.getPlayers()) {
            long time = world.getTimeOfDay() % 24000;
            int xp = player.experienceLevel;
            double rand = Math.random();

            if (xp >= 60) {
                if (time >= 13000 && time < 24000) {
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*60, 2));
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,20*60, 3));
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60, 2));
                } else {
                    zombie.removeStatusEffect(StatusEffects.SPEED);
                    zombie.removeStatusEffect(StatusEffects.STRENGTH);
                    zombie.removeStatusEffect(StatusEffects.RESISTANCE);

                }
                if (rand < 0.015){
                    equipWith(zombie, EquipmentSlot.HEAD, EnchantedNetheriteHelmet);
                    equipWith(zombie, EquipmentSlot.CHEST, EnchantedNetheriteChest);
                    equipWith(zombie, EquipmentSlot.LEGS, EnchantedNetheriteLegging);
                    equipWith(zombie, EquipmentSlot.FEET, EnchantedNetheriteBoots);
                }
                if (rand <0.085) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedNetheriteSword);
                }

            }
            else if (xp >= 30) {
                if (time >= 13000 && time < 24000) {
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*60, 1));
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,20*60, 2));
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60, 1));
                } else {
                    zombie.removeStatusEffect(StatusEffects.SPEED);
                    zombie.removeStatusEffect(StatusEffects.STRENGTH);
                    zombie.removeStatusEffect(StatusEffects.RESISTANCE);

                }
                if (rand < 0.015){
                    equipWith(zombie, EquipmentSlot.HEAD, EnchantedNetheriteHelmet);
                    equipWith(zombie, EquipmentSlot.CHEST, EnchantedNetheriteChest);
                    equipWith(zombie, EquipmentSlot.LEGS, EnchantedNetheriteLegging);
                    equipWith(zombie, EquipmentSlot.FEET, EnchantedNetheriteBoots);
                }
                if (rand <0.085) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedNetheriteSword);
                }

            }
            else if (xp >= 20) {
                if (time >= 13000 && time < 24000) {
                    zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*60, 1));
                } else {
                    zombie.removeStatusEffect(StatusEffects.STRENGTH);
                }

                if (rand < 0.015){
                    equipWith(zombie, EquipmentSlot.HEAD, EnchantedIronHelmet);
                    equipWith(zombie, EquipmentSlot.CHEST, EnchantedIronChest);
                    equipWith(zombie, EquipmentSlot.LEGS, EnchantedIronLegging);
                    equipWith(zombie, EquipmentSlot.FEET, EnchantedIronBoots);
                }
                if (rand <0.085) {
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
        zombie.setEquipmentDropChance(slot, 1.0f);
    }
}