package org.crimsoncrips.alexscavesexemplified.compat;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class BOPCompat {
    public static Block getBOPBlock(boolean liquidBlock){
        String path = liquidBlock ? "blood" : "flesh";
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("biomesoplenty", path));
    }
}
