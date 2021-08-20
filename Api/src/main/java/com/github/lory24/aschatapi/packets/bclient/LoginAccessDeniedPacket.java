package com.github.lory24.aschatapi.packets.bclient;

import com.github.lory24.aschatapi.packets.AbsPacket;

public class LoginAccessDeniedPacket extends AbsPacket<LoginAccessDeniedPacket> {

    public LoginAccessDeniedPacket() {
        super(0x03);
        setData(this);
    }
}
