package org.crimsoncrips.alexscavesexemplified.mixins.mobs.tesla_bulb;

import com.github.alexmodguy.alexscaves.client.model.TeslaBulbModel;
import com.github.alexmodguy.alexscaves.client.render.ACRenderTypes;
import com.github.alexmodguy.alexscaves.client.render.blockentity.TelsaBulbBlockRenderer;
import com.github.alexmodguy.alexscaves.server.block.blockentity.TeslaBulbBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.crimsoncrips.alexscavesexemplified.misc.interfaces.ACExBaseInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(TelsaBulbBlockRenderer.class)
public abstract class ACExTeslaBulbRenderMixin<T extends TeslaBulbBlockEntity> implements BlockEntityRenderer<T> {

    private static final TeslaBulbModel MODEL = new TeslaBulbModel();
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("alexscaves", "textures/entity/tesla_bulb.png");
    private static final ResourceLocation TEXTURE_CHARGE_1 = ResourceLocation.fromNamespaceAndPath("alexscavesexemplified", "textures/entity/tesla/tesla_charge_1.png");
    private static final ResourceLocation TEXTURE_CHARGE_2 = ResourceLocation.fromNamespaceAndPath("alexscavesexemplified", "textures/entity/tesla/tesla_charge_2.png");
    private static final ResourceLocation TEXTURE_CHARGE_3 = ResourceLocation.fromNamespaceAndPath("alexscavesexemplified", "textures/entity/tesla/tesla_charge_3.png");
    private static final ResourceLocation TEXTURE_CHARGE_4 = ResourceLocation.fromNamespaceAndPath("alexscavesexemplified", "textures/entity/tesla/tesla_charge_4.png");


    @Inject(method = "render(Lcom/github/alexmodguy/alexscaves/server/block/blockentity/TeslaBulbBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "INVOKE", target = "Lcom/github/alexmodguy/alexscaves/client/model/TeslaBulbModel;setupAnim(Lnet/minecraft/world/entity/Entity;FFFFF)V"), cancellable = true)
    private void alexsCavesExemplified$render(T teslaBulb, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn, CallbackInfo ci) {
        if(AlexsCavesExemplified.COMMON_CONFIG.SHOCKING_THERAPY_ENABLED.get()){
            ci.cancel();
            MODEL.setupAnim(null, 0.0F, teslaBulb.getExplodeProgress(partialTicks), (float)teslaBulb.age + partialTicks, 0.0F, 0.0F);
            int charge = ((ACExBaseInterface)teslaBulb).getCharge();
            MODEL.renderToBuffer(poseStack, bufferIn.getBuffer(ACRenderTypes.getTeslaBulb(charge > 25 ? TEXTURE_CHARGE_4 : charge > 20 ? TEXTURE_CHARGE_3 : charge > 15 ? TEXTURE_CHARGE_2 : charge > 10 ? TEXTURE_CHARGE_1 : TEXTURE)), combinedLightIn, combinedOverlayIn, 0xFFFFFFFF);
            poseStack.popPose();
        }
    }






}
