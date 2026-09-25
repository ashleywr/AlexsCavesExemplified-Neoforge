package org.crimsoncrips.alexscavesexemplified.mixins.misc;

import com.github.alexmodguy.alexscaves.server.entity.ACFrogRegistry;
import com.github.alexmodguy.alexscaves.server.level.feature.AmbersolFeature;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.fml.ModList;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.crimsoncrips.alexscavesexemplified.compat.AMCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(AmbersolFeature.class)
public abstract class ACExAmberFeatureMixin extends Feature<NoneFeatureConfiguration> {

    public ACExAmberFeatureMixin(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }
    //Massive Props to Drullkus for assistance


    @Inject(method = "drawOrb", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/WorldGenLevel;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"))
    private static void drawOrb(WorldGenLevel level, BlockPos center, RandomSource random, BlockState blockState, int radiusX, int radiusY, int radiusZ, CallbackInfo ci, @Local(ordinal = 1) BlockPos fill) {
        if (random.nextDouble() < 0.02 && AlexsCavesExemplified.COMMON_CONFIG.PRESERVED_AMBER_ENABLED.get() && level.ensureCanWrite(fill) && level.ensureCanWrite(center)) {
            switch (random.nextInt(0, 4)) {
                case 0:
                    if (!ModList.get().isLoaded("alexsmobs"))
                        return;
                    LivingEntity entity = AMCompat.createAmberAM(level.getLevel(), random);
                    finalizeAmberSpawn(fill, entity, level, random);
                    break;
                case 1:
                    Frog frog = EntityType.FROG.create(level.getLevel());
                    if (frog != null) {
                        frog.setNoAi(true);
                        finalizeAmberSpawn(fill, frog, level, random);
                    }
                    break;
                default:
                    Tadpole tadpole = EntityType.TADPOLE.create(level.getLevel());
                    if (tadpole != null) {
                        tadpole.setNoAi(true);
                        finalizeAmberSpawn(fill, tadpole, level, random);
                    }
                    break;
            }
        }
    }

    @Unique
    private static void finalizeAmberSpawn(BlockPos spawnPos, LivingEntity entity, WorldGenLevel level, RandomSource random){
        entity.setInvulnerable(true);
        entity.setPos(spawnPos.getCenter().x, spawnPos.getY() + 0.4, spawnPos.getCenter().z);
        int rotation = random.nextInt(0, 361);
        entity.setYBodyRot(rotation);
        entity.setYHeadRot(rotation);
        entity.setYRot(rotation);
        entity.setSilent(true);

        if (entity instanceof Frog frog){
            Holder<FrogVariant> variant = switch (random.nextInt(0, 4)) {
                case 0 -> level.getLevel().registryAccess().lookupOrThrow(Registries.FROG_VARIANT).getOrThrow(FrogVariant.COLD);
                case 1 -> level.getLevel().registryAccess().lookupOrThrow(Registries.FROG_VARIANT).getOrThrow(FrogVariant.WARM);
                case 2 -> level.getLevel().registryAccess().lookupOrThrow(Registries.FROG_VARIANT).getOrThrow(FrogVariant.TEMPERATE);
                default -> ACFrogRegistry.PRIMORDIAL;
            };
            frog.setVariant(variant);
        }

        // WorldGenLevel writes the entity into the generating chunk. Do not bypass it
        // through ServerLevel: C2ME may place this feature on a worker thread.
        level.addFreshEntity(entity);
    }

}
