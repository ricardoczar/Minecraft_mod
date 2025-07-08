package difficultxplevel.modid;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;

    public class ZombieEquipmentManager {
        public static void tryEquipZombie(ZombieEntity zombie, ServerWorld world) {

            Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
            ItemStack IronSword = new ItemStack(Items.IRON_SWORD);
            ItemStack DiamoundSword = new ItemStack(Items.DIAMOND_SWORD);
            ItemStack NetheriteSword = new ItemStack(Items.NETHERITE_SWORD);
            RegistryEntry<Enchantment> sharpnessEntry = enchantmentRegistry.getOrThrow(Enchantments.SHARPNESS);
            RegistryEntry<Enchantment> knockbackEntry = enchantmentRegistry.getOrThrow(Enchantments.KNOCKBACK);

            RegistryEntry<Enchantment> EfficiencyEntry = enchantmentRegistry.getOrThrow(Enchantments.EFFICIENCY);
            IronSword.addEnchantment(sharpnessEntry, 5);
            IronSword.addEnchantment(knockbackEntry, 3);


            for (PlayerEntity player : world.getPlayers()) {
                if (player.experienceLevel >= 10 && Math.random() < 0.5) {
                    zombie.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_SWORD));
                    zombie.setEquipmentDropChance(EquipmentSlot.CHEST, 1F);
                    if (Math.random() < 0.5){
                        zombie.equipStack(EquipmentSlot.MAINHAND, IronSword);
                    } else{
                        zombie.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
                    }
                    zombie.setEquipmentDropChance(EquipmentSlot.MAINHAND, 1F);
                    break; //
                }
                if (player.experienceLevel >= 20 && Math.random() < 0.5) {
                    zombie.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
                    zombie.setEquipmentDropChance(EquipmentSlot.CHEST, 1F);
                    if (Math.random() < 0.5){
                        zombie.equipStack(EquipmentSlot.MAINHAND, IronSword);
                    } else{
                        zombie.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
                    }
                    zombie.setEquipmentDropChance(EquipmentSlot.MAINHAND, 1F);
                    break; //
                }
                if (player.experienceLevel >= 30 && Math.random() < 0.5) {
                    zombie.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
                    zombie.setEquipmentDropChance(EquipmentSlot.CHEST, 1F);
                    if (Math.random() < 0.5){
                        zombie.equipStack(EquipmentSlot.MAINHAND, IronSword);
                    } else{
                        zombie.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
                    }
                    zombie.setEquipmentDropChance(EquipmentSlot.MAINHAND, 1F);
                    break; //
                }
            }
        }

    }
