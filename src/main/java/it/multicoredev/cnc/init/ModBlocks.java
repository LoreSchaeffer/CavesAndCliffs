package it.multicoredev.cnc.init;

import it.multicoredev.cnc.blocks.*;
import it.multicoredev.cnc.blocks.copper.CopperBlock;
import it.multicoredev.cnc.blocks.copper.CopperSlab;
import it.multicoredev.cnc.blocks.copper.CopperStairs;
import it.multicoredev.cnc.blocks.copper.WeatheringCopper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.DyeColor;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.minecraft.block.material.Material.*;
import static net.minecraftforge.common.ToolType.*;

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
public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block AMETHYST_BLOCK = new BlockBase("amethyst_block", AbstractBlock.Properties.create(ROCK, DyeColor.PURPLE).hardnessAndResistance(1.5f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(2));
    public static final Block AMETHYST_CLUSTER = new BlockBase("amethyst_cluster", AbstractBlock.Properties.from(AMETHYST_BLOCK));
    public static final Block AZALEA_LEAVES = new ModLeaves("azalea_leaves");
    public static final Block AZALEA_LEAVES_FLOWERS = new ModLeaves("azalea_leaves_flowers");
    //AZALEA_PLANT
    //BIG_DRIPLEAF
    public static final Block BLACK_CANDLE = new CandleBlock("black_candle", DyeColor.BLACK);
    public static final Block BLUE_CANDLE = new CandleBlock("blue_candle", DyeColor.BLUE);
    public static final Block BROWN_CANDLE = new CandleBlock("brown_candle", DyeColor.BROWN);
    public static final Block BUDDING_AMETHYST = new BlockBase("budding_amethyst", AbstractBlock.Properties.from(AMETHYST_BLOCK).noDrops());
    public static final Block CALCITE = new BlockBase("calcite", AbstractBlock.Properties.create(ROCK, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.75f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(0));
    public static final Block CALCITE_SLAB = new SlabBase("calcite_slab", AbstractBlock.Properties.from(CALCITE));
    public static final Block CALCITE_STAIRS = new StairsBase("calcite_stairs", CALCITE, AbstractBlock.Properties.from(CALCITE));
    public static final Block CALCITE_WALL = new WallBase("calcite_wall", AbstractBlock.Properties.from(CALCITE));
    public static final Block CANDLE = new CandleBlock("candle", MaterialColor.SAND);
    //CAVE VINES
    public static final Block COPPER_ORE = new BlockBase("copper_ore", AbstractBlock.Properties.create(ROCK, MaterialColor.STONE).hardnessAndResistance(3.0f, 3.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1));
    public static final Block CYAN_CANDLE = new CandleBlock("cyan_candle", DyeColor.CYAN);
    public static final Block DRIPSTONE_BLOCK = new BlockBase("dripstone_block", AbstractBlock.Properties.create(ROCK, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(1.5f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(0));
    //FLOWERING_AZALEA
    public static final Block GLOW_LICHEN = new BlockBase("glow_lichen", AbstractBlock.Properties.create(TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0.2F).sound(SoundType.VINE));
    public static final Block GRAY_CANDLE = new CandleBlock("gray_candle", DyeColor.GRAY);
    public static final Block GREEN_CANDLE = new CandleBlock("green_candle", DyeColor.GREEN);
    //HANGING_ROOT
    public static final Block LARGE_AMETHYST_BUD = new BlockBase("large_amethyst_bud", AbstractBlock.Properties.from(AMETHYST_BLOCK));
    public static final Block LIGHT_BLUE_CANDLE = new CandleBlock("light_blue_candle", DyeColor.LIGHT_BLUE);
    public static final Block LIGHT_GRAY_CANDLE = new CandleBlock("light_gray_candle", DyeColor.LIGHT_GRAY);
    public static final Block LIGHTNING_ROD = new BlockBase("lightning_rod", AbstractBlock.Properties.create(IRON, DyeColor.ORANGE).hardnessAndResistance(3.0f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1));
    public static final Block LIME_CANDLE = new CandleBlock("lime_candle", DyeColor.LIME);
    public static final Block MAGENTA_CANDLE = new CandleBlock("magenta_candle", DyeColor.MAGENTA);
    public static final Block MEDIUM_AMETHYST_BUD = new BlockBase("medium_amethyst_bud", AbstractBlock.Properties.from(AMETHYST_BLOCK));
    public static final Block MOSS_BLOCK = new BlockBase("moss_block", AbstractBlock.Properties.create(PLANTS, DyeColor.GREEN).hardnessAndResistance(0.1f).harvestTool(AXE).harvestLevel(0));
    public static final Block ORANGE_CANDLE = new CandleBlock("orange_candle", DyeColor.ORANGE);
    public static final Block PINK_CANDLE = new CandleBlock("pink_candle", DyeColor.PINK);
    //POINTED_DRIPSTONE
    public static final Block POWDER_SNOW = new BlockBase("powder_snow", AbstractBlock.Properties.create(SNOW_BLOCK, MaterialColor.SNOW).hardnessAndResistance(0.1f).harvestTool(SHOVEL).noDrops());
    public static final Block PURPLE_CANDLE = new CandleBlock("purple_candle", DyeColor.PURPLE);
    public static final Block RED_CANDLE = new CandleBlock("red_candle", DyeColor.RED);
    //ROOT_VINES
    public static final Block ROOTED_DIRT = new BlockBase("rooted_dirt", AbstractBlock.Properties.create(EARTH, MaterialColor.DIRT).hardnessAndResistance(0.1F).sound(SoundType.GROUND));
    //SCULK_SENSOR
    public static final Block SMALL_AMETHYST_BUD = new BlockBase("small_amethyst_bud", AbstractBlock.Properties.from(AMETHYST_BLOCK));
    //SMALL_DRIPLEAF
    //SPORE_BLOSSOM
    public static final Block TINTED_GLASS = new BlockBase("tinted_glass", AbstractBlock.Properties.create(GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn((state, reader, pos, entity) -> false).setOpaque((state, reader, pos) -> false).setSuffocates((state, reader, pos) -> false).setBlocksVision((state, reader, pos) -> false));
    public static final Block TUFF = new BlockBase("tuff", AbstractBlock.Properties.create(ROCK, MaterialColor.GRAY_TERRACOTTA).hardnessAndResistance(1.5f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(0));
    public static final Block TUFF_SLAB = new SlabBase("tuff_slab", Block.Properties.from(TUFF));
    public static final Block TUFF_STAIRS = new StairsBase("tuff_stairs", TUFF, Block.Properties.from(TUFF));
    public static final Block TUFF_WALL = new WallBase("tuff_wall", Block.Properties.from(TUFF));

    public static final Block WHITE_CANDLE = new CandleBlock("white_candle", MaterialColor.WOOL);
    public static final Block YELLOW_CANDLE = new CandleBlock("yellow_candle", DyeColor.YELLOW);

    public static final Block OXIDIZED_COPPER = new CopperBlock("oxidized_copper", MaterialColor.WARPED_NYLIUM);
    public static final Block WEATHERED_COPPER = new CopperBlock("weathered_copper", MaterialColor.WARPED_STEM, WeatheringCopper.WeatherState.WEATHERED, OXIDIZED_COPPER);
    public static final Block EXPOSED_COPPER = new CopperBlock("exposed_copper", MaterialColor.LIGHT_GRAY_TERRACOTTA, WeatheringCopper.WeatherState.EXPOSED, WEATHERED_COPPER);
    public static final Block COPPER_BLOCK = new CopperBlock("copper_block", DyeColor.ORANGE, WeatheringCopper.WeatherState.UNAFFECTED, EXPOSED_COPPER);

    public static final Block OXIDIZED_CUT_COPPER = new CopperBlock("oxidized_cut_copper", MaterialColor.WARPED_NYLIUM);
    public static final Block WEATHERED_CUT_COPPER = new CopperBlock("weathered_cut_copper", MaterialColor.WARPED_STEM, WeatheringCopper.WeatherState.WEATHERED, OXIDIZED_CUT_COPPER);
    public static final Block EXPOSED_CUT_COPPER = new CopperBlock("exposed_cut_copper", MaterialColor.LIGHT_GRAY_TERRACOTTA, WeatheringCopper.WeatherState.EXPOSED, WEATHERED_CUT_COPPER);
    public static final Block CUT_COPPER = new CopperBlock("cut_copper", DyeColor.ORANGE, WeatheringCopper.WeatherState.UNAFFECTED, EXPOSED_CUT_COPPER);

    public static final Block OXIDIZED_CUT_COPPER_SLAB = new CopperSlab("oxidized_cut_copper_slab", MaterialColor.WARPED_NYLIUM);
    public static final Block WEATHERED_CUT_COPPER_SLAB = new CopperSlab("weathered_cut_copper_slab", MaterialColor.WARPED_STEM, WeatheringCopper.WeatherState.WEATHERED, OXIDIZED_CUT_COPPER_SLAB);
    public static final Block EXPOSED_CUT_COPPER_SLAB = new CopperSlab("exposed_cut_copper_slab", MaterialColor.LIGHT_GRAY_TERRACOTTA, WeatheringCopper.WeatherState.EXPOSED, WEATHERED_CUT_COPPER_SLAB);
    public static final Block CUT_COPPER_SLAB = new CopperSlab("cut_copper_slab", DyeColor.ORANGE, WeatheringCopper.WeatherState.UNAFFECTED, EXPOSED_CUT_COPPER_SLAB);

    public static final Block OXIDIZED_CUT_COPPER_STAIRS = new CopperStairs("oxidized_cut_copper_stairs", OXIDIZED_CUT_COPPER, MaterialColor.WARPED_NYLIUM);
    public static final Block WEATHERED_CUT_COPPER_STAIRS = new CopperStairs("weathered_cut_copper_stairs", WEATHERED_CUT_COPPER, MaterialColor.WARPED_STEM, WeatheringCopper.WeatherState.WEATHERED, OXIDIZED_CUT_COPPER_STAIRS);
    public static final Block EXPOSED_CUT_COPPER_STAIRS = new CopperStairs("exposed_cut_copper_stairs", EXPOSED_CUT_COPPER, MaterialColor.LIGHT_GRAY_TERRACOTTA, WeatheringCopper.WeatherState.EXPOSED, WEATHERED_CUT_COPPER_STAIRS);
    public static final Block CUT_COPPER_STAIRS = new CopperStairs("cut_copper_stairs", CUT_COPPER, DyeColor.ORANGE, WeatheringCopper.WeatherState.UNAFFECTED, EXPOSED_CUT_COPPER_STAIRS);

    public static final Block WAXED_COPPER = new BlockBase("waxed_copper_block", AbstractBlock.Properties.create(IRON, DyeColor.ORANGE).hardnessAndResistance(3.0f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1));
    public static final Block WAXED_EXPOSED_COPPER = new BlockBase("waxed_exposed_copper", AbstractBlock.Properties.create(IRON, MaterialColor.LIGHT_GRAY_TERRACOTTA).hardnessAndResistance(3.0f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1));
    public static final Block WAXED_WEATHERED_COPPER = new BlockBase("waxed_weathered_copper", AbstractBlock.Properties.create(IRON, MaterialColor.WARPED_STEM).hardnessAndResistance(3.0f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1));

    public static final Block WAXED_CUT_COPPER = new BlockBase("waxed_cut_copper", AbstractBlock.Properties.from(WAXED_COPPER));
    public static final Block WAXED_EXPOSED_CUT_COPPER = new BlockBase("waxed_exposed_cut_copper", AbstractBlock.Properties.from(WAXED_EXPOSED_COPPER));
    public static final Block WAXED_WEATHERED_CUT_COPPER = new BlockBase("waxed_weathered_cut_copper", AbstractBlock.Properties.from(WAXED_WEATHERED_COPPER));

    public static final Block WAXED_CUT_COPPER_SLAB = new SlabBase("waxed_cut_copper_slab", AbstractBlock.Properties.from(WAXED_COPPER));
    public static final Block WAXED_EXPOSED_CUT_COPPER_SLAB = new SlabBase("waxed_exposed_cut_copper_slab", AbstractBlock.Properties.from(WAXED_EXPOSED_COPPER));
    public static final Block WAXED_WEATHERED_CUT_COPPER_SLAB = new SlabBase("waxed_weathered_cut_copper_slab", AbstractBlock.Properties.from(WAXED_WEATHERED_COPPER));

    public static final Block WAXED_CUT_COPPER_STAIRS = new StairsBase("waxed_cut_copper_stairs", WAXED_CUT_COPPER, AbstractBlock.Properties.from(WAXED_COPPER));
    public static final Block WAXED_EXPOSED_CUT_COPPER_STAIRS = new StairsBase("waxed_exposed_cut_copper_stairs", WAXED_EXPOSED_CUT_COPPER, AbstractBlock.Properties.from(WAXED_EXPOSED_COPPER));
    public static final Block WAXED_WEATHERED_CUT_COPPER_STAIRS = new StairsBase("waxed_weathered_cut_copper_stairs", WAXED_WEATHERED_CUT_COPPER, AbstractBlock.Properties.from(WAXED_WEATHERED_COPPER));

    static {
        BLOCKS.addAll(Arrays.asList(
                AMETHYST_BLOCK,
                AMETHYST_CLUSTER,
                AZALEA_LEAVES,
                AZALEA_LEAVES_FLOWERS,
                //AZALEA_PLANT
                //BIG_DRIPLEAF
                BLACK_CANDLE,
                BLUE_CANDLE,
                BROWN_CANDLE,
                BUDDING_AMETHYST,
                CALCITE,
                CALCITE_SLAB,
                CALCITE_STAIRS,
                CALCITE_WALL,
                CANDLE,
                //CAVE VINES
                COPPER_ORE,
                CYAN_CANDLE,
                DRIPSTONE_BLOCK,
                //FLOWERING_AZALEA
                GLOW_LICHEN,
                GRAY_CANDLE,
                GREEN_CANDLE,
                //HANGING_ROOT
                LARGE_AMETHYST_BUD,
                LIGHT_BLUE_CANDLE,
                LIGHT_GRAY_CANDLE,
                LIGHTNING_ROD,
                LIME_CANDLE,
                MAGENTA_CANDLE,
                MEDIUM_AMETHYST_BUD,
                MOSS_BLOCK,
                ORANGE_CANDLE,
                PINK_CANDLE,
                //POINTED_DRIPSTONE
                POWDER_SNOW,
                PURPLE_CANDLE,
                RED_CANDLE,
                //ROOT_VINES
                ROOTED_DIRT,
                //SCULK_SENSOR
                SMALL_AMETHYST_BUD,
                //SMALL_DRIPLEAF
                //SPORE_BLOSSOM
                TINTED_GLASS,
                TUFF,
                TUFF_SLAB,
                TUFF_STAIRS,
                TUFF_WALL,
                WHITE_CANDLE,
                YELLOW_CANDLE,

                WAXED_COPPER,
                WAXED_EXPOSED_COPPER,
                WAXED_WEATHERED_COPPER,

                WAXED_CUT_COPPER,
                WAXED_EXPOSED_CUT_COPPER,
                WAXED_WEATHERED_CUT_COPPER,

                WAXED_CUT_COPPER_SLAB,
                WAXED_EXPOSED_CUT_COPPER_SLAB,
                WAXED_WEATHERED_CUT_COPPER_SLAB,

                WAXED_CUT_COPPER_STAIRS,
                WAXED_EXPOSED_CUT_COPPER_STAIRS,
                WAXED_WEATHERED_CUT_COPPER_STAIRS,

                OXIDIZED_COPPER,
                WEATHERED_COPPER,
                EXPOSED_COPPER,
                COPPER_BLOCK,

                OXIDIZED_CUT_COPPER,
                WEATHERED_CUT_COPPER,
                EXPOSED_CUT_COPPER,
                CUT_COPPER,

                OXIDIZED_CUT_COPPER_SLAB,
                WEATHERED_CUT_COPPER_SLAB,
                EXPOSED_CUT_COPPER_SLAB,
                CUT_COPPER_SLAB,

                OXIDIZED_CUT_COPPER_STAIRS,
                WEATHERED_CUT_COPPER_STAIRS,
                EXPOSED_CUT_COPPER_STAIRS,
                CUT_COPPER_STAIRS
        ));
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (Block block : BLOCKS) {
            event.getRegistry().register(block);
        }
    }

    public static void registerModels() {
        for (Block block : BLOCKS) {
            RenderTypeLookup.setRenderLayer(block, RenderType.getSolid());
        }
    }
}
