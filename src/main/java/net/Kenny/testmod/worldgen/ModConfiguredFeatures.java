package net.Kenny.testmod.worldgen;

import net.Kenny.testmod.TestMod;
import net.Kenny.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_VERMIDIUM_ORE_KEY = registerKey("vermidium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_DEEPSLATE_VERMIDIUM_ORE_KEY = registerKey("deepslate_vermidium_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldVermidiumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.VERMIDIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldDeepslateVermidiumOres = List.of(
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_VERMIDIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_VERMIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldVermidiumOres, 2));
        register(context, OVERWORLD_DEEPSLATE_VERMIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldDeepslateVermidiumOres, 5));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,  F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
