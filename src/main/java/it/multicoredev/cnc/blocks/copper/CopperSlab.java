package it.multicoredev.cnc.blocks.copper;

import it.multicoredev.cnc.blocks.SlabBase;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import static net.minecraftforge.common.ToolType.PICKAXE;

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
public class CopperSlab extends SlabBase implements WeatheringCopper {
    private final WeatherState weatherState;
    private final Block changeTo;

    public CopperSlab(String name, MaterialColor color) {
        super(name, AbstractBlock.Properties.create(Material.IRON, color).hardnessAndResistance(3.0f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1));
        weatherState = WeatherState.values()[WeatherState.values().length - 1];
        changeTo = this;
    }

    public CopperSlab(String name, MaterialColor color, WeatherState weatherState, Block changeTo) {
        super(name, AbstractBlock.Properties.create(Material.IRON, color).hardnessAndResistance(3.0f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1).tickRandomly());
        this.weatherState = weatherState;
        this.changeTo = changeTo;
    }

    public CopperSlab(String name, DyeColor color, WeatherState weatherState, Block changeTo) {
        super(name, AbstractBlock.Properties.create(Material.IRON, color).hardnessAndResistance(3.0f, 6.0f).setRequiresTool().harvestTool(PICKAXE).harvestLevel(1).tickRandomly());
        this.weatherState = weatherState;
        this.changeTo = changeTo;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        onRandomTick(state, world, pos, random);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return changeTo != this;
    }

    @Override
    public WeatherState getAge() {
        return weatherState;
    }

    public BlockState getChangeTo(BlockState state) {
        return changeTo.getDefaultState().with(TYPE, state.get(TYPE)).with(WATERLOGGED, state.get(WATERLOGGED));
    }
}