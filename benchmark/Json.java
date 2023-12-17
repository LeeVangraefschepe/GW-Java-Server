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
        var chunk = GenerateRandomChunk(48);
        JsonPacket[] packets = new JsonPacket[8];

        Benchmark allPackets = new Benchmark();
        long length = 0;
        int amount = 5000;
        for (int x = 0; x < amount; ++x)
        {
            allPackets.StartBenchmark();
            for (int i = 0; i < packets.length; ++i)
            {
                JsonPacket packet = new JsonPacket();
                packet.SetInt16((short)20, "PacketId");
                packet.SetIVec2(0, 0, "Position");
                packet.SetUChar((byte)0, "Biome");
                packet.SetChunk(chunk, "Chunk");
                var data = packet.GetData();
                length += data.length();
            }
            allPackets.StopBenchmark();
        }
        
        System.out.println("Total packets length: " + length / amount);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    public void PlayerUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        int amount = 50000;
        for (int x = 0; x < amount; ++x)
        {
            allPackets.StartBenchmark();

            JsonPacket packet = new JsonPacket();
            packet.SetInt16((short)20, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetFloat3(100f, 72f, -500f, "Position");
            packet.SetUChar((byte)20, "Health");
            packet.SetBoolean(false, "OnGround");
            packet.SetFloat3(20f, 50f, 180f, "Rotation");
            packet.SetFloat3(20f, 50f, 180f, "HeadRotation");
            var data = packet.GetData();
            
            allPackets.StopBenchmark();
            length += data.length();
        }
        
        System.out.println("Total packets length: " + length / amount);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    public void BlockUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        int amount = 50000;
        for (int x = 0; x < amount; ++x)
        {
            allPackets.StartBenchmark();

            JsonPacket packet = new JsonPacket();
            packet.SetInt16((short)20, "PacketId");
            packet.SetFloat3(100f, 72f, -500f, "Position");
            packet.SetInt16((short)1500, "BlockId");
            packet.SetUChar((byte)4, "BlockData");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
        }
        
        System.out.println("Total packets length: " + length / amount);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }
}