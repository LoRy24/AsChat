package com.github.lory24.aschatapi.packets.bserver;

import com.github.lory24.aschatapi.packets.AbsPacket;
import com.google.gson.annotations.Expose;
import lombok.Getter;

public class HandshakeStartPacket extends AbsPacket<HandshakeStartPacket> {
    @Getter
    @Expose private final byte[] publicKey;

    protected HandshakeStartPacket(byte[] publicKey) {
        super(0x00);
        this.publicKey = publicKey;
        setData(this);
    }
}
