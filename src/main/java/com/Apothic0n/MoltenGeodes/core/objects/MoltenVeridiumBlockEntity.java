package com.Apothic0n.MoltenGeodes.core.objects;

import com.Apothic0n.MoltenGeodes.config.CommonConfig;
import com.Apothic0n.MoltenGeodes.api.biome.features.MoltenGeodesFeatures;
import com.Apothic0n.MoltenGeodes.config.CommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

import static com.Apothic0n.MoltenGeodes.api.biome.features.MoltenGeodesFeatures.RequiredLiquid;
import static net.minecraft.world.level.block.Block.UPDATE_ALL;

public class MoltenVeridiumBlockEntity extends BlockEntity {
    public MoltenVeridiumBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(MoltenBlockEntities.MOLTEN_VERIDIUM_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public static int spreadDistance = 5; //Max 5

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (!level.isClientSide) {
            ServerLevel serverLevel = level.getServer().getLevel(level.dimension());
            if (serverLevel != null) {
                spreadBlock(RequiredLiquid, blockPos.above(), serverLevel);
                spreadBlock(RequiredLiquid, blockPos.below(), serverLevel);
                spreadBlock(RequiredLiquid, blockPos.north(), serverLevel);
                spreadBlock(RequiredLiquid, blockPos.east(), serverLevel);
                spreadBlock(RequiredLiquid, blockPos.south(), serverLevel);
                spreadBlock(RequiredLiquid, blockPos.west(), serverLevel);
            }
        }
    }

    private static void spreadBlock(Block requiredLiquid, BlockPos pos, WorldGenLevel level) {
        BlockState[] contacts = {level.getBlockState(pos.above()), level.getBlockState(pos.below()), level.getBlockState(pos.north()), level.getBlockState(pos.east()), level.getBlockState(pos.south()), level.getBlockState(pos.west())};
        Boolean isTouchingVeridium = false;
        for (int i = 0; i < contacts.length; ++i) { //Check each non-diagonal neighbor to see if it is veridium
            if (contacts[i].is(MoltenGeodesFeatures.Veridium) || contacts[i].is(MoltenBlocks.MOLTEN_VERIDIUM.get())) {
                isTouchingVeridium = true;
            }
        }
        if (isTouchingVeridium && !CommonConfig.useSource.get() && level.getBlockState(pos).is(requiredLiquid) || isTouchingVeridium && CommonConfig.useSource.get() && level.getBlockState(pos).is(requiredLiquid) && level.getBlockState(pos).getFluidState().isSource() || isTouchingVeridium && level.getBlockState(pos).is(MoltenGeodesFeatures.Veridium)) {
            if (!CommonConfig.useSource.get() && level.getBlockState(pos).is(requiredLiquid) || CommonConfig.useSource.get() && level.getBlockState(pos).is(requiredLiquid) && level.getBlockState(pos).getFluidState().isSource()) {
                level.setBlock(pos, MoltenGeodesFeatures.Veridium.defaultBlockState(), UPDATE_ALL);
                level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.getServer().getLevel(level.getLevel().dimension()).sendParticles(ParticleTypes.LARGE_SMOKE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.25D, (double)pos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
            }
            List<BlockPos> convertedBlocks = convertTouching(requiredLiquid, pos, level);
            if (convertedBlocks != null && !convertedBlocks.isEmpty() && spreadDistance >= 1) {
                List<BlockPos> secondaryConvertedBlocks = new ArrayList<>(List.of());
                for (int i = 0; i < convertedBlocks.size(); i++) {
                    List<BlockPos> minorConvertedBlocks = convertTouching(requiredLiquid, convertedBlocks.get(i), level);
                    if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                        secondaryConvertedBlocks.addAll(minorConvertedBlocks);
                    }
                }
                if (secondaryConvertedBlocks != null && !secondaryConvertedBlocks.isEmpty() && spreadDistance >= 2) {
                    List<BlockPos> teritaryConvertedBlocks = new ArrayList<>(List.of());
                    for (int i = 0; i < secondaryConvertedBlocks.size(); i++) {
                        List<BlockPos> minorConvertedBlocks = convertTouching(requiredLiquid, secondaryConvertedBlocks.get(i), level);
                        if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                            teritaryConvertedBlocks.addAll(minorConvertedBlocks);
                        }
                    }
                    if (teritaryConvertedBlocks != null && !teritaryConvertedBlocks.isEmpty() && spreadDistance >= 3) {
                        List<BlockPos> quaternaryConvertedBlocks = new ArrayList<>(List.of());
                        for (int i = 0; i < teritaryConvertedBlocks.size(); i++) {
                            List<BlockPos> minorConvertedBlocks = convertTouching(requiredLiquid, teritaryConvertedBlocks.get(i), level);
                            if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                                quaternaryConvertedBlocks.addAll(minorConvertedBlocks);
                            }
                        }
                        if (quaternaryConvertedBlocks != null && !quaternaryConvertedBlocks.isEmpty() && spreadDistance >= 4) {
                            List<BlockPos> quinaryConvertedBlocks = new ArrayList<>(List.of());
                            for (int i = 0; i < quaternaryConvertedBlocks.size(); i++) {
                                List<BlockPos> minorConvertedBlocks = convertTouching(requiredLiquid, quaternaryConvertedBlocks.get(i), level);
                                if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                                    quinaryConvertedBlocks.addAll(minorConvertedBlocks);
                                }
                            }
                            if (quinaryConvertedBlocks != null && !quinaryConvertedBlocks.isEmpty() && spreadDistance >= 5) {
                                List<BlockPos> senaryConvertedBlocks = new ArrayList<>(List.of());
                                for (int i = 0; i < quinaryConvertedBlocks.size(); i++) {
                                    List<BlockPos> minorConvertedBlocks = convertTouching(requiredLiquid, quinaryConvertedBlocks.get(i), level);
                                    if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                                        senaryConvertedBlocks.addAll(minorConvertedBlocks);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static List<BlockPos> convertTouching(Block requiredLiquid, BlockPos pos, WorldGenLevel level) {
        List<BlockPos> lavaBlocks = getLavaTouching(requiredLiquid, pos, level);
        List<BlockPos> convertedBlocks = new ArrayList<>(List.of());
        if (lavaBlocks != null && !lavaBlocks.isEmpty()) {
            for (int i = 0; i < lavaBlocks.size(); ++i) {
                BlockPos lavaPos = lavaBlocks.get(i);
                if (!CommonConfig.useSource.get() && level.getBlockState(lavaPos).is(requiredLiquid) || CommonConfig.useSource.get() && level.getBlockState(lavaPos).is(requiredLiquid) && level.getBlockState(lavaPos).getFluidState().isSource()) {
                    level.setBlock(lavaPos, MoltenGeodesFeatures.Veridium.defaultBlockState(), UPDATE_ALL);
                    level.playSound(null, lavaPos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
                    level.getServer().getLevel(level.getLevel().dimension()).sendParticles(ParticleTypes.LARGE_SMOKE, (double)lavaPos.getX() + 0.5D, (double)lavaPos.getY() + 0.25D, (double)lavaPos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
                }
                convertedBlocks.add(lavaPos);
            }
        }
        if (convertedBlocks.size() > 0) {
            return convertedBlocks;
        }
        return null;
    }

    private static List<BlockPos> getLavaTouching(Block requiredLiquid, BlockPos pos, WorldGenLevel level) {
        BlockPos[] contacts = {pos.above(), pos.below(), pos.north(), pos.east(), pos.south(), pos.west()};
        List<BlockPos> lavaBlocks = new ArrayList<>(List.of());
        for (int i = 0; i < contacts.length; ++i) { //Check each non-diagonal neighbor to see if it is veridium
            if (!CommonConfig.useSource.get() && level.getBlockState(contacts[i]).is(requiredLiquid) || CommonConfig.useSource.get() && level.getBlockState(contacts[i]).is(requiredLiquid) && level.getBlockState(contacts[i]).getFluidState().isSource() || level.getBlockState(contacts[i]).is(MoltenGeodesFeatures.Veridium)) {
                lavaBlocks.add(contacts[i]);
            }
        }
        if (lavaBlocks.size() > 0) {
            return lavaBlocks;
        }
        return null;
    }
}