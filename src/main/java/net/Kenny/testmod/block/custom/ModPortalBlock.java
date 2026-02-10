package net.Kenny.testmod.block.custom;

import net.Kenny.testmod.worldgen.dimension.ModDimensions;
import net.Kenny.testmod.worldgen.portal.ModTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.BlockHitResult;

public class ModPortalBlock extends Block {
    public ModPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useWithoutItem(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            BlockHitResult hit
    ) {
        if (!level.isClientSide()) {
            handleModPortal(player, pos);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    private void handleModPortal(Entity player, BlockPos pPos) {
        if (!(player.level() instanceof ServerLevel currentLevel)) return;

        MinecraftServer server = currentLevel.getServer();

        boolean goingToModDim =
                player.level().dimension() != ModDimensions.DIM_LEVEL_KEY;

        ResourceKey<Level> targetKey =
                goingToModDim ? ModDimensions.DIM_LEVEL_KEY : Level.OVERWORLD;

        ServerLevel targetLevel = server.getLevel(targetKey);
        if (targetLevel == null || player.isPassenger()) return;

        DimensionTransition transition =
                ModTeleporter.createTransition(
                        player,
                        targetLevel,
                        pPos,
                        goingToModDim
                );

        player.changeDimension(transition);
    }
}
