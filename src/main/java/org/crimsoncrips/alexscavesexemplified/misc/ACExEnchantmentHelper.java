package org.crimsoncrips.alexscavesexemplified.misc;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
public final class ACExEnchantmentHelper {
    private ACExEnchantmentHelper() {}
    public static int getEnchantmentLevelFromStack(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments enchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        for (var entry : enchantments.entrySet()) {
            if (entry.getKey().is(enchantment)) return entry.getIntValue();
        }
        return 0;
    }
    public static int getEnchantmentLevel(Level level, ResourceKey<Enchantment> enchantment, ItemStack stack) {
        return getEnchantmentLevelFromStack(enchantment, stack);
    }
}
