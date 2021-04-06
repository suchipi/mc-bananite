package com.suchipi.bananite;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BananiteMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BananiteMod.MODID);

    public static void init() {
        // attach DeferredRegisters to the event bus
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // register block
    public static final RegistryObject<Block> BANANITE = BLOCKS.register("bananite", () ->
        new Block(
            Block.Properties
                .create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        )
    );

    public static final RegistryObject<Item> BANANITE_ITEM = ITEMS.register("bananite", () ->
            new BlockItem(
                    BANANITE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    // register item
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () ->
        new Item(new Item.Properties().group(ItemGroup.FOOD).food(
            new Food.Builder().saturation(1).hunger(1).build()
        ))
    );
}
