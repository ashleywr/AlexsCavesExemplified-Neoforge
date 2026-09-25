package org.crimsoncrips.alexscavesexemplified.server.enchantment;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;

public final class ACExEnchants {
    public static final ResourceKey<Enchantment> MAGNETICISM = ResourceKey.create(
            Registries.ENCHANTMENT, AlexsCavesExemplified.prefix("magneticism"));

    private ACExEnchants() {
    }

    public static int getMagneticismLevel(ItemStack stack, Entity entity) {
        return stack.getEnchantmentLevel(entity.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(MAGNETICISM));
    }
}
