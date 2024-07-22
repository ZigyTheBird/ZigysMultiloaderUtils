package com.zigythebird.multiloaderutils.block;

import com.zigythebird.multiloaderutils.interfaces.AdvancedMenuHandler;
import com.zigythebird.multiloaderutils.network.MultiloaderPacket;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BlockEntityWithMenu extends BlockEntity implements AdvancedMenuHandler<MultiloaderPacket>, ExtendedScreenHandlerFactory<MultiloaderPacket> {
    public BlockEntityWithMenu(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
}
