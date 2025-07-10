package difficultxplevel.modid.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;

import java.util.concurrent.ThreadLocalRandom;

public class EnchantmentUtils {


    private static int getRandomLevel(int maxLevel) {
        return ThreadLocalRandom.current().nextInt(1, maxLevel + 1);
    }

    public static void applySharpness(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> sharpness = registry.getOrThrow(Enchantments.SHARPNESS);
        int level = getRandomLevel(5);
        itemStack.addEnchantment(sharpness, level);
    }

    public static void applySmite(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> smite = registry.getOrThrow(Enchantments.SMITE);
        int level = getRandomLevel(5);
        itemStack.addEnchantment(smite, level);
    }

    public static void applyBaneOfArthropods(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> bane = registry.getOrThrow(Enchantments.BANE_OF_ARTHROPODS);
        int level = getRandomLevel(5);
        itemStack.addEnchantment(bane, level);
    }

    public static void applyFireAspect(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> fireAspect = registry.getOrThrow(Enchantments.FIRE_ASPECT);
        int level = getRandomLevel(2);
        itemStack.addEnchantment(fireAspect, level);
    }

    public static void applyKnockback(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> knockback = registry.getOrThrow(Enchantments.KNOCKBACK);
        int level = getRandomLevel(2);
        itemStack.addEnchantment(knockback, level);
    }

    public static void applyLooting(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> looting = registry.getOrThrow(Enchantments.LOOTING);
        int level = getRandomLevel(3);
        itemStack.addEnchantment(looting, level);
    }

    public static void applyUnbreaking(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> unbreaking = registry.getOrThrow(Enchantments.UNBREAKING);
        int level = getRandomLevel(3);
        itemStack.addEnchantment(unbreaking, level);
    }

    public static void applyMending(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> mending = registry.getOrThrow(Enchantments.MENDING);

        itemStack.addEnchantment(mending, 1);

    }

    public static void applyProtection(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> protection = registry.getOrThrow(Enchantments.PROTECTION);
        int level = getRandomLevel(4);
        itemStack.addEnchantment(protection, level);
    }

    public static void applyFireProtection(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> fireProtection = registry.getOrThrow(Enchantments.FIRE_PROTECTION);
        int level = getRandomLevel(4);
        itemStack.addEnchantment(fireProtection, level);
    }

    public static void applyBlastProtection(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> blastProtection = registry.getOrThrow(Enchantments.BLAST_PROTECTION);
        int level = getRandomLevel(4);
        itemStack.addEnchantment(blastProtection, level);
    }

    public static void applyProjectileProtection(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> projectileProtection = registry.getOrThrow(Enchantments.PROJECTILE_PROTECTION);
        int level = getRandomLevel(4);
        itemStack.addEnchantment(projectileProtection, level);
    }

    public static void applyThorns(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> thorns = registry.getOrThrow(Enchantments.THORNS);
        int level = getRandomLevel(3);
        itemStack.addEnchantment(thorns, level);
    }

    public static void applyRespiration(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> respiration = registry.getOrThrow(Enchantments.RESPIRATION);
        int level = getRandomLevel(3);
        itemStack.addEnchantment(respiration, level);
    }

    public static void applyAquaAffinity(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> aquaAffinity = registry.getOrThrow(Enchantments.AQUA_AFFINITY);
        itemStack.addEnchantment(aquaAffinity, 1);
    }

    public static void applyDepthStrider(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> depthStrider = registry.getOrThrow(Enchantments.DEPTH_STRIDER);
        int level = getRandomLevel(3);
        itemStack.addEnchantment(depthStrider, level);
    }

    public static void applyFeatherFalling(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> featherFalling = registry.getOrThrow(Enchantments.FEATHER_FALLING);
        int level = getRandomLevel(4);
        itemStack.addEnchantment(featherFalling, level);
    }

    public static void applyFrostWalker(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> frostWalker = registry.getOrThrow(Enchantments.FROST_WALKER);
        int level = getRandomLevel(2);
        itemStack.addEnchantment(frostWalker, level);
    }

    public static void applySoulSpeed(ServerWorld world, ItemStack itemStack) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> soulSpeed = registry.getOrThrow(Enchantments.SOUL_SPEED);
        int level = getRandomLevel(3);
        itemStack.addEnchantment(soulSpeed, level);
    }




}
