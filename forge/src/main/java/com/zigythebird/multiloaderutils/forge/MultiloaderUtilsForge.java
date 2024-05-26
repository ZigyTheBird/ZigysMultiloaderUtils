package com.zigythebird.multiloaderutils.forge;

import com.zigythebird.multiloaderutils.forge.network.ModPacketHandler;
import net.minecraftforge.fml.common.Mod;
import com.zigythebird.multiloaderutils.MultiloaderUtils;

@Mod(MultiloaderUtils.MOD_ID)
public class MultiloaderUtilsForge {
    public MultiloaderUtilsForge() {
        MultiloaderUtils.init();
        ModPacketHandler.register();
    }
}
