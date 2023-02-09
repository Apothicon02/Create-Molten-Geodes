package com.Apothic0n.MoltenGeodes.config;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    public static ForgeConfigSpec.BooleanValue useSource;
    public static ForgeConfigSpec.BooleanValue netherInsteadOfOverworld;
    public static ForgeConfigSpec.ConfigValue<? extends String> modName;
    public static ForgeConfigSpec.ConfigValue<? extends Integer> geodeMinHeight;
    public static ForgeConfigSpec.ConfigValue<? extends Integer> geodeMaxHeight;
    public static ForgeConfigSpec.ConfigValue<? extends Integer> pureGeodeRarity;
    public static ForgeConfigSpec.ConfigValue<? extends Integer> impureGeodeRarity;
    public static ForgeConfigSpec.ConfigValue<? extends String> requiredLiquid;
    public static void registerCommonConfig(ForgeConfigSpec.Builder COMMON_BUILDER) {
        COMMON_BUILDER.comment("General settings for Molten Geodes").push("common");

        useSource = COMMON_BUILDER
                .comment("When true, orestone blocks will only replace liquid source blocks. This means that you will require a constant supply of liquid to generate orestones. Default: true")
                .define("useSource", true);

        netherInsteadOfOverworld = COMMON_BUILDER
                .comment("When true, molten geodes will generate in the nether and not in the overworld. Highly recommended to dramatically increase the rarirty of geodes when this setting is enabled. Biomes added by the mod who is named in the modName config option will still generate geodes regardless of this setting. Default: false")
                .define("netherInsteadOfOverworld", false);

        modName = COMMON_BUILDER
                .comment("The name of a mod whom's biomes you wish for the geodes to generate in. Important: You must have the mod's technical id such as 'tconstruct' instead of 'Tinkers Construct'. Default: 'inversia'")
                .define("modName", "inversia");

        geodeMinHeight = COMMON_BUILDER
                .comment("The minimum Y value at which geodes will generate. Default: -40")
                .define("geodeMinHeight", -40);

        geodeMaxHeight = COMMON_BUILDER
                .comment("The maximum Y value at which geodes will generate. Default: -6")
                .define("geodeMaxHeight", -6);

        pureGeodeRarity = COMMON_BUILDER
                .comment("The rarity of pure geodes. The higher the number the rarer the geodes. Default: 35")
                .define("pureGeodeRarity", 35);

        impureGeodeRarity = COMMON_BUILDER
                .comment("The rarity of impure geodes. The higher the number the rarer the geodes. Default: 20")
                .define("impureGeodeRarity", 20);

        requiredLiquid = COMMON_BUILDER
                .comment("The name of a mod whom's biomes you wish for the geodes to generate in. Important: You must have the mod's technical id such as 'tconstruct' instead of 'Tinkers Construct'. Default: 'minecraft:lava'")
                .define("requiredLiquid", "minecraft:lava");

        COMMON_BUILDER.pop();
    }
}