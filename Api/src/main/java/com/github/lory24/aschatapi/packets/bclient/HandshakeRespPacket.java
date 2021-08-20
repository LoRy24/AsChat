package com.github.lory24.aschatapi.packets.bclient;

import com.github.lory24.aschatapi.packets.AbsPacket;
import com.google.gson.annotations.Expose;
import lombok.Getter;

public class HandshakeRespPacket extends AbsPacket<HandshakeRespPacket> {
    @Getter
    @Expose private final byte[] publicKey;

    protected HandshakeRespPacket(byte[] publicKey) {
        super(0x01);
        this.publicKey = publicKey;
        setData(this);
    }
}
