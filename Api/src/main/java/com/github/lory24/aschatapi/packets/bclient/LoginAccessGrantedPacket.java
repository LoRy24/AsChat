package com.github.lory24.aschatapi.packets.bclient;

import com.github.lory24.aschatapi.packets.AbsPacket;
import com.google.gson.annotations.Expose;
import lombok.Getter;

import java.util.UUID;

public class LoginAccessGrantedPacket extends AbsPacket<LoginAccessGrantedPacket> {
    @Getter
    @Expose private final UUID uuid;

    public LoginAccessGrantedPacket(UUID uuid) {
        super(0x04);
        this.uuid = uuid;
        setData(this);
    }
}
