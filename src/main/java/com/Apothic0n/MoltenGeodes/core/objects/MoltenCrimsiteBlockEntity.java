package com.Apothic0n.MoltenGeodes.core.objects;

import com.Apothic0n.MoltenGeodes.api.biome.features.MoltenGeodesFeatures;
import com.Apothic0n.MoltenGeodes.config.CommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.minecraft.world.level.block.Block.UPDATE_ALL;

public class MoltenCrimsiteBlockEntity extends BlockEntity {
    public MoltenCrimsiteBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(MoltenBlockEntities.MOLTEN_CRIMSITE_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public static int spreadDistance = 5; //Max 5

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (!level.isClientSide) {
            ServerLevel serverLevel = level.getServer().getLevel(level.dimension());
            if (serverLevel != null) {
                spreadBlock(blockPos.above(), serverLevel);
                spreadBlock(blockPos.below(), serverLevel);
                spreadBlock(blockPos.north(), serverLevel);
                spreadBlock(blockPos.east(), serverLevel);
                spreadBlock(blockPos.south(), serverLevel);
                spreadBlock(blockPos.west(), serverLevel);
            }
        }
    }

    private static void spreadBlock(BlockPos pos, WorldGenLevel level) {
        BlockState[] contacts = {level.getBlockState(pos.above()), level.getBlockState(pos.below()), level.getBlockState(pos.north()), level.getBlockState(pos.east()), level.getBlockState(pos.south()), level.getBlockState(pos.west())};
        Boolean isTouchingCrimsite = false;
        for (int i = 0; i < contacts.length; ++i) { //Check each non-diagonal neighbor to see if it is crimsite
            if (contacts[i].is(MoltenGeodesFeatures.Crimsite) || contacts[i].is(MoltenBlocks.MOLTEN_CRIMSITE.get())) {
                isTouchingCrimsite = true;
            }
        }
        if (isTouchingCrimsite && !CommonConfig.useLava.get() && level.getBlockState(pos).is(Blocks.LAVA) || isTouchingCrimsite && CommonConfig.useLava.get() && level.getBlockState(pos).is(Blocks.LAVA) && level.getBlockState(pos).getFluidState().isSource() || isTouchingCrimsite && level.getBlockState(pos).is(MoltenGeodesFeatures.Crimsite)) {
            if (!CommonConfig.useLava.get() && level.getBlockState(pos).is(Blocks.LAVA) || CommonConfig.useLava.get() && level.getBlockState(pos).is(Blocks.LAVA) && level.getBlockState(pos).getFluidState().isSource()) {
                level.setBlock(pos, MoltenGeodesFeatures.Crimsite.defaultBlockState(), UPDATE_ALL);
                level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.getServer().getLevel(level.getLevel().dimension()).sendParticles(ParticleTypes.LARGE_SMOKE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.25D, (double)pos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
            }
            List<BlockPos> convertedBlocks = convertTouching(pos, level);
            if (convertedBlocks != null && !convertedBlocks.isEmpty() && spreadDistance >= 1) {
                List<BlockPos> secondaryConvertedBlocks = new ArrayList<>(List.of());
                for (int i = 0; i < convertedBlocks.size(); i++) {
                    List<BlockPos> minorConvertedBlocks = convertTouching(convertedBlocks.get(i), level);
                    if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                        secondaryConvertedBlocks.addAll(minorConvertedBlocks);
                    }
                }
                if (secondaryConvertedBlocks != null && !secondaryConvertedBlocks.isEmpty() && spreadDistance >= 2) {
                    List<BlockPos> teritaryConvertedBlocks = new ArrayList<>(List.of());
                    for (int i = 0; i < secondaryConvertedBlocks.size(); i++) {
                        List<BlockPos> minorConvertedBlocks = convertTouching(secondaryConvertedBlocks.get(i), level);
                        if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                            teritaryConvertedBlocks.addAll(minorConvertedBlocks);
                        }
                    }
                    if (teritaryConvertedBlocks != null && !teritaryConvertedBlocks.isEmpty() && spreadDistance >= 3) {
                        List<BlockPos> quaternaryConvertedBlocks = new ArrayList<>(List.of());
                        for (int i = 0; i < teritaryConvertedBlocks.size(); i++) {
                            List<BlockPos> minorConvertedBlocks = convertTouching(teritaryConvertedBlocks.get(i), level);
                            if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                                quaternaryConvertedBlocks.addAll(minorConvertedBlocks);
                            }
                        }
                        if (quaternaryConvertedBlocks != null && !quaternaryConvertedBlocks.isEmpty() && spreadDistance >= 4) {
                            List<BlockPos> quinaryConvertedBlocks = new ArrayList<>(List.of());
                            for (int i = 0; i < quaternaryConvertedBlocks.size(); i++) {
                                List<BlockPos> minorConvertedBlocks = convertTouching(quaternaryConvertedBlocks.get(i), level);
                                if (minorConvertedBlocks != null && minorConvertedBlocks.isEmpty()) {
                                    quinaryConvertedBlocks.addAll(minorConvertedBlocks);
                                }
                            }
                            if (quinaryConvertedBlocks != null && !quinaryConvertedBlocks.isEmpty() && spreadDistance >= 5) {
                                List<BlockPos> senaryConvertedBlocks = new ArrayList<>(List.of());
                                for (int i = 0; i < quinaryConvertedBlocks.size(); i++) {
                                    List<BlockPos> minorConvertedBlocks = convertTouching(quinaryConvertedBlocks.get(i), level);
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

    private static List<BlockPos> convertTouching(BlockPos pos, WorldGenLevel level) {
        List<BlockPos> lavaBlocks = getLavaTouching(pos, level);
        List<BlockPos> convertedBlocks = new ArrayList<>(List.of());
        if (lavaBlocks != null && !lavaBlocks.isEmpty()) {
            for (int i = 0; i < lavaBlocks.size(); ++i) {
                BlockPos lavaPos = lavaBlocks.get(i);
                if (!CommonConfig.useLava.get() && level.getBlockState(lavaPos).is(Blocks.LAVA) || CommonConfig.useLava.get() && level.getBlockState(lavaPos).is(Blocks.LAVA) && level.getBlockState(lavaPos).getFluidState().isSource()) {
                    level.setBlock(lavaPos, MoltenGeodesFeatures.Crimsite.defaultBlockState(), UPDATE_ALL);
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

    private static List<BlockPos> getLavaTouching(BlockPos pos, WorldGenLevel level) {
        BlockPos[] contacts = {pos.above(), pos.below(), pos.north(), pos.east(), pos.south(), pos.west()};
        List<BlockPos> lavaBlocks = new ArrayList<>(List.of());
        for (int i = 0; i < contacts.length; ++i) { //Check each non-diagonal neighbor to see if it is crimsite
            if (!CommonConfig.useLava.get() && level.getBlockState(pos).is(Blocks.LAVA) || CommonConfig.useLava.get() && level.getBlockState(pos).is(Blocks.LAVA) && level.getBlockState(pos).getFluidState().isSource() || level.getBlockState(contacts[i]).is(MoltenGeodesFeatures.Crimsite)) {
                lavaBlocks.add(contacts[i]);
            }
        }
        if (lavaBlocks.size() > 0) {
            return lavaBlocks;
        }
        return null;
    }
}
