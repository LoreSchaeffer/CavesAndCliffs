package it.multicoredev.cnc.blocks;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.loot.LootContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.ToIntFunction;

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
public class CandleBlock extends Block implements IWaterLoggable {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final IntegerProperty CANDLES = IntegerProperty.create("candles", 1, 4);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final ToIntFunction<BlockState> LIGHT_EMISSION = state -> state.get(LIT) ? 3 * state.get(CANDLES) : 0;
    public static final Int2ObjectMap<List<Vector3d>> PARTICLE_OFFSETS = Util.make(() -> {
        Int2ObjectOpenHashMap map = new Int2ObjectOpenHashMap();
        map.defaultReturnValue(ImmutableList.of());
        map.put(1, ImmutableList.of(new Vector3d(0.5, 0.5, 0.5)));
        map.put(2, ImmutableList.of(new Vector3d(0.375, 0.44, 0.5), new Vector3d(0.625, 0.5, 0.44)));
        map.put(3, ImmutableList.of(new Vector3d(0.5, 0.313, 0.625), new Vector3d(0.375, 0.44, 0.5), new Vector3d(0.56, 0.5, 0.44)));
        map.put(4, ImmutableList.of(new Vector3d(0.44, 0.313, 0.56), new Vector3d(0.625, 0.44, 0.56), new Vector3d(0.375, 0.44, 0.375), new Vector3d(0.56, 0.5, 0.375)));
        return Int2ObjectMaps.unmodifiable(map);
    });
    protected static final VoxelShape ONE_SHAPE = Block.makeCuboidShape(7.0, 0.0, 7.0, 9.0, 6.0, 9.0);
    protected static final VoxelShape TWO_SHAPE = Block.makeCuboidShape(5.0, 0.0, 6.0, 11.0, 6.0, 9.0);
    protected static final VoxelShape THREE_SHAPE = Block.makeCuboidShape(5.0, 0.0, 6.0, 10.0, 6.0, 11.0);
    protected static final VoxelShape FOUR_SHAPE = Block.makeCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 10.0);

    public CandleBlock(String name, MaterialColor color) {
        super(AbstractBlock.Properties.create(Material.MISCELLANEOUS, color).hardnessAndResistance(0.1f).notSolid().setLightLevel(LIGHT_EMISSION));
        setRegistryName("minecraft:" + name);
    }

    public CandleBlock(String name, DyeColor color) {
        super(AbstractBlock.Properties.create(Material.MISCELLANEOUS, color).hardnessAndResistance(0.1f).notSolid().setLightLevel(LIGHT_EMISSION));
        setRegistryName("minecraft:" + name);
    }

    private static void extinguish(World worldIn, BlockState state, BlockPos pos) {
        setLit(worldIn, state, pos, false);
        worldIn.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0.0, 0.1f, 0.0);
        worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f, 1.0f, false); //TODO Change sound
    }

    private static void setLit(World worldIn, BlockState state, BlockPos pos, boolean lit) {
        FluidState fluidState = worldIn.getFluidState(pos);
        if (fluidState.getFluid() == Fluids.WATER) return;

        worldIn.setBlockState(pos, state.with(LIT, lit), 11);
    }

    private static void addParticlesAndSound(World world, BlockPos pos, Vector3d vect, Random random) {
        float f = random.nextFloat();
        if (f < 0.3f) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + vect.getX(), pos.getY() + vect.getY(), pos.getZ() + vect.getZ(), 0.0, 0.0, 0.0);
            if (f < 0.17f) {
                world.playSound(pos.getX() + vect.getX() + 0.5, pos.getY() + vect.getY() + 0.5, pos.getZ() + vect.getZ() + 0.5, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false); //TODO Change sound
            }
        }
        world.addParticle(ParticleTypes.FLAME, pos.getX() + vect.getX(), pos.getY() + vect.getY(), pos.getZ() + vect.getZ(), 0.0, 0.0, 0.0);
    }

    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT, CANDLES, WATERLOGGED);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos post, ISelectionContext context) {
        switch (state.get(CANDLES)) {
            case 1:
            default:
                return ONE_SHAPE;
            case 2:
                return TWO_SHAPE;
            case 3:
                return THREE_SHAPE;
            case 4:
                return FOUR_SHAPE;
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        BlockState state = world.getBlockState(pos);

        if (state.isIn(this) && state.get(CANDLES) < 4) {
            return state.with(CANDLES, Math.min(4, state.get(CANDLES) + 1));
        } else {
            FluidState fluidState = context.getWorld().getFluidState(context.getPos());
            boolean flag = fluidState.getFluid() == Fluids.WATER;
            return super.getStateForPlacement(context).with(WATERLOGGED, flag).with(LIT, !flag);
        }
    }

    public boolean isReplaceable(BlockState state, BlockItemUseContext context) {
        return context.getItem().getItem() == this.asItem() && state.get(CANDLES) < 4 || super.isReplaceable(state, context);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        if (state.get(WATERLOGGED) || fluidStateIn.getFluid() == Fluids.WATER) {
            return false;
        }

        state.with(WATERLOGGED, true);
        if (state.get(LIT)) {
            CandleBlock.extinguish((World) worldIn, state, pos);
        } else {
            worldIn.setBlockState(pos, state, 3);
        }

        return true;
    }

    public boolean isValidGround(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return state.isSolid();
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return isValidGround(worldIn.getBlockState(blockPos), worldIn, blockPos);
    }

    private Iterable<Vector3d> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS.get(state.get(CANDLES));
    }

    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        if (!state.get(LIT)) return;

        getParticleOffsets(state).forEach(vect -> addParticlesAndSound(world, pos, vect, rand));
    }

    public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
        if (!worldIn.isRemote() && projectile.isBurning() && !state.get(LIT)) {
            setLit(worldIn, state, hit.getPos(), true);
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (player.getHeldItem(handIn).isEmpty() && state.get(LIT)) {
            CandleBlock.extinguish(worldIn, state, pos);
            return worldIn.isRemote() ? ActionResultType.SUCCESS : ActionResultType.CONSUME;
        }

        ItemStack item = player.getHeldItem(handIn);
        if ((item.getItem().equals(Items.FLINT_AND_STEEL) || item.getItem().equals(Items.FIRE_CHARGE)) && !state.get(LIT)) {
            CandleBlock.setLit(worldIn, state, pos, true);
            if (!worldIn.isRemote && !player.abilities.isCreativeMode) {
                if (item.getItem().equals(Items.FLINT_AND_STEEL)) {
                    item.damageItem(1, player, p -> p.sendBreakAnimation(handIn));
                } else {
                    item.shrink(1);
                }
            }
            return ActionResultType.CONSUME;
        }

        return ActionResultType.PASS;
    }
}
