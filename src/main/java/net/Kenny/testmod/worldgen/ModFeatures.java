package net.Kenny.testmod.worldgen;

import net.Kenny.testmod.TestMod;
import net.Kenny.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModFeatures {
    public static final ResourceKey<Feature<NoneFeatureConfiguration>> TINY_VEIN_VERMIDIUM_ORE_KEY = registerKey("tiny_vein_vermidium_ore");

    public static void bootstrap(BootstrapContext<Feature<?>> context) {
        register(context, TINY_VEIN_VERMIDIUM_ORE_KEY, new constantSizeOreFeature(NoneFeatureConfiguration.CODEC, ModBlocks.VERMIDIUM_ORE.get()));
    }

    public static ResourceKey<Feature<NoneFeatureConfiguration>> registerKey(String name) {
        return (ResourceKey<Feature<NoneFeatureConfiguration>>) (ResourceKey<?>)
                ResourceKey.create(Registries.FEATURE, ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, name));
    }
    //(ResourceKey<Feature<?>>)(ResourceKey<?>)
    private static <FC extends NoneFeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<Feature<?>> context, ResourceKey<Feature<FC>> key, F feature) {
        context.register((ResourceKey<Feature<?>>)(ResourceKey<?>) key, feature);
    }
}
