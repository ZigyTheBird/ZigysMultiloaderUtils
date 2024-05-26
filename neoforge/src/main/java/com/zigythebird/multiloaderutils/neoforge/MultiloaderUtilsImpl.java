package com.zigythebird.multiloaderutils.neoforge;

import com.zigythebird.multiloaderutils.neoforge.network.MultiloaderPayloadHandler;

public class MultiloaderUtilsImpl {
    public static void forceClientToHaveMod(String mod_id, String version) {
        MultiloaderPayloadHandler.registerVersionChecker(mod_id, version);
    }

    public static void forceServerToHaveMod(String mod_id, String version) {
        MultiloaderPayloadHandler.registerVersionChecker(mod_id, version);
    }
}
