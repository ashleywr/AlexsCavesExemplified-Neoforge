package org.crimsoncrips.alexscavesexemplified.mixins.misc;

import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRegistry;
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.crimsoncrips.alexscavesexemplified.server.blocks.ACExBlockRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static java.lang.Math.cos;
import static java.lang.Math.sin;


@Mixin(Gui.class)
public abstract class ACExGuiMixin {


    @Shadow @Final protected Minecraft minecraft;

    @Shadow @Final protected RandomSource random;

    @Shadow protected ItemStack lastToolHighlight;

    @Shadow public abstract Font getFont();

    @WrapOperation(method = "renderItemHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderSlot(Lnet/minecraft/client/gui/GuiGraphics;IILnet/minecraft/client/DeltaTracker;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;I)V"))
    private void alexsCavesExemplified$renderHotbar(Gui instance, GuiGraphics pGuiGraphics, int j1, int k1, DeltaTracker deltaTracker, Player player, ItemStack itemStack, int slotSeed, Operation<Void> original) {
        if(magneticMove(itemStack)){
            int t = minecraft.player.tickCount;
            double speed = 0.1;
            pGuiGraphics.pose().pushPose();

            //Thank you Reimnop for the giga nerd math code
            double x = -sin(speed * t) * cos(0.1 * t + slotSeed * 4638.361D + 164.35D) + cos(speed * t);
            double y = cos(speed * t) * cos(0.2 * t + slotSeed * 4638.361D + 364.35D) + sin(speed * t);
            pGuiGraphics.pose().translate(x, y, 0);
        }
        original.call(instance, pGuiGraphics, j1, k1, deltaTracker, player, itemStack, slotSeed);
        if(magneticMove(itemStack)){
            pGuiGraphics.pose().popPose();
        }
    }

    @WrapWithCondition(method = "renderSelectedItemName(Lnet/minecraft/client/gui/GuiGraphics;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawStringWithBackdrop(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIII)I"))
    private boolean alexsCavesExemplified$renderSelectedItemName(GuiGraphics graphics, Font font, Component text, int x, int y, int width, int color){
        if (this.lastToolHighlight.is(ACExBlockRegistry.GAMMA_NUCLEAR_BOMB.get().asItem()) && this.minecraft.player != null) {
            float time = this.minecraft.player.tickCount;
            int alpha = color >>> 24;
            for (int echo = 6; echo > 1; echo--) {
                int offset = (int) (Math.sin(time / 10.0F + echo / 10.0F) * -5.0F);
                graphics.drawString(font, text, x + offset, y, FastColor.ARGB32.color(alpha / echo, color & 0xFFFFFF), false);
            }
        }
        return true;
    }


    public boolean magneticMove(ItemStack itemStack){
        return itemStack.is(ACTagRegistry.MAGNETIC_ITEMS) && minecraft.player.level().getBiome(minecraft.player.blockPosition()).is(ACBiomeRegistry.MAGNETIC_CAVES) && AlexsCavesExemplified.CLIENT_CONFIG.MAGNETIC_MOVEMENT_ENABLED.get();
    }


    



}
