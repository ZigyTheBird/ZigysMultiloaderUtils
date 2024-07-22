package com.zigythebird.multiloaderutils.fabric.network;

import com.zigythebird.multiloaderutils.fabric.MultiloaderUtilsFabricClient;
import com.zigythebird.multiloaderutils.network.MultiloaderPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import com.zigythebird.multiloaderutils.utils.NetworkManager;

public class ClientNetworking {
    public static void sendToServer(ResourceLocation packet, FriendlyByteBuf data) {
        ClientPlayNetworking.send(new MultiloaderPacket(data, packet));
    }

    public static void register(ResourceLocation id, NetworkManager.NetworkInterface networkInterface) {
        MultiloaderUtilsFabricClient.recieverMap.put(id, networkInterface);
    }
}
