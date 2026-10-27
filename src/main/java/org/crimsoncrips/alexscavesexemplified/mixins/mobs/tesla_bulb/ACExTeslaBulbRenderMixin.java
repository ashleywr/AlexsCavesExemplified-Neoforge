package org.crimsoncrips.alexscavesexemplified.mixins.mobs.tesla_bulb;

import com.github.alexmodguy.alexscaves.client.render.blockentity.TelsaBulbBlockRenderer;
import com.github.alexmodguy.alexscaves.server.block.blockentity.TeslaBulbBlockEntity;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.resources.ResourceLocation;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.crimsoncrips.alexscavesexemplified.server.ACExAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TelsaBulbBlockRenderer.class)
public abstract class ACExTeslaBulbRenderMixin {
    @ModifyArg(
        method = "render(Lcom/github/alexmodguy/alexscaves/server/block/blockentity/TeslaBulbBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
        at = @At(value = "INVOKE", target = "Lcom/github/alexmodguy/alexscaves/client/render/ACRenderTypes;getTeslaBulb(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;"),
        index = 0)
    private ResourceLocation alexscavesexemplified$chargedTexture(ResourceLocation original, @Local(argsOnly = true) TeslaBulbBlockEntity bulb) {
        if (!AlexsCavesExemplified.COMMON_CONFIG.SHOCKING_THERAPY_ENABLED.get()) return original;
        int charge = bulb.getData(ACExAttachments.TESLA_CHARGE).intValue();
        int stage = charge > 25 ? 4 : charge > 20 ? 3 : charge > 15 ? 2 : charge > 10 ? 1 : 0;
        return stage == 0 ? original : AlexsCavesExemplified.prefix("textures/entity/tesla/tesla_charge_" + stage + ".png");
    }
}
