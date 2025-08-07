package com.gi199.randomod;

import com.gi199.randomod.render.SimpleGUI;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class RandoModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        MinecraftClient.getInstance().setScreen(
                new SimpleGUI(Text.empty())
        );

    }
}