/*package net.Kenny.testmod.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ConstantSizeOreFeature extends Feature<NoneFeatureConfiguration> {
    private final Block oreBlock;

    public ConstantSizeOreFeature(Codec<NoneFeatureConfiguration> codec, Block oreBlock) {
        super(codec);
        this.oreBlock = oreBlock;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        int blocksToPlace = 1 + random.nextInt(2);
        int placed = 0;

        for (int i = 0; i < blocksToPlace; i++) {
            BlockPos pos = origin.offset(random.nextInt(3) - 1,
                    random.nextInt(3) - 1,
                    random.nextInt(3) - 1);
            BlockState state = world.getBlockState(pos);
            if (state.is(BlockTags.STONE_ORE_REPLACEABLES)) {
                world.setBlock(pos, oreBlock.defaultBlockState(), 3);
                placed++;
            }
        }

        return placed > 0;
    }
}

 */
