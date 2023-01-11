package com.Apothic0n.MoltenGeodes.core.objects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.world.level.block.Block.UPDATE_ALL;

public class DormantOchrumBlockEntity extends BlockEntity {
    public DormantOchrumBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(MoltenBlockEntities.DORMANT_OCHRUM_BLOCK_ENTITY.get(), blockPos, blockState);
    }
    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (!level.isClientSide) {
            ServerLevel serverLevel = level.getServer().getLevel(level.dimension());
            if (serverLevel != null) {
                BlockState blockAbove = level.getBlockState(blockPos.above());
                if (blockAbove.is(Blocks.TNT)) {
                    level.setBlock(blockPos.above(), Blocks.AIR.defaultBlockState(), UPDATE_ALL);
                    PrimedTnt primedtnt = new PrimedTnt(level, (double) blockPos.above().getX() + 0.5D, (double)blockPos.above().getY(), (double)blockPos.above().getZ() + 0.5D, null);
                    level.addFreshEntity(primedtnt);
                    level.playSound(null, primedtnt.getX(), primedtnt.getY(), primedtnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlock(blockPos, MoltenBlocks.MOLTEN_OCHRUM.get().defaultBlockState(), UPDATE_ALL);
                }
            }
        }
    }
}
