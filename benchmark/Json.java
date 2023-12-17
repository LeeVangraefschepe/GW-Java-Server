package benchmark;
import networking.Server;
import packets.JsonPacket;

public class Json extends BaseBenchmark
{
    Server _server;
    public Json(Server server)
    {
        _server = server;
    }

    public void FullChunk()
    {
        JsonPacket packet = new JsonPacket();
        packet.SetInt16((short)20, "PacketId");
        packet.SetIVec2(0, 0, "Position");
        packet.SetUChar((byte)0, "Biome");
        packet.SetChunk(GenerateRandomChunk(), "Chunk");
        _server.SendAllUDP(packet.GetData());
    }
}
