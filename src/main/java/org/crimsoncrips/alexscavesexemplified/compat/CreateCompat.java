package org.crimsoncrips.alexscavesexemplified.compat;

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.FrostmintSpearEntity;
import com.github.alexmodguy.alexscaves.server.entity.util.FrostmintExplosion;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.crimsoncrips.alexscavesexemplified.misc.ACExUtils;

public class CreateCompat {


    public static void solidifyCreateLiquid(FrostmintSpearEntity frostmintSpear, Level level, BlockPos blockPos){
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    BlockPos icePos = new BlockPos(blockPos.getX() + x, blockPos.getY() + y , blockPos.getZ() + z);
                    BlockState blockState = level.getBlockState(icePos);
                    ResourceLocation fluidId = BuiltInRegistries.FLUID.getKey(blockState.getFluidState().getType());
                    if (fluidId.equals(ResourceLocation.fromNamespaceAndPath("create", "chocolate"))) {
                        level.setBlock(icePos, ACBlockRegistry.BLOCK_OF_CHOCOLATE.get().defaultBlockState(), 3);
                        level.scheduleTick(icePos, blockState.getBlock(), 2);
                        frostmintSpear.discard();
                        explode(level,frostmintSpear);
                    } else if (fluidId.equals(ResourceLocation.fromNamespaceAndPath("create", "honey"))) {
                        level.setBlock(icePos, Blocks.HONEY_BLOCK.defaultBlockState(), 3);
                        level.scheduleTick(icePos, blockState.getBlock(), 2);
                        frostmintSpear.discard();
                        explode(level,frostmintSpear);
                    }
                    ACExUtils.awardAdvancement(frostmintSpear.getOwner(),"frostmint_freeze","freeze");
                }
            }
        }
    }

    private static void explode(Level level, FrostmintSpearEntity frostmintSpear) {
        FrostmintExplosion explosion = new FrostmintExplosion(level, frostmintSpear.getOwner(), frostmintSpear.getX(), frostmintSpear.getY(0.5), frostmintSpear.getZ(), 2.0F, Explosion.BlockInteraction.KEEP, true);
        explosion.explode();
        explosion.finalizeExplosion(true);
    }

    public static int createDivingSuit(LivingEntity livingEntity){
        int i = 0;
        if (hasItem(livingEntity, EquipmentSlot.HEAD, "create:copper_diving_helmet")) {
            i = i + 2;
        }
        if (hasItem(livingEntity, EquipmentSlot.FEET, "create:copper_diving_boots")) {
            i = i + 1;
        }
        if (hasItem(livingEntity, EquipmentSlot.CHEST, "create:copper_backtank")) {
            i = i + 1;
        }

        if (hasItem(livingEntity, EquipmentSlot.HEAD, "create:netherite_diving_helmet")) {
            i = i + 3;
        }
        if (hasItem(livingEntity, EquipmentSlot.FEET, "create:netherite_diving_boots")) {
            i = i + 3;
        }
        if (hasItem(livingEntity, EquipmentSlot.CHEST, "create:netherite_backtank")) {
            i = i + 5;
        }

        return i;
    }

    private static boolean hasItem(LivingEntity entity, EquipmentSlot slot, String id) {
        return entity.getItemBySlot(slot).is(BuiltInRegistries.ITEM.get(ResourceLocation.parse(id)));
    }





}
