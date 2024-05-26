package com.zigythebird.multiloaderutils.utils;

import com.zigythebird.multiloaderutils.misc.ModEnv;
import com.zigythebird.multiloaderutils.misc.ModLoader;
import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

import java.nio.file.Path;

public class Platform {

    @ExpectPlatform
    public static boolean isModLoaded(String modID) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static boolean isModLoaded(String modID, String modClass) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static String getModVersion(String modID) {throw new NotImplementedException();}

    @ExpectPlatform
    public static Path getConfigFolder() {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static ModEnv getEnv() {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static ModLoader getLoader() {throw new NotImplementedException();}
}
