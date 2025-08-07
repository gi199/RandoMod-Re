package com.gi199.randomod;

import com.gi199.randomod.block.ModBlocks;
import com.gi199.randomod.effect.ManEffect;
import com.gi199.randomod.item.ItemClasses;
import com.gi199.randomod.item.RandoModItemGroup;
import com.gi199.randomod.item.SecretArmorMaterial;
import com.gi199.randomod.potion.ManPotion;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandoMod implements ModInitializer {
    public static final String MOD_ID = "randomod";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    //
    public static final RegistryEntry<StatusEffect> MAN = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "man"), new ManEffect());

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");
        ItemClasses.fuel();
        //
        Registry.register(Registries.ITEM_GROUP, RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY, RandoModItemGroup.RANDOMOD_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(ItemClasses.SECRET_ITEM));
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(ItemClasses.SECRET_FUEL));
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(ItemClasses.SECRET_FOOD));
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(ItemClasses.SECRET_SWORD));
        //
        SecretArmorMaterial.registerSecretArmor();
        ModBlocks.registerBlocks();
        System.gc();
        ManPotion.initialize();
        System.gc();
    }
}