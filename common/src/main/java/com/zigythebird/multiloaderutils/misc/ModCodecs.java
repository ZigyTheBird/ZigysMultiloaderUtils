package com.zigythebird.multiloaderutils.misc;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.Utf8String;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public interface ModCodecs {
    StreamCodec<ByteBuf, FriendlyByteBuf> FRIENDLY_BYTE_BUF = new StreamCodec<ByteBuf, FriendlyByteBuf>() {
        public FriendlyByteBuf decode(ByteBuf byteBuf) {
            return new FriendlyByteBuf(byteBuf.readBytes(byteBuf.readInt()));
        }

        public void encode(ByteBuf byteBuf, FriendlyByteBuf buf) {
            byteBuf.writeInt(buf.readableBytes());
            byteBuf.writeBytes(buf);
        }
    };

    StreamCodec<ByteBuf, ResourceLocation> RESOURCELOCATION = new StreamCodec<ByteBuf, ResourceLocation>() {
        public ResourceLocation decode(ByteBuf byteBuf) {
            return ResourceLocation.parse(Utf8String.read(byteBuf, 32767));
        }

        public void encode(ByteBuf byteBuf, ResourceLocation buf) {
            Utf8String.write(byteBuf, buf.toString(), 32767);
        }
    };
}
