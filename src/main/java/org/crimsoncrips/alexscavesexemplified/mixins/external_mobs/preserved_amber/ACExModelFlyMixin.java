package org.crimsoncrips.alexscavesexemplified.mixins.external_mobs.preserved_amber;

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexthe666.alexsmobs.client.model.ModelFly;
import com.github.alexthe666.alexsmobs.entity.EntityFly;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ModelFly.class)
public abstract class ACExModelFlyMixin {

    /**
     * Keep preserved flies static without anchoring the mixin to Citadel animation helpers.
     * Alex's Mobs has relocated those helpers before, while setupAnim's entity signature is
     * the intended model API and is the supported ACEx/Alex's Mobs compatibility boundary.
     */
    @Inject(method = "setupAnim(Lcom/github/alexthe666/alexsmobs/entity/EntityFly;FFFFF)V", at = @At("HEAD"), cancellable = true, remap = false)
    private void alexsCavesExemplified$freezePreservedFly(EntityFly fly, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        Block block = fly.level().getBlockState(fly.blockPosition()).getBlock();
        if (AlexsCavesExemplified.COMMON_CONFIG.PRESERVED_AMBER_ENABLED.get() && fly.isNoAi() && ModList.get().isLoaded("alexsmobs") && block == ACBlockRegistry.AMBER.get()) {
            ((ModelFly) (Object) this).resetToDefaultPose();
            ci.cancel();
        }
    }


}
