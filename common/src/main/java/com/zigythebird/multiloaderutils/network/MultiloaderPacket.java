package com.zigythebird.multiloaderutils.network;

import com.zigythebird.multiloaderutils.MultiloaderUtils;
import com.zigythebird.multiloaderutils.misc.ModCodecs;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record MultiloaderPacket(FriendlyByteBuf data, ResourceLocation ID) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<MultiloaderPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MultiloaderUtils.MOD_ID, "multiloader_packet"));
    public static final StreamCodec<ByteBuf, MultiloaderPacket> STREAM_CODEC = StreamCodec.composite(
            ModCodecs.FRIENDLY_BYTE_BUF,
            MultiloaderPacket::data,
            ModCodecs.RESOURCELOCATION,
            MultiloaderPacket::ID,
            MultiloaderPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
