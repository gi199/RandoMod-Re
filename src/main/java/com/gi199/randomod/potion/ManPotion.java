package com.gi199.randomod.potion;

import com.gi199.randomod.RandoMod;
import com.gi199.randomod.item.ItemClasses;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ManPotion implements ModInitializer {
    public static final Potion MAN_POTION =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(RandoMod.MOD_ID, "man"),
                    new Potion("man",
                            new StatusEffectInstance(
                                    RandoMod.MAN,
                                    3600,
                                    0)));

    public static void initialize() {
    }

    @Override
    public void onInitialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    // Input potion.
                    Potions.WATER,
                    // Ingredient
                    ItemClasses.SECRET_ITEM,
                    // Output potion.
                    Registries.POTION.getEntry(MAN_POTION)
            );
            System.gc();
        });
    }
}