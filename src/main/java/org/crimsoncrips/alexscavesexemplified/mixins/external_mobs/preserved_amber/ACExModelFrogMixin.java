package org.crimsoncrips.alexscavesexemplified.mixins.external_mobs.preserved_amber;

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import net.minecraft.client.model.FrogModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.level.block.Block;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(FrogModel.class)
public abstract class ACExModelFrogMixin<T extends Frog> extends HierarchicalModel<T> {

    /**
     * Preserve the default pose without depending on FrogModel's internal animation sequence.
     * The model's root is its public, stable pose-reset surface.
     */
    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/animal/frog/Frog;FFFFF)V", at = @At("HEAD"), cancellable = true)
    private void alexsCavesExemplified$freezePreservedFrog(T frog, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, CallbackInfo ci) {
        Block block = frog.level().getBlockState(frog.blockPosition()).getBlock();
        if (AlexsCavesExemplified.COMMON_CONFIG.PRESERVED_AMBER_ENABLED.get() && frog.isNoAi() && block == ACBlockRegistry.AMBER.get()) {
            this.root().getAllParts().forEach(ModelPart::resetPose);
            ci.cancel();
        }
    }


}
