package net.Kenny.testmod.worldgen;

import net.Kenny.testmod.TestMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_VERMIDIUM_ORE = registerKey("add_vermidium_ore");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_VERMIDIUM_ORE = registerKey("add_deepslate_vermidium_ore");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_VERMIDIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VERMIDIUM_ORE_PLACED_KEY_LAPIS_LIKE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_VERMIDIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VERMIDIUM_ORE_PLACED_KEY_REDSTONE_LIKE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Example for individual Biomes
        // HolderSet.direct(biomes.getOrThrow(Biomes.<biomeName>), etc...
    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, name));
    }
}
