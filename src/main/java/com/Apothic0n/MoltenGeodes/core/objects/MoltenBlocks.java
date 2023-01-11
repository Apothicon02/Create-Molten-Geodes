package com.Apothic0n.MoltenGeodes.core.objects;

import com.Apothic0n.MoltenGeodes.MoltenGeodes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class MoltenBlocks {
    private MoltenBlocks() {}

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoltenGeodes.MODID);

    public static final RegistryObject<Block> MOLTEN_ASURINE = BLOCKS.register("molten_asurine", () ->
            new MoltenAsurineBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 15;})));

    public static final RegistryObject<Block> MOLTEN_VERIDIUM = BLOCKS.register("molten_veridium", () ->
            new MoltenVeridiumBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 15;})));

    public static final RegistryObject<Block> MOLTEN_CRIMSITE = BLOCKS.register("molten_crimsite", () ->
            new MoltenCrimsiteBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 15;})));

    public static final RegistryObject<Block> MOLTEN_OCHRUM = BLOCKS.register("molten_ochrum", () ->
            new MoltenOchrumBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 15;})));

    public static final RegistryObject<Block> DORMANT_ASURINE = BLOCKS.register("dormant_asurine", () ->
            new DormantAsurineBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 5;})));

    public static final RegistryObject<Block> DORMANT_VERIDIUM = BLOCKS.register("dormant_veridium", () ->
            new DormantVeridiumBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 5;})));

    public static final RegistryObject<Block> DORMANT_CRIMSITE = BLOCKS.register("dormant_crimsite", () ->
            new DormantCrimsiteBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 5;})));

    public static final RegistryObject<Block> DORMANT_OCHRUM = BLOCKS.register("dormant_ochrum", () ->
            new DormantOchrumBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).explosionResistance(1200).sound(SoundType.TUFF).lightLevel((brightness) -> {return 5;})));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
