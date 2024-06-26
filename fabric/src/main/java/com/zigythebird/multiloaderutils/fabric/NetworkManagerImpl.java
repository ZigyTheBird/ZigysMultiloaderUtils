package com.zigythebird.multiloaderutils.fabric;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import com.zigythebird.multiloaderutils.fabric.network.ClientNetworking;
import com.zigythebird.multiloaderutils.fabric.network.ServerNetworking;
import com.zigythebird.multiloaderutils.utils.NetworkManager;

import java.util.Collection;

public class NetworkManagerImpl {
    public static void sendToPlayers(Collection<ServerPlayer> players, ResourceLocation packet, FriendlyByteBuf buf) {
        for (ServerPlayer player : players) {
            sendToPlayer(player, packet, buf);
        }
    }

    public static void sendToPlayer(ServerPlayer player, ResourceLocation packet, FriendlyByteBuf buf) {
        ServerNetworking.sendToPlayer(player, packet, buf);
    }

    public static void sendToServer(ResourceLocation packet, FriendlyByteBuf buf) {
        ClientNetworking.sendToServer(packet, buf);
    }

    public static void registerReceiver(NetworkManager.Side side, ResourceLocation id, NetworkManager.NetworkInterface networkInterface) {
        if (side == NetworkManager.Side.S2C) {
            ClientNetworking.register(id, networkInterface);
        } else {
            ServerNetworking.register(id, networkInterface);
        }
    }
}
