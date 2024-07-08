package com.zigythebird.multiloaderutils.utils;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;
import com.zigythebird.multiloaderutils.misc.ModEnv;
import com.zigythebird.multiloaderutils.misc.ModLoader;

import java.nio.file.Path;

public class Platform {

    @ExpectPlatform
    public static boolean isModLoaded(String modID) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModLoaded(String modID, String modClass) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String getModVersion(String modID) {throw new AssertionError();}

    @ExpectPlatform
    public static Path getConfigFolder() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static ModEnv getEnv() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static ModLoader getLoader() {throw new AssertionError();}

    @ExpectPlatform
    public static boolean isDevelopmentEnvironment() {
        throw new AssertionError();
    }
}
