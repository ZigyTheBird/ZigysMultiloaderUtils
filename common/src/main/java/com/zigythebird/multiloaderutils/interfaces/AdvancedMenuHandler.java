package com.zigythebird.multiloaderutils.interfaces;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;

public interface AdvancedMenuHandler<D> extends MenuProvider {
    D getScreenOpeningData(ServerPlayer player);
}
