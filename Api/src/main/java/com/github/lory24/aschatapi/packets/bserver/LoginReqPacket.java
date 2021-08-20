package com.github.lory24.aschatapi.packets.bserver;

import com.github.lory24.aschatapi.packets.AbsPacket;
import com.google.gson.annotations.Expose;
import lombok.Getter;

public class LoginReqPacket extends AbsPacket<LoginReqPacket> {
    @Getter @Expose private final String mailA;
    @Getter
    @Expose private final String pass;

    public LoginReqPacket(String mailA, String pass) {
        super(0x02);
        this.mailA = mailA;
        this.pass = pass;
        setData(this);
    }
}
