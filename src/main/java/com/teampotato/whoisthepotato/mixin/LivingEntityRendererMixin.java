package com.teampotato.whoisthepotato.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {
    @Inject(
            at = @At("HEAD"),
            method = "shouldShowName(Lnet/minecraft/world/entity/LivingEntity;)Z",
            cancellable = true
    )
    private void viewOwnLabel(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> ci) {
        if (livingEntity == Minecraft.getInstance().cameraEntity) ci.setReturnValue(Minecraft.renderNames());
    }
}
