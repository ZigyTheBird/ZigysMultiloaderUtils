package com.zigythebird.multiloaderutils.forge;

import com.zigythebird.multiloaderutils.forge.network.ModPacketHandler;

public class MultiloaderUtilsImpl {
    public static void forceClientToHaveMod(String mod_id, String version) {
        ModPacketHandler.registerVersionChecker(mod_id, version);
    }

    public static void forceServerToHaveMod(String mod_id, String version) {
        ModPacketHandler.registerVersionChecker(mod_id, version);
    }
}
