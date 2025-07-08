package difficultxplevel.modid;

import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import oshi.util.tuples.Pair;


import java.util.List;
import java.util.Map;


public class SkeletonEquipmentManager {
    public static void tryEquipSkeleton(SkeletonEntity skeleton, ServerWorld world) {
        for (PlayerEntity player : world.getPlayers()) {

            ItemStack sword = new ItemStack(Items.IRON_SWORD);



            if (player.experienceLevel >= 10 && Math.random() < 0.1) {
                skeleton.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
                skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 0.25F);
                skeleton.equipStack(EquipmentSlot.MAINHAND, sword);
                skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.25F);
                break; //
            }
            else if (player.experienceLevel >= 10 && Math.random() < 0.05){
                skeleton.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
                skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 0.25F);
                skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
                skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.25F);
                break; //

            }
            else if (player.experienceLevel >= 10 && Math.random() < 0.05){
                skeleton.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
                skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 0.25F);
                skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
                skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.25F);
                break; //

            }
            else if (player.experienceLevel >= 20 && Math.random() < 0.05){
                skeleton.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
                skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 0.25F);
                skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
                skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.25F);
                break; //

            }
            else if (player.experienceLevel >= 30 && Math.random() < 0.05){
                skeleton.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
                skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 0.25F);
                skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
                skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.25F);
                break; //

            }
            else if (player.experienceLevel >= 40 && Math.random() < 0.5){
                skeleton.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
                skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 0.25F);
                skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
                skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.25F);
                break; //

            }

        }
    }
}
