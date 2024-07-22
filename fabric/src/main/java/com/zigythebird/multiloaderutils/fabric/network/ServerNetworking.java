package com.zigythebird.multiloaderutils.fabric.network;

import com.zigythebird.multiloaderutils.fabric.MultiloaderUtilsFabric;
import com.zigythebird.multiloaderutils.network.MultiloaderPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import com.zigythebird.multiloaderutils.utils.NetworkManager;

public class ServerNetworking {
    public static void sendToPlayer(ServerPlayer player, ResourceLocation packet, FriendlyByteBuf data) {
        ServerPlayNetworking.send(player, new MultiloaderPacket(data, packet));
    }

    public static void register(ResourceLocation id, NetworkManager.NetworkInterface networkInterface) {
        MultiloaderUtilsFabric.recieverMap.put(id, networkInterface);
    }
}
