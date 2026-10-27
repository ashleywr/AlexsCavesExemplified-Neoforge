package org.crimsoncrips.alexscavesexemplified.mixins.client;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
@Mixin(Camera.class)
public interface ACExCameraInvoker {
    @Invoker("move") void invokeMove(float zoom, float dy, float dx);
    @Invoker("getMaxZoom") float invokeGetMaxZoom(float zoom);
}
