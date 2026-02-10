package net.Kenny.testmod.worldgen.portal;

import net.Kenny.testmod.block.ModBlocks;
import net.Kenny.testmod.block.custom.ModPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.portal.DimensionTransition;

public class ModTeleporter {

    public static DimensionTransition createTransition(
            Entity entity,
            ServerLevel destinationWorld,
            BlockPos sourcePos,
            boolean insideDimension
    ) {

        int y = insideDimension ? 61 : sourcePos.getY();
        BlockPos destinationPos = new BlockPos(sourcePos.getX(), y, sourcePos.getZ());

        int tries = 0;
        while (tries < 25 &&
                (!destinationWorld.getBlockState(destinationPos).isAir() ||
                        !destinationWorld.getBlockState(destinationPos.above()).isAir())) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        BlockPos finalDestinationPos = destinationPos;

        Vec3 spawnPos = Vec3.atCenterOf(destinationPos);

        return new DimensionTransition(
                destinationWorld,
                spawnPos,
                entity.getDeltaMovement(),
                entity.getYRot(),
                entity.getXRot(),
                (teleportedEntity) -> {

                    if (insideDimension) {
                        boolean doSetBlock = true;

                        for (BlockPos checkPos : BlockPos.betweenClosed(
                                finalDestinationPos.below(10).west(10),
                                finalDestinationPos.above(10).east(10))) {

                            if (destinationWorld.getBlockState(checkPos).getBlock()
                                    instanceof ModPortalBlock) {
                                doSetBlock = false;
                                break;
                            }
                        }

                        if (doSetBlock) {
                            destinationWorld.setBlock(
                                    finalDestinationPos,
                                    ModBlocks.MOD_PORTAL.get().defaultBlockState(),
                                    3
                            );
                        }
                    }
                }
        );
    }
}
