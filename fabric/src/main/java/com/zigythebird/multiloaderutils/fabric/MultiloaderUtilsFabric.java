package com.zigythebird.multiloaderutils.fabric;

import com.zigythebird.multiloaderutils.MultiloaderUtils;
import com.zigythebird.multiloaderutils.fabric.events.ServerEvents;
import com.zigythebird.multiloaderutils.misc.ModEnv;
import com.zigythebird.multiloaderutils.network.MultiloaderPacket;
import com.zigythebird.multiloaderutils.utils.NetworkManager;
import com.zigythebird.multiloaderutils.utils.Platform;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MultiloaderUtilsFabric implements ModInitializer {
    public static Map<ResourceLocation, NetworkManager.NetworkInterface> recieverMap = new HashMap<>();

    @Override
    public void onInitialize() {
        MultiloaderUtils.init();
        ServerLifecycleEvents.SERVER_STARTING.register(new ServerEvents());
        ServerLifecycleEvents.SERVER_STOPPED.register(new ServerEvents());

        PayloadTypeRegistry.playS2C().register(MultiloaderPacket.TYPE, MultiloaderPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(MultiloaderPacket.TYPE, MultiloaderPacket.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(MultiloaderPacket.TYPE, ((payload, context) -> {
            FriendlyByteBuf data = payload.data();

            context.server().execute(() -> {
                recieverMap.get(payload.ID()).receive(data, new NetworkManager.PacketContext() {
                    @Override
                    public Optional<Player> getPlayer() {
                        return Optional.of(context.player());
                    }

                    @Override
                    public ModEnv getEnvironment() {
                        return Platform.getEnv();
                    }
                });
            });
        }));
    }
}
