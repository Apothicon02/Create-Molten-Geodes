package com.Apothic0n.MoltenGeodes.core.events;

import com.Apothic0n.MoltenGeodes.MoltenGeodes;
import com.Apothic0n.MoltenGeodes.api.biome.features.MoltenGeodesFeatures;
import com.Apothic0n.MoltenGeodes.config.CommonConfig;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;


@Mod.EventBusSubscriber(modid = MoltenGeodes.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonModEvents {

    @SubscribeEvent
    public static void biomeLoading(@Nonnull BiomeLoadingEvent event) {
        Boolean addedFeature = false;
        if (CommonConfig.netherInsteadOfOverworld.get()) {
            if (event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.ASURINE_GEODE_PLACED);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.VERIDIUM_GEODE_PLACED);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.CRIMSITE_GEODE_PLACED);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.OCHRUM_GEODE_PLACED);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.BRASS_GEODE_PLACED);
                addedFeature = true;
            }
        } else if(!event.getCategory().equals(Biome.BiomeCategory.NETHER) && !event.getCategory().equals(Biome.BiomeCategory.THEEND) && event.getName().getNamespace().equals("minecraft")) {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.ASURINE_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.VERIDIUM_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.CRIMSITE_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.OCHRUM_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.BRASS_GEODE_PLACED);
            addedFeature = true;
        }
        if (!addedFeature && event.getName().getNamespace().equals(CommonConfig.modName.get())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.ASURINE_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.VERIDIUM_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.CRIMSITE_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.OCHRUM_GEODE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MoltenGeodesFeatures.BRASS_GEODE_PLACED);
        }
    }
}
