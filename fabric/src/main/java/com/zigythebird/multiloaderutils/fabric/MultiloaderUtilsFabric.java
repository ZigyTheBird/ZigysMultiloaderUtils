package com.zigythebird.multiloaderutils.fabric;

import com.zigythebird.multiloaderutils.MultiloaderUtils;
import com.zigythebird.multiloaderutils.fabric.events.ServerEvents;
import com.zigythebird.multiloaderutils.fabric.events.ServerLoginEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerLoginConnectionEvents;

public class MultiloaderUtilsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MultiloaderUtils.init();
        ServerLifecycleEvents.SERVER_STARTING.register(new ServerEvents());
        ServerLifecycleEvents.SERVER_STOPPED.register(new ServerEvents());
        ServerLoginConnectionEvents.QUERY_START.register(new ServerLoginEvent());
    }
}
