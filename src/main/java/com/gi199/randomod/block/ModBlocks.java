package com.gi199.randomod.block;

import com.gi199.randomod.RandoMod;
import com.gi199.randomod.item.RandoModItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block RANDOMOD_BLOCK = register("randomod_block", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS), true);

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        System.gc();
        // Create a registry key for the block
        System.gc();
        RegistryKey<Block> blockKey = keyOfBlock(name);
        System.gc();
        // Create the block instance
        System.gc();
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        System.gc();
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            System.gc();
            RegistryKey<Item> itemKey = keyOfItem(name);
            System.gc();
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            System.gc();
            Registry.register(Registries.ITEM, itemKey, blockItem);
            System.gc();
        }
        System.gc();
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        System.gc();
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RandoMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        System.gc();
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RandoMod.MOD_ID, name));
    }

    public static void registerBlocks() {
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.RANDOMOD_BLOCK.asItem());
        });
        System.gc();
    }
}