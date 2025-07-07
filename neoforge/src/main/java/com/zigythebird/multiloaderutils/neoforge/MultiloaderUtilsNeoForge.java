package com.zigythebird.multiloaderutils.neoforge;

import com.zigythebird.multiloaderutils.MultiloaderUtils;
import com.zigythebird.multiloaderutils.neoforge.network.MultiloaderPayloadHandler;
import com.zigythebird.multiloaderutils.network.MultiloaderPacket;
import com.zigythebird.multiloaderutils.utils.neoforge.PlatformImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@Mod(MultiloaderUtils.MOD_ID)
public class MultiloaderUtilsNeoForge {
    public MultiloaderUtilsNeoForge(IEventBus bus) {
        MultiloaderUtils.init();
        bus.addListener(MultiloaderUtilsNeoForge::registerPackets);
    }

    public static void registerPackets(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(MultiloaderUtils.MOD_ID);
        registrar.commonBidirectional(MultiloaderPacket.TYPE, MultiloaderPacket.STREAM_CODEC, MultiloaderPayloadHandler.getInstance()::handleData, MultiloaderPayloadHandler.getInstance()::handleData);
    }
}
