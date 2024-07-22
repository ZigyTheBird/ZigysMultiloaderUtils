package com.zigythebird.multiloaderutils.neoforge.network;

import com.zigythebird.multiloaderutils.network.MultiloaderPacket;
import net.minecraft.network.protocol.PacketFlow;
import net.neoforged.fml.LogicalSide;
import com.zigythebird.multiloaderutils.utils.NetworkManager;
import com.zigythebird.multiloaderutils.utils.Platform;
import com.zigythebird.multiloaderutils.utils.neoforge.NetworkManagerImpl;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import java.util.Optional;

public class MultiloaderPayloadHandler {
    private static final MultiloaderPayloadHandler INSTANCE = new MultiloaderPayloadHandler();

    public static MultiloaderPayloadHandler getInstance() {
        return INSTANCE;
    }

    public void handleData(final MultiloaderPacket data, final IPayloadContext context) {
        context.enqueueWork(() -> {
            NetworkManagerImpl.getNetworkReciever(data.ID()).apply(data.data(), Optional.of(context.player()), Platform.getEnv(), getSide(context.flow()));
        });
    }

    public static NetworkManager.Side getSide(PacketFlow direction) {
        if (direction.getReceptionSide() == LogicalSide.CLIENT) {
            return NetworkManager.Side.S2C;
        } else {
            return NetworkManager.Side.C2S;
        }
    }
}
