package com.Apothic0n.MoltenGeodes.api.biome.features;

import com.Apothic0n.MoltenGeodes.MoltenGeodes;
import com.Apothic0n.MoltenGeodes.api.biome.features.types.MoltenGeodeFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MoltenGeodesFeatureRegistry {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MoltenGeodes.MODID);

    public static final RegistryObject<Feature<GeodeConfiguration>> MOLTEN_GEODE = FEATURES.register("molten_geode", () ->
            new MoltenGeodeFeature(GeodeConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
