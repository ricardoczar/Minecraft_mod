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

public class ZombieEquipmentManager {
    private static void tryApplyEnchant(ServerWorld world, ItemStack item, BiConsumer<ServerWorld, ItemStack> enchantMethod, double chance) {
        if (Math.random() < chance) {
            enchantMethod.accept(world, item);
        }
    }

    public static void tryEquipZombie(ZombieEntity zombie, ServerWorld world) {
        ItemStack LeatherHelmet = new ItemStack(Items.LEATHER_HELMET);
        ItemStack LeatherChest = new ItemStack(Items.LEATHER_CHESTPLATE);
        ItemStack LeatherLegging = new ItemStack(Items.LEATHER_LEGGINGS);
        ItemStack LeatherBoots = new ItemStack(Items.LEATHER_BOOTS);

        ItemStack ChainHelmet = new ItemStack(Items.CHAINMAIL_HELMET);
        ItemStack ChainChest = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
        ItemStack ChainLegging = new ItemStack(Items.CHAINMAIL_LEGGINGS);
        ItemStack ChainBoots = new ItemStack(Items.CHAINMAIL_BOOTS);

        ItemStack IronHelmet = new ItemStack(Items.IRON_HELMET);
        ItemStack IronChest = new ItemStack(Items.IRON_CHESTPLATE);
        ItemStack IronLegging = new ItemStack(Items.IRON_LEGGINGS);
        ItemStack IronBoots = new ItemStack(Items.IRON_BOOTS);
        ItemStack EnchantedIronSword = new ItemStack(Items.IRON_SWORD);

        ItemStack DiamondHelmet = new ItemStack(Items.DIAMOND_HELMET);
        ItemStack DiamondChest = new ItemStack(Items.DIAMOND_CHESTPLATE);
        ItemStack DiamondLegging = new ItemStack(Items.DIAMOND_LEGGINGS);
        ItemStack DiamondBoots = new ItemStack(Items.DIAMOND_BOOTS);
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
            int xp = player.experienceLevel;

            if (xp >= 60) {
                zombie.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*60,2));
                if (Math.random() <0.1){
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
                if (Math.random() < 0.1) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
                } else if (Math.random() < 0.05) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedDiamondSword);
                } else if (Math.random() < 0.01) {
                    equipWith(zombie, EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
                    equipWith(zombie, EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
                    equipWith(zombie, EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
                    equipWith(zombie, EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedDiamondSword);
                }

            }
            else if (xp >= 20) {
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
                if (Math.random() < 0.1) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
                } else if (Math.random() < 0.05) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_CHESTPLATE));
                } else if (Math.random() < 0.01) {
                    equipWith(zombie, EquipmentSlot.HEAD, new ItemStack(Items.CHAINMAIL_HELMET));
                    equipWith(zombie, EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
                    equipWith(zombie, EquipmentSlot.LEGS, new ItemStack(Items.CHAINMAIL_LEGGINGS));
                    equipWith(zombie, EquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_BOOTS));
                    equipWith(zombie, EquipmentSlot.MAINHAND, EnchantedIronSword);
                }

            }

            else if (xp >= 5) {
                if (Math.random() < 0.1) {
                    equipWith(zombie, EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
                } else if (Math.random() < 0.05) {
                    ItemStack enchantedWooden = new ItemStack(Items.WOODEN_SWORD);
                    EnchantmentUtils.applyUnbreaking(world, enchantedWooden);
                    equipWith(zombie, EquipmentSlot.MAINHAND, enchantedWooden);
                } else if (Math.random() < 0.01) {
                    equipWith(zombie, EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
                    equipWith(zombie, EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
                    equipWith(zombie, EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
                    equipWith(zombie, EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
                }
            }
        }
    }

    private static void equipWith(ZombieEntity zombie, EquipmentSlot slot, ItemStack item) {
            zombie.equipStack(slot, item);
            zombie.setEquipmentDropChance(slot, 0.01f);

    }
}