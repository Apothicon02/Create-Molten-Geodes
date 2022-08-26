package com.Apothic0n.MoltenGeodes.core.objects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class MoltenVeridiumBlock extends Block implements EntityBlock {
    public MoltenVeridiumBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return blockEntityType == MoltenBlockEntities.MOLTEN_VERIDIUM_BLOCK_ENTITY.get() ? MoltenVeridiumBlockEntity::tick : null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return MoltenBlockEntities.MOLTEN_VERIDIUM_BLOCK_ENTITY.get().create(blockPos, blockState);
    }
}
