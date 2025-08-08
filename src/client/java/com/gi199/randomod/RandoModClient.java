package com.gi199.randomod;

import com.gi199.randomod.render.SimpleGUI;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class RandoModClient implements ClientModInitializer {
   @Override
   public void onInitializeClient() {
       // 使用延迟任务来确保客户端完全初始化
       MinecraftClient client = MinecraftClient.getInstance();
       client.execute(() -> {
           if (client.player != null) {
               client.setScreen(new SimpleGUI(Text.empty()));
           }
       });
   }
}