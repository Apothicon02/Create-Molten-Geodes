package com.Apothic0n.MoltenGeodes.api.biome.features;

import com.Apothic0n.MoltenGeodes.config.CommonConfig;
import com.Apothic0n.MoltenGeodes.core.objects.MoltenBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class MoltenGeodesFeatures {
    //Blocks
    public static final Block Asurine = Registry.BLOCK.get(new ResourceLocation("create", "asurine"));
    public static final Block Veridium = Registry.BLOCK.get(new ResourceLocation("create", "veridium"));
    public static final Block Crimsite = Registry.BLOCK.get(new ResourceLocation("create", "crimsite"));
    public static final Block Ochrum = Registry.BLOCK.get(new ResourceLocation("create", "ochrum"));

    //ConfiguredFeatures
    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> ASURINE_GEODE_CONFIGURED = FeatureUtils.register("molten_geodes:asurine_geode", MoltenGeodesFeatureRegistry.MOLTEN_GEODE.get(),
            new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(Asurine), BlockStateProvider.simple(MoltenBlocks.MOLTEN_ASURINE.get()), BlockStateProvider.simple(Blocks.OBSIDIAN), BlockStateProvider.simple(Blocks.SMOOTH_BASALT), List.of(Asurine.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.0D, 0.006D, true, UniformInt.of(4, 6), UniformInt.of(2, 4), UniformInt.of(1, 2), -28, 28, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> VERIDIUM_GEODE_CONFIGURED = FeatureUtils.register("molten_geodes:veridium_geode", MoltenGeodesFeatureRegistry.MOLTEN_GEODE.get(),
            new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(Veridium), BlockStateProvider.simple(MoltenBlocks.MOLTEN_VERIDIUM.get()), BlockStateProvider.simple(Blocks.OBSIDIAN), BlockStateProvider.simple(Blocks.SMOOTH_BASALT), List.of(Veridium.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.0D, 0.006D, true, UniformInt.of(4, 6), UniformInt.of(2, 3), UniformInt.of(2, 3), -28, 28, 0.06D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> CRIMSITE_GEODE_CONFIGURED = FeatureUtils.register("molten_geodes:crimsite_geode", MoltenGeodesFeatureRegistry.MOLTEN_GEODE.get(),
            new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(Crimsite), BlockStateProvider.simple(MoltenBlocks.MOLTEN_CRIMSITE.get()), BlockStateProvider.simple(Blocks.BLACKSTONE), BlockStateProvider.simple(Blocks.OBSIDIAN), List.of(Crimsite.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.6D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 3.0D, 2), 0.0D, 0.006D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(3, 4), -28, 28, 0.08D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> OCHRUM_GEODE_CONFIGURED = FeatureUtils.register("molten_geodes:ochrum_geode", MoltenGeodesFeatureRegistry.MOLTEN_GEODE.get(),
            new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(Ochrum), BlockStateProvider.simple(MoltenBlocks.MOLTEN_OCHRUM.get()), BlockStateProvider.simple(Blocks.OBSIDIAN), BlockStateProvider.simple(Blocks.BLACKSTONE), List.of(Ochrum.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.2D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.0D, 0.006D, true, UniformInt.of(4, 6), UniformInt.of(2, 4), UniformInt.of(1, 2), -28, 28, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> BRASS_GEODE_CONFIGURED = FeatureUtils.register("molten_geodes:brass_geode", MoltenGeodesFeatureRegistry.MOLTEN_GEODE.get(),
            new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(Veridium), BlockStateProvider.simple(MoltenBlocks.MOLTEN_ASURINE.get()), BlockStateProvider.simple(Blocks.OBSIDIAN), BlockStateProvider.simple(Blocks.BLACKSTONE), List.of(MoltenBlocks.MOLTEN_VERIDIUM.get().defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.0D, 2.2D, 3.2D, 4.7D), new GeodeCrackSettings(0.95D, 2.3D, 2), 1.0D, 0.007D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(2, 4), -28, 28, 0.09D, 1));

    //PlacedFeatures
    public static final Holder<PlacedFeature> ASURINE_GEODE_PLACED = PlacementUtils.register("molten_geodes:asurine_geode", ASURINE_GEODE_CONFIGURED, RarityFilter.onAverageOnceEvery(CommonConfig.pureGeodeRarity.get()), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(CommonConfig.geodeMinHeight.get()), VerticalAnchor.absolute(CommonConfig.geodeMaxHeight.get())) , BiomeFilter.biome());
    public static final Holder<PlacedFeature> VERIDIUM_GEODE_PLACED = PlacementUtils.register("molten_geodes:veridium_geode", VERIDIUM_GEODE_CONFIGURED, RarityFilter.onAverageOnceEvery(CommonConfig.pureGeodeRarity.get()), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(CommonConfig.geodeMinHeight.get()), VerticalAnchor.absolute(CommonConfig.geodeMaxHeight.get())) , BiomeFilter.biome());
    public static final Holder<PlacedFeature> CRIMSITE_GEODE_PLACED = PlacementUtils.register("molten_geodes:crimsite_geode", CRIMSITE_GEODE_CONFIGURED, RarityFilter.onAverageOnceEvery(CommonConfig.pureGeodeRarity.get()), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(CommonConfig.geodeMinHeight.get()), VerticalAnchor.absolute(CommonConfig.geodeMaxHeight.get())) , BiomeFilter.biome());
    public static final Holder<PlacedFeature> OCHRUM_GEODE_PLACED = PlacementUtils.register("molten_geodes:ochrum_geode", OCHRUM_GEODE_CONFIGURED, RarityFilter.onAverageOnceEvery(CommonConfig.pureGeodeRarity.get()), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(CommonConfig.geodeMinHeight.get()), VerticalAnchor.absolute(CommonConfig.geodeMaxHeight.get())) , BiomeFilter.biome());
    public static final Holder<PlacedFeature> BRASS_GEODE_PLACED = PlacementUtils.register("molten_geodes:brass_geode", BRASS_GEODE_CONFIGURED, RarityFilter.onAverageOnceEvery(CommonConfig.impureGeodeRarity.get()), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(CommonConfig.geodeMinHeight.get()), VerticalAnchor.absolute(CommonConfig.geodeMaxHeight.get())) , BiomeFilter.biome());

}
