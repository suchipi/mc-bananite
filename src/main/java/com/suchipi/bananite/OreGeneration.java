package com.suchipi.bananite;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OreGeneration {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void generateOres(final BiomeLoadingEvent event) {
        LOGGER.info("In generateOres!!!!!! Hi mom!!!!!!");

        Biome.Category category = event.getCategory();
        if (category.equals(Biome.Category.NETHER) || category.equals(Biome.Category.THEEND)) {
            return;
        }

        generateOre(
            event.getGeneration(),
            OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
            RegistryHandler.BANANITE.get().getDefaultState(),
            9,
            34,
            63,
            69
        );
    }

    private static void generateOre(
        BiomeGenerationSettingsBuilder settings,
        RuleTest fillerType,
        BlockState state,
        int veinSize,
        int minHeight,
        int maxHeight,
        int amount
    ) {
        LOGGER.info("In generateOre!!!!!! Hi mom!!!!!!");

        settings.withFeature(
            GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
                    .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                    .square().count(amount)
        );
    }
}
