package it.multicoredev.cnc.blocks.copper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

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
public interface ChangeOverTimeBlock {
    BlockState getChangeTo(BlockState state);

    float getChanceModifier();

    Enum<?> getAge();

    default void onRandomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < 0.05688889f) applyChangeOverTime(state, world, pos, random);
    }

    default void applyChangeOverTime(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = getAge().ordinal();
        int i0 = 0;
        int i1 = 0;

        for (BlockPos p : BlockPos.getProximitySortedBoxPositionsIterator(pos, 4, 4, 4)) {
            int distance = p.manhattanDistance(pos);
            if (distance > 4) break;
            if (p.equals(pos)) continue;

            BlockState bs = world.getBlockState(p);
            Block b = bs.getBlock();
            if (!(b instanceof ChangeOverTimeBlock)) continue;

            Enum<?> e = ((ChangeOverTimeBlock) b).getAge();
            if (getAge().getClass() != e.getClass()) continue;

            int a = e.ordinal();
            if (a < age) return;

            if (a > age) {
                ++i1;
            } else {
                ++i0;
            }
        }

        float bc = (float) (i1 + 1) / (float) (i0 + i1 + 1);
        float chance = bc * bc * getChanceModifier();
        if (random.nextFloat() < chance) world.setBlockState(pos, getChangeTo(state));
    }
}
