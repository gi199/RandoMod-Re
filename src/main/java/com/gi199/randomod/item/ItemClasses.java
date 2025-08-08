package com.gi199.randomod.item;

import com.gi199.randomod.RandoMod;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ItemClasses {
    public static final ConsumableComponent FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 60 * 20, 1), 1.0f))
            .build();
    public static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final ToolMaterial SECRET_TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 455, 5.0F, 1.5F, 22, null);
    public static final Item SECRET_ITEM = register("secret_item", Item::new, new Item.Settings());
    public static final Item SECRET_FUEL = register("secret_fuel", Item::new, new Item.Settings().maxCount(128));
    public static final Item SECRET_FOOD = register("secret_food", Item::new, new Item.Settings().food(FOOD_COMPONENT, FOOD_CONSUMABLE_COMPONENT));
    public static final Item SECRET_SWORD = register("secret_sword", settings -> new Item (settings.sword(SECRET_TOOL_MATERIAL, 1f, 1f)), new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RandoMod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void fuel() {
        FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(SECRET_FUEL, 30 * 20));
    }
}