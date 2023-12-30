package benchmark;

import packet.PlayerJoinOuterClass.PlayerJoin;

public class Proto
{
    public Proto()
    {
        PlayerJoin packet = PlayerJoin.newBuilder().setPacketId(0).setMessage("").setPlayerId(0).build();
        System.out.println(packet.toString());
    }
}
