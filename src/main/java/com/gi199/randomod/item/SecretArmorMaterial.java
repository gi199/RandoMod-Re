package com.gi199.randomod.item;

import com.gi199.randomod.RandoMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static com.gi199.randomod.item.ItemClasses.register;

public class SecretArmorMaterial {
    public static final int BASE_DURABILITY = 15;
    public static final RegistryKey<EquipmentAsset> SECRET_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(RandoMod.MOD_ID, "secret"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            null,
            SECRET_ARMOR_MATERIAL_KEY
    );
    public static final Item SECRET_HELMET = register("secret_helmet", settings -> new Item(settings.armor(SecretArmorMaterial.INSTANCE, EquipmentType.HELMET).maxDamage(SecretArmorMaterial.BASE_DURABILITY)),new Item.Settings());
    public static final Item SECRET_CHESTPLATE = register("secret_chestplate", settings -> new Item(settings.armor(SecretArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE).maxDamage(SecretArmorMaterial.BASE_DURABILITY)), new Item.Settings());
    public static final Item SECRET_LEGGINGS = register("secret_leggings", settings -> new Item(settings.armor(SecretArmorMaterial.INSTANCE, EquipmentType.LEGGINGS).maxDamage(SecretArmorMaterial.BASE_DURABILITY)), new Item.Settings());
    public static final Item SECRET_BOOTS = register("secret_boots", settings -> new Item(settings.armor(SecretArmorMaterial.INSTANCE, EquipmentType.BOOTS).maxDamage(SecretArmorMaterial.BASE_DURABILITY)), new Item.Settings());
    public static void registerSecretArmor() {
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(SecretArmorMaterial.SECRET_BOOTS));
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(SecretArmorMaterial.SECRET_CHESTPLATE));
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(SecretArmorMaterial.SECRET_HELMET));
        ItemGroupEvents.modifyEntriesEvent(RandoModItemGroup.RANDOMOD_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(SecretArmorMaterial.SECRET_LEGGINGS));
    }
}
