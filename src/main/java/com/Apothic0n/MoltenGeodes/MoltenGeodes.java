package com.Apothic0n.MoltenGeodes;

import com.Apothic0n.MoltenGeodes.api.biome.features.MoltenGeodesFeatureRegistry;
import com.Apothic0n.MoltenGeodes.config.Configs;
import com.Apothic0n.MoltenGeodes.core.objects.MoltenBlockEntities;
import com.Apothic0n.MoltenGeodes.core.objects.MoltenBlocks;
import com.Apothic0n.MoltenGeodes.core.objects.MoltenItems;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.Apothic0n.MoltenGeodes.api.biome.features.MoltenGeodesFeatures.*;

// The value here should match an entry in the META-INF/mods.toml file.
@Mod("molten_geodes")
public class MoltenGeodes
{
    public static final String MODID = "molten_geodes";

    public MoltenGeodes()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        Configs.register();
        MoltenGeodesFeatureRegistry.register(eventBus);
        MoltenBlockEntities.register(eventBus);
        MoltenBlocks.register(eventBus);
        MoltenItems.register(eventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            final Holder<PlacedFeature> initializeAsurine = ASURINE_GEODE_PLACED;
            final Holder<PlacedFeature> initializeVeridium = VERIDIUM_GEODE_PLACED;
            final Holder<PlacedFeature> initializeCrimsite = CRIMSITE_GEODE_PLACED;
            final Holder<PlacedFeature> initializeOchrum = OCHRUM_GEODE_PLACED;
            final Holder<PlacedFeature> initializeBrass = BRASS_GEODE_PLACED;
        });
    }
}
