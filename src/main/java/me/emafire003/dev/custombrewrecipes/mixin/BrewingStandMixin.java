package me.emafire003.dev.custombrewrecipes.mixin;

import me.emafire003.dev.custombrewrecipes.CustomBrewRecipeRegister;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandBlockEntity.class)
public abstract class BrewingStandMixin {

    @Inject(method = "isValid", at = @At(value = "HEAD"), cancellable = true)
    public void isValidInject(int slot, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if(slot != 4 && slot != 3 && CustomBrewRecipeRegister.isValidCustomInput(stack)) {
            cir.setReturnValue(true);
        }
    }

}
