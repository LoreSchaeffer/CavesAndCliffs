package it.multicoredev.cnc.init;

import it.multicoredev.cnc.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.minecraft.item.ItemGroup.*;

/**
 * Copyright © 2021 by Lorenzo Magni
 * This file is part of Caves&Cliffs.
 * Caves&Cliffs is under "The 3-Clause BSD License", you can find a copy <a href="https://opensource.org/licenses/BSD-3-Clause">here</a>.
 * <p>
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
public class ModItems {
    public static List<Item> ITEMS = new ArrayList<>();

    public static final Item AMETHYST_SHARD = new ItemBase("amethyst_shard", MISC);
    public static final Item AXOLOTL_BUCKET = new ItemBase("axolotl_bucket", MISC);
    public static final Item BUNDLE = new ItemBase("bundle", TOOLS);
    public static final Item COPPER_INGOT = new ItemBase("copper_ingot", MISC);
    public static final Item GLOW_BERRIES = new ItemBase("glow_berries", FOOD);
    public static final Item GLOW_INK_SAC = new ItemBase("glow_ink_sac", MISC);
    public static final Item GLOW_ITEM_FRAME = new ItemBase("glow_item_frame", DECORATIONS);
    public static final Item POINTED_DRIPSTONE = new ItemBase("pointed_dripstone", DECORATIONS);
    public static final Item POWDER_SNOW_BUCKET = new ItemBase("powder_snow_bucket", MISC);
    public static final Item SPYGLASS = new ItemBase("spyglass", TOOLS);

    public static final Item AMETHYST_BLOCK = registerBlockItem(ModBlocks.AMETHYST_BLOCK, BUILDING_BLOCKS);
    public static final Item AMETHYST_CLUSTER = registerBlockItem(ModBlocks.AMETHYST_CLUSTER, DECORATIONS);
    public static final Item AZALEA_LEAVES = registerBlockItem(ModBlocks.AZALEA_LEAVES, DECORATIONS);
    public static final Item AZALEA_LEAVES_FLOWERS = registerBlockItem(ModBlocks.AZALEA_LEAVES_FLOWERS, DECORATIONS);
    //AZALEA_PLANT
    //BIG_DRIPLEAF
    public static final Item BLACK_CANDLE = registerBlockItem(ModBlocks.BLACK_CANDLE, DECORATIONS);
    public static final Item BLUE_CANDLE = registerBlockItem(ModBlocks.BLUE_CANDLE, DECORATIONS);
    public static final Item BROWN_CANDLE = registerBlockItem(ModBlocks.BROWN_CANDLE, DECORATIONS);
    public static final Item BUDDING_AMETHYST = registerBlockItem(ModBlocks.BUDDING_AMETHYST, BUILDING_BLOCKS);
    public static final Item CALCITE = registerBlockItem(ModBlocks.CALCITE, BUILDING_BLOCKS);
    public static final Item CALCITE_SLAB = registerBlockItem(ModBlocks.CALCITE_SLAB, BUILDING_BLOCKS);
    public static final Item CALCITE_STAIRS = registerBlockItem(ModBlocks.CALCITE_STAIRS, BUILDING_BLOCKS);
    public static final Item CALCITE_WALL = registerBlockItem(ModBlocks.CALCITE_WALL, BUILDING_BLOCKS);
    public static final Item CANDLE = registerBlockItem(ModBlocks.CANDLE, DECORATIONS);
    public static final Item CYAN_CANDLE = registerBlockItem(ModBlocks.CYAN_CANDLE, DECORATIONS);
    public static final Item DRIPSTONE_BLOCK = registerBlockItem(ModBlocks.DRIPSTONE_BLOCK, BUILDING_BLOCKS);
    //FLOWERING_AZALEA
    public static final Item GLOW_LICHEN = registerBlockItem(ModBlocks.GLOW_LICHEN, DECORATIONS);
    public static final Item GRAY_CANDLE = registerBlockItem(ModBlocks.GRAY_CANDLE, DECORATIONS);
    public static final Item GREEN_CANDLE = registerBlockItem(ModBlocks.GREEN_CANDLE, DECORATIONS);
    //HANGING_ROOTS
    public static final Item LARGE_AMETHYST_BUD = registerBlockItem(ModBlocks.LARGE_AMETHYST_BUD, DECORATIONS);
    public static final Item LIGHT_BLUE_CANDLE = registerBlockItem(ModBlocks.LIGHT_BLUE_CANDLE, DECORATIONS);
    public static final Item LIGHT_GRAY_CANDLE = registerBlockItem(ModBlocks.LIGHT_GRAY_CANDLE, DECORATIONS);
    public static final Item LIGHTNING_ROD = registerBlockItem(ModBlocks.LIGHTNING_ROD, REDSTONE);
    public static final Item LIME_CANDLE = registerBlockItem(ModBlocks.LIME_CANDLE, DECORATIONS);
    public static final Item MAGENTA_CANDLE = registerBlockItem(ModBlocks.MAGENTA_CANDLE, DECORATIONS);
    public static final Item MEDIUM_AMETHYST_BUD = registerBlockItem(ModBlocks.MEDIUM_AMETHYST_BUD, DECORATIONS);
    public static final Item MOSS_BLOCK = registerBlockItem(ModBlocks.MOSS_BLOCK, BUILDING_BLOCKS);
    public static final Item ORANGE_CANDLE = registerBlockItem(ModBlocks.ORANGE_CANDLE, DECORATIONS);
    public static final Item PINK_CANDLE = registerBlockItem(ModBlocks.PINK_CANDLE, DECORATIONS);
    public static final Item PURPLE_CANDLE = registerBlockItem(ModBlocks.PURPLE_CANDLE, DECORATIONS);
    public static final Item RED_CANDLE = registerBlockItem(ModBlocks.RED_CANDLE, DECORATIONS);
    public static final Item ROOTED_DIRT = registerBlockItem(ModBlocks.ROOTED_DIRT, BUILDING_BLOCKS);
    //SCULK_SENSOR
    public static final Item SMALL_AMETHYST_BUD = registerBlockItem(ModBlocks.SMALL_AMETHYST_BUD, DECORATIONS);
    //SMALL_DRIPLEAF
    //SPORE_BLOSSOM
    public static final Item TINTED_GLASS = registerBlockItem(ModBlocks.TINTED_GLASS, BUILDING_BLOCKS);
    public static final Item TUFF = registerBlockItem(ModBlocks.TUFF, BUILDING_BLOCKS);
    public static final Item TUFF_SLAB = registerBlockItem(ModBlocks.TUFF_SLAB, BUILDING_BLOCKS);
    public static final Item TUFF_STAIRS = registerBlockItem(ModBlocks.TUFF_STAIRS, BUILDING_BLOCKS);
    public static final Item TUFF_WALL = registerBlockItem(ModBlocks.TUFF_WALL, BUILDING_BLOCKS);
    public static final Item WHITE_CANDLE = registerBlockItem(ModBlocks.WHITE_CANDLE, DECORATIONS);
    public static final Item YELLOW_CANDLE = registerBlockItem(ModBlocks.YELLOW_CANDLE, DECORATIONS);

    public static final Item COPPER_ORE = registerBlockItem(ModBlocks.COPPER_ORE, BUILDING_BLOCKS);
    
    public static final Item COPPER_BLOCK = registerBlockItem(ModBlocks.COPPER_BLOCK, BUILDING_BLOCKS);
    public static final Item EXPOSED_COPPER = registerBlockItem(ModBlocks.EXPOSED_COPPER, BUILDING_BLOCKS);
    public static final Item WEATHERED_COPPER = registerBlockItem(ModBlocks.WEATHERED_COPPER, BUILDING_BLOCKS);
    public static final Item OXIDIZED_COPPER = registerBlockItem(ModBlocks.OXIDIZED_COPPER, BUILDING_BLOCKS);

    public static final Item CUT_COPPER = registerBlockItem(ModBlocks.CUT_COPPER, BUILDING_BLOCKS);
    public static final Item EXPOSED_CUT_COPPER = registerBlockItem(ModBlocks.EXPOSED_CUT_COPPER, BUILDING_BLOCKS);
    public static final Item WEATHERED_CUT_COPPER = registerBlockItem(ModBlocks.WEATHERED_CUT_COPPER, BUILDING_BLOCKS);
    public static final Item OXIDIZED_CUT_COPPER = registerBlockItem(ModBlocks.OXIDIZED_CUT_COPPER, BUILDING_BLOCKS);

    public static final Item WAXED_COPPER = registerBlockItem(ModBlocks.WAXED_COPPER, BUILDING_BLOCKS);
    public static final Item WAXED_EXPOSED_COPPER = registerBlockItem(ModBlocks.WAXED_EXPOSED_COPPER, BUILDING_BLOCKS);
    public static final Item WAXED_WEATHERED_COPPER = registerBlockItem(ModBlocks.WAXED_WEATHERED_COPPER, BUILDING_BLOCKS);

    public static final Item WAXED_CUT_COPPER = registerBlockItem(ModBlocks.WAXED_CUT_COPPER, BUILDING_BLOCKS);
    public static final Item WAXED_EXPOSED_CUT_COPPER = registerBlockItem(ModBlocks.WAXED_EXPOSED_CUT_COPPER, BUILDING_BLOCKS);
    public static final Item WAXED_WEATHERED_CUT_COPPER = registerBlockItem(ModBlocks.WAXED_WEATHERED_CUT_COPPER, BUILDING_BLOCKS);

    public static final Item CUT_COPPER_STAIRS = registerBlockItem(ModBlocks.CUT_COPPER_STAIRS, BUILDING_BLOCKS);
    public static final Item EXPOSED_CUT_COPPER_STAIRS = registerBlockItem(ModBlocks.EXPOSED_CUT_COPPER_STAIRS, BUILDING_BLOCKS);
    public static final Item WEATHERED_CUT_COPPER_STAIRS = registerBlockItem(ModBlocks.WEATHERED_CUT_COPPER_STAIRS, BUILDING_BLOCKS);
    public static final Item OXIDIZED_CUT_COPPER_STAIRS = registerBlockItem(ModBlocks.OXIDIZED_CUT_COPPER_STAIRS, BUILDING_BLOCKS);
    
    public static final Item CUT_COPPER_SLAB = registerBlockItem(ModBlocks.CUT_COPPER_SLAB, BUILDING_BLOCKS);
    public static final Item EXPOSED_CUT_COPPER_SLAB = registerBlockItem(ModBlocks.EXPOSED_CUT_COPPER_SLAB, BUILDING_BLOCKS);
    public static final Item WEATHERED_CUT_COPPER_SLAB = registerBlockItem(ModBlocks.WEATHERED_CUT_COPPER_SLAB, BUILDING_BLOCKS);
    public static final Item OXIDIZED_CUT_COPPER_SLAB = registerBlockItem(ModBlocks.OXIDIZED_CUT_COPPER_SLAB, BUILDING_BLOCKS);
    
    public static final Item WAXED_CUT_COPPER_SLAB = registerBlockItem(ModBlocks.WAXED_CUT_COPPER_SLAB, BUILDING_BLOCKS);
    public static final Item WAXED_EXPOSED_CUT_COPPER_SLAB = registerBlockItem(ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB, BUILDING_BLOCKS);
    public static final Item WAXED_WEATHERED_CUT_COPPER_SLAB = registerBlockItem(ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB, BUILDING_BLOCKS);

    public static final Item WAXED_CUT_COPPER_STAIRS = registerBlockItem(ModBlocks.WAXED_CUT_COPPER_STAIRS, BUILDING_BLOCKS);
    public static final Item WAXED_EXPOSED_CUT_COPPER_STAIRS = registerBlockItem(ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS, BUILDING_BLOCKS);
    public static final Item WAXED_WEATHERED_CUT_COPPER_STAIRS = registerBlockItem(ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, BUILDING_BLOCKS);

    static {
        ITEMS.addAll(Arrays.asList(
                CALCITE,
                TUFF,
                CALCITE_SLAB,
                TUFF_SLAB,
                CALCITE_STAIRS,
                TUFF_STAIRS,
                CALCITE_WALL,
                TUFF_WALL,
                COPPER_ORE,
                TINTED_GLASS,
                AMETHYST_BLOCK,
                BUDDING_AMETHYST,
                COPPER_BLOCK,
                EXPOSED_COPPER,
                WEATHERED_COPPER,
                OXIDIZED_COPPER,
                CUT_COPPER,
                EXPOSED_CUT_COPPER,
                WEATHERED_CUT_COPPER,
                OXIDIZED_CUT_COPPER,
                CUT_COPPER_STAIRS,
                EXPOSED_CUT_COPPER_STAIRS,
                WEATHERED_CUT_COPPER_STAIRS,
                OXIDIZED_CUT_COPPER_STAIRS,
                CUT_COPPER_SLAB,
                EXPOSED_CUT_COPPER_SLAB,
                WEATHERED_CUT_COPPER_SLAB,
                OXIDIZED_CUT_COPPER_SLAB,
                WAXED_EXPOSED_CUT_COPPER_SLAB,
                WAXED_COPPER,
                WAXED_EXPOSED_COPPER,
                WAXED_WEATHERED_COPPER,
                WAXED_CUT_COPPER,
                WAXED_EXPOSED_CUT_COPPER,
                WAXED_WEATHERED_CUT_COPPER,
                WAXED_CUT_COPPER_STAIRS,
                WAXED_EXPOSED_CUT_COPPER_STAIRS,
                WAXED_WEATHERED_CUT_COPPER_STAIRS,
                WAXED_CUT_COPPER_SLAB,
                WAXED_EXPOSED_CUT_COPPER_SLAB,
                WAXED_WEATHERED_CUT_COPPER_SLAB,
                DRIPSTONE_BLOCK,

                AZALEA_LEAVES,
                AZALEA_LEAVES_FLOWERS,
                //AZALEA,
                //FLOWERING_AZALEA
                //SPORE_BLOSSOM
                //MOSS_CARPET
                MOSS_BLOCK,
                ROOTED_DIRT,
                GLOW_LICHEN,
                //HANGING_ROOTS
                //BIF_DRIPLEAF
                //SMALL_DRIPLEAF
                GLOW_ITEM_FRAME,
                CANDLE,
                WHITE_CANDLE,
                ORANGE_CANDLE,
                MAGENTA_CANDLE,
                LIGHT_BLUE_CANDLE,
                YELLOW_CANDLE,
                LIME_CANDLE,
                PINK_CANDLE,
                GRAY_CANDLE,
                LIGHT_GRAY_CANDLE,
                CYAN_CANDLE,
                PURPLE_CANDLE,
                BLUE_CANDLE,
                BROWN_CANDLE,
                GREEN_CANDLE,
                RED_CANDLE,
                BLACK_CANDLE,
                SMALL_AMETHYST_BUD,
                MEDIUM_AMETHYST_BUD,
                LARGE_AMETHYST_BUD,
                AMETHYST_CLUSTER,
                POINTED_DRIPSTONE,

                LIGHTNING_ROD,
                //SCULK_SENSOR

                COPPER_INGOT,
                AXOLOTL_BUCKET,
                AMETHYST_SHARD,
                POWDER_SNOW_BUCKET,
                GLOW_INK_SAC,

                GLOW_BERRIES,

                BUNDLE,
                SPYGLASS
        ));
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Item item : ITEMS) {
            event.getRegistry().register(item);
        }
    }

    private static Item registerBlockItem(Block block, ItemGroup group) {
        Item item = new BlockItem(block, new Item.Properties().group(group).maxStackSize(64));
        item.setRegistryName(block.getRegistryName());
        return item;
    }
}
