package io.github.gelx_.netAudioControl.protocol;

import io.github.gelx_.protocollib.protocol.Packet;
import io.github.gelx_.protocollib.protocol.PacketHandler;
import io.github.gelx_.protocollib.protocol.Protocol;

import java.util.HashMap;

public class MyProtocol extends Protocol{


    public MyProtocol(Class<? extends PacketHandler> handlerClass) {
        super(handlerClass);
    }

    @Override
    public HashMap<Short, Class<? extends Packet>> registerPackets() {
        return null;
    }
}
