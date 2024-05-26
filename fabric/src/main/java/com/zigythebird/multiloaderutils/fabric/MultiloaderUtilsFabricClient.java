package com.zigythebird.multiloaderutils.fabric;

import com.zigythebird.multiloaderutils.fabric.events.ClientLoginEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientLoginConnectionEvents;

public class MultiloaderUtilsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLoginConnectionEvents.QUERY_START.register(new ClientLoginEvent());
    }
}
