package com.zigythebird.multiloaderutils.utils.neoforge;

import com.zigythebird.multiloaderutils.misc.ModEnv;
import com.zigythebird.multiloaderutils.misc.ModLoader;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforgespi.language.IModInfo;
import org.spongepowered.asm.service.MixinService;

import java.io.IOException;
import java.nio.file.Path;

public class PlatformImpl {
    public static boolean isModLoaded(String modID) {
        return ModList.get().isLoaded(modID);
    }

    public static boolean isModLoaded(String modID, String modClass) {
        if (ModList.get() != null) {
            return ModList.get().isLoaded(modID);
        } else {
            return hasClass(modClass);
        }
    }

    private static boolean hasClass(String name) {
        try {
            // This does *not* load the class!
            MixinService.getService().getBytecodeProvider().getClassNode(name);
            return true;
        } catch (ClassNotFoundException | IOException e) {
            return false;
        }
    }

    public static Path getConfigFolder() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static ModEnv getEnv() {
        if (FMLEnvironment.dist.isClient()) {
            return ModEnv.CLIENT;
        } else {
            return ModEnv.SERVER;
        }
    }

    public static String getModVersion(String modID) {
        for (IModInfo mod : ModList.get().getMods()) {
            if (mod.getModId().equals(modID)) {
                return mod.getVersion().toString();
            }
        }
        return null;
    }

    public static ModLoader getLoader() {return ModLoader.NeoForge;}
}
