package com.zigythebird.multiloaderutils.fabric.network;

import com.zigythebird.multiloaderutils.misc.ModEnv;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import com.zigythebird.multiloaderutils.utils.NetworkManager;
import com.zigythebird.multiloaderutils.utils.Platform;

import java.util.Optional;

public class ServerNetworking {
    public static void sendToPlayer(ServerPlayer player, ResourceLocation packet, FriendlyByteBuf data) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        buf.writeInt(data.readableBytes());
        buf.writeBytes(data);
        ServerPlayNetworking.send(player, packet, buf);
    }

    public static void register(ResourceLocation id, NetworkManager.NetworkInterface networkInterface) {
        ServerPlayNetworking.registerGlobalReceiver(id, ((server, player, handler, buf, responseSender) -> {
            FriendlyByteBuf data = new FriendlyByteBuf(buf.readBytes(buf.readInt()));

            server.execute(() -> {
                networkInterface.receive(data, new NetworkManager.PacketContext() {
                    @Override
                    public Optional<Player> getPlayer() {
                        return Optional.of(player);
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
