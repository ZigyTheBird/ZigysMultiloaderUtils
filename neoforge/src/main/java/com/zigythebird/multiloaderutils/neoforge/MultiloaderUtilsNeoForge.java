package com.zigythebird.multiloaderutils.neoforge;

import com.zigythebird.multiloaderutils.MultiloaderUtils;
import com.zigythebird.multiloaderutils.neoforge.network.MultiloaderPacket;
import com.zigythebird.multiloaderutils.neoforge.network.MultiloaderPayloadHandler;
import com.zigythebird.multiloaderutils.utils.neoforge.PlatformImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

@Mod(MultiloaderUtils.MOD_ID)
public class MultiloaderUtilsNeoForge {
    public MultiloaderUtilsNeoForge(IEventBus bus) {
        MultiloaderUtils.init();
        bus.addListener(MultiloaderUtilsNeoForge::registerPackets);
    }

    public static void registerPackets(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(MultiloaderUtils.MOD_ID);
        registrar.play(MultiloaderPacket.defaultID, MultiloaderPacket::new, handler -> handler
                .client(MultiloaderPayloadHandler.getInstance()::handleData)
                .server(MultiloaderPayloadHandler.getInstance()::handleData)).versioned(PlatformImpl.getModVersion(MultiloaderUtils.MOD_ID));
    }
}
