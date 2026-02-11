package net.Kenny.testmod.item;

import net.Kenny.testmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier VERMIDIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_REFINED_VERMIDIUM_TOOL,
            3031, 10f, 2.5f, 18, () -> Ingredient.of(ModItems.VERMIDIUM_INGOT));

}
