package difficultxplevel.modid.util;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.enchantment.Enchantment;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;

public class EnchantedItemFactory {

    public static ItemStack createEnchantedSword(ServerWorld world, Enchantment enchantment, int level) {
        Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> enchantmentEntry = enchantmentRegistry.getOrThrow(Enchantments.SHARPNESS);

        ItemStack sword = new ItemStack(Items.DIAMOND_SWORD);
        sword.addEnchantment(enchantmentEntry, 3);

        return sword;
    }
}
