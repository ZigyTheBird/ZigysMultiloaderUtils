package com.zigythebird.multiloaderutils.fabric;

import com.zigythebird.multiloaderutils.misc.ModEnv;
import com.zigythebird.multiloaderutils.network.MultiloaderPacket;
import com.zigythebird.multiloaderutils.utils.NetworkManager;
import com.zigythebird.multiloaderutils.utils.Platform;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MultiloaderUtilsFabricClient implements ClientModInitializer {
    public static Map<ResourceLocation, NetworkManager.NetworkInterface> recieverMap = new HashMap<>();

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(MultiloaderPacket.TYPE, (payload, context) -> {
            FriendlyByteBuf data = payload.data();

            context.client().execute(() -> {
                recieverMap.get(payload.ID()).receive(data, new NetworkManager.PacketContext() {
                    @Override
                    public Optional<Player> getPlayer() {
                        return Optional.empty();
                    }

                    @Override
                    public ModEnv getEnvironment() {
                        return Platform.getEnv();
                    }
                });
            });
        });
    }
}
