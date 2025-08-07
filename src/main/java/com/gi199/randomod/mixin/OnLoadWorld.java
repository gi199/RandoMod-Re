package com.gi199.randomod.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class OnLoadWorld {
    @Shadow
    public abstract boolean isLoading();

    @Inject(at = @At("HEAD"), method = "loadWorld")
    private void init(CallbackInfo info) {
        // This code is sideload to MinecraftServer's loadWorld method
        System.gc();
        Runtime.getRuntime().gc();
        System.out.print(isLoading());
    }
}