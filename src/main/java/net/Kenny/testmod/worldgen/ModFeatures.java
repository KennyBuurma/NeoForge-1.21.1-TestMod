/*package net.Kenny.testmod.worldgen;

import net.Kenny.testmod.TestMod;
import net.Kenny.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModFeatures {

    public static final ConstantSizeOreFeature TINY_VEIN_VERMIDIUM_ORE_FEATURE =
            new ConstantSizeOreFeature(NoneFeatureConfiguration.CODEC, ModBlocks.VERMIDIUM_ORE.get());

    // ResourceKey for the TinyOreFeature
    public static final ResourceKey<Feature<?>> TINY_VEIN_VERMIDIUM_ORE_KEY =
            ResourceKey.create(Registries.FEATURE, ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "tiny_vein_vermidium_ore"));

    // Bootstrap method for registering the feature
    public static void bootstrap(BootstrapContext<Feature<?>> context) {
        context.register(TINY_VEIN_VERMIDIUM_ORE_KEY, TINY_VEIN_VERMIDIUM_ORE_FEATURE);
    }
}

 */
