package com.zigythebird.multiloaderutils.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientLoginConnectionEvents;
import com.zigythebird.multiloaderutils.fabric.events.ClientLoginEvent;

public class MultiloaderUtilsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLoginConnectionEvents.QUERY_START.register(new ClientLoginEvent());
    }
}
