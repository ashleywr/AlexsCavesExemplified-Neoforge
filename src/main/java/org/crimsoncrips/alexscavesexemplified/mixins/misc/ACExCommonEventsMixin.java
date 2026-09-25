package org.crimsoncrips.alexscavesexemplified.mixins.misc;

import com.github.alexmodguy.alexscaves.server.event.CommonEvents;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(CommonEvents.class)
public class ACExCommonEventsMixin {


    @Inject(method = "checkAndDestroyExploitItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V"), cancellable = true)
    private static void onStep(Player player, EquipmentSlot slot, CallbackInfo ci, @Local ItemStack itemInHand) {
        if(AlexsCavesExemplified.COMMON_CONFIG.POWERED_LOCATORS_ENABLED.get()){
            CompoundTag customData = itemInHand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
            if(!customData.getBoolean("WitherProtection")){
                if (slot == EquipmentSlot.MAINHAND) {
                    ItemStack offHand = player.getItemBySlot(EquipmentSlot.OFFHAND);
                    if (offHand.is(Items.NETHER_STAR)) {
                        itemInHand.enchant(player.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 10);
                        customData.putBoolean("WitherProtection", true);
                        itemInHand.set(DataComponents.CUSTOM_DATA, CustomData.of(customData));

                        player.playSound(SoundEvents.WITHER_DEATH);
                        offHand.shrink(1);
                        if (!player.level().isClientSide) {
                            player.displayClientMessage(Component.translatable("misc.alexscavesexemplified.locator_protection"), true);
                        }
                        ci.cancel();
                    }
                } else if (slot == EquipmentSlot.OFFHAND) {
                    ItemStack mainHand = player.getItemBySlot(EquipmentSlot.MAINHAND);
                    if (mainHand.is(Items.NETHER_STAR)) {
                        itemInHand.enchant(player.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 10);
                        customData.putBoolean("WitherProtection", true);
                        itemInHand.set(DataComponents.CUSTOM_DATA, CustomData.of(customData));

                        player.playSound(SoundEvents.WITHER_DEATH);
                        mainHand.shrink(1);
                        if (!player.level().isClientSide) {
                            player.displayClientMessage(Component.translatable("item.alexscavesexemplified.locator_protection"), true);
                        }
                        ci.cancel();
                    }
                }
            } else {
                ci.cancel();
            }
        }
    }

}
