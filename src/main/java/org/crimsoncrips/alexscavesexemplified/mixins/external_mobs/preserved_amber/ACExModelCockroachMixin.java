package org.crimsoncrips.alexscavesexemplified.mixins.external_mobs.preserved_amber;

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexthe666.alexsmobs.client.model.ModelCockroach;
import com.github.alexthe666.alexsmobs.entity.EntityCockroach;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ModelCockroach.class)
public abstract class ACExModelCockroachMixin {

    /** See {@link ACExModelFlyMixin}: cancel only after restoring the default model pose. */
    @Inject(method = "setupAnim(Lcom/github/alexthe666/alexsmobs/entity/EntityCockroach;FFFFF)V", at = @At("HEAD"), cancellable = true, remap = false)
    private void alexsCavesExemplified$freezePreservedCockroach(EntityCockroach cockroach, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        Block block = cockroach.level().getBlockState(cockroach.blockPosition()).getBlock();
        if (AlexsCavesExemplified.COMMON_CONFIG.PRESERVED_AMBER_ENABLED.get() && cockroach.isNoAi() && ModList.get().isLoaded("alexsmobs") && block == ACBlockRegistry.AMBER.get()) {
            ((ModelCockroach) (Object) this).resetToDefaultPose();
            ci.cancel();
        }
    }


}
