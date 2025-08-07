package com.gi199.randomod.item;

import com.gi199.randomod.RandoMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RandoModItemGroup {
    public static final RegistryKey<ItemGroup> RANDOMOD_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(RandoMod.MOD_ID, "randomod_item_group"));
    public static final ItemGroup RANDOMOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ItemClasses.SECRET_ITEM))
            .displayName(Text.translatable("itemGroup.randomod"))
            .build();

}
