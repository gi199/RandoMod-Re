package com.gi199.randomod.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class SimpleGUI extends Screen {
    public SimpleGUI(Text title) {super(title);}
    @Override
    protected void init() {
        ButtonWidget buttonWidget = ButtonWidget.builder(Text.of("Hello World"), (btn) -> {
            // 使用 MinecraftClient.getInstance() 获取实例
            if (this.client != null) {
                // 显示 Toast
                this.client.getToastManager().add(
                    SystemToast.create(this.client, SystemToast.Type.NARRATOR_TOGGLE,
                        Text.of("Hello World!"), Text.of("This is a toast."))
                );

                // 直接关闭屏幕，让 Minecraft 自己处理鼠标状态
                this.close();
            }
        }).dimensions(40, 40, 120, 20).build();

        this.addDrawableChild(buttonWidget);
    }

    @Override
    public void close() {
        // 让父类处理关闭逻辑
        super.close();
        if (this.client != null) {
            this.client.setScreen(null);
        }
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // Minecraft doesn't have a "label" widget, so we'll have to draw our own text.
        // We'll subtract the font height from the Y position to make the text appear above the button.
        // Subtracting an extra 10 pixels will give the text some padding.
        // textRenderer, text, x, y, color, hasShadow
        context.drawText(this.textRenderer, "Special Button", 40, 40 - this.textRenderer.fontHeight - 10, 0xFFFFFFFF, true);
    }
}