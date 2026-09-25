package org.crimsoncrips.alexscavesexemplified.mixins.misc;

import com.github.alexmodguy.alexscaves.server.entity.item.DarkArrowEntity;
import com.github.alexmodguy.alexscaves.server.item.DreadbowItem;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.crimsoncrips.alexscavesexemplified.misc.ACExUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(DreadbowItem.class)
public abstract class ACExDreadbowItemMixin extends ProjectileWeaponItem {

    public ACExDreadbowItemMixin(Properties pProperties) {
        super(pProperties);
    }


    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lcom/github/alexmodguy/alexscaves/server/entity/item/DarkArrowEntity;setPerfectShot(Z)V"))
    private void alexsCavesExemplified$releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i1, CallbackInfo ci, @Local AbstractArrow abstractArrow, @Local DarkArrowEntity darkArrowEntity) {
        if(AlexsCavesExemplified.COMMON_CONFIG.DREAD_ADDAPTIONS_ENABLED.get()){
            double power = ACExUtils.getEnchantmentLevel(itemStack, livingEntity, Enchantments.POWER);
            int punch = ACExUtils.getEnchantmentLevel(itemStack, livingEntity, Enchantments.PUNCH);
            boolean flaming = ACExUtils.getEnchantmentLevel(itemStack, livingEntity, Enchantments.FLAME) > 0;

            darkArrowEntity.setShadowArrowDamage((float) (darkArrowEntity.getShadowArrowDamage() * (power > 0 ? power : 1)));
            if (punch > 0) darkArrowEntity.getPersistentData().putInt("ACExKnockback", punch);
            if (flaming) {
                darkArrowEntity.igniteForSeconds(100.0F);
            }
        }
    }

    @Inject(method = "onUseTick", at = @At(value = "INVOKE", target = "Lcom/github/alexmodguy/alexscaves/server/entity/item/DarkArrowEntity;setShadowArrowDamage(F)V"))
    private void alexsCavesExemplified$onUseTick(Level level, LivingEntity living, ItemStack itemStack, int timeUsing, CallbackInfo ci, @Local AbstractArrow abstractArrow, @Local DarkArrowEntity darkArrowEntity) {
        if(AlexsCavesExemplified.COMMON_CONFIG.DREAD_ADDAPTIONS_ENABLED.get()) {
            int punch = ACExUtils.getEnchantmentLevel(itemStack, living, Enchantments.PUNCH);
            boolean flaming = ACExUtils.getEnchantmentLevel(itemStack, living, Enchantments.FLAME) > 0;

            if (punch > 0) darkArrowEntity.getPersistentData().putInt("ACExKnockback", punch);
            if (flaming) {
                darkArrowEntity.igniteForSeconds(100.0F);
            }
        }
    }

    @WrapWithCondition(method = "onUseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V"))
    private boolean alexsCavesExemplified$onUseTick1(ItemStack instance, int pDecrement, @Local(ordinal = 0) ItemStack bow, @Local(argsOnly = true) LivingEntity living) {
        return ACExUtils.getEnchantmentLevel(bow, living, Enchantments.INFINITY) <= 0;
    }



    @ModifyArg(method = "onUseTick", at = @At(value = "INVOKE", target = "Lcom/github/alexmodguy/alexscaves/server/entity/item/DarkArrowEntity;setShadowArrowDamage(F)V"))
    private float alexsCavesExemplified$1(float f,@Local (ordinal = 0) ItemStack itemStack, @Local(argsOnly = true) LivingEntity living) {
        if(AlexsCavesExemplified.COMMON_CONFIG.DREAD_ADDAPTIONS_ENABLED.get()) {
            double power = ACExUtils.getEnchantmentLevel(itemStack, living, Enchantments.POWER);
            return (float) (f * (power > 0 ? power : 1));
        }
        return f;
    }

    @ModifyConstant(method = "onUseTick",constant = @Constant(intValue = 3))
    private int alexsCavesExemplified$tick3(int constant) {
        return (AlexsCavesExemplified.COMMON_CONFIG.RATATATATATA_ENABLED.get()) ? 1 : constant;
    }

    @ModifyReturnValue(method = "getMaxLoadTime", at = @At("RETURN"),remap = false)
    private static int getMaxLoadTime(int original) {
        return AlexsCavesExemplified.COMMON_CONFIG.RATATATATATA_ENABLED.get() ? 1 : original;
    }

}
