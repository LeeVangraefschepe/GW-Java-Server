package benchmark;
//import java.util.concurrent.TimeUnit;

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
        int length = 0;
        for (int x = 0; x < 5000; ++x)
        {
            length = 0;
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

            /*try
            {
                TimeUnit.MILLISECONDS.sleep(100);
                
            } catch (Exception e)
            {
                e.printStackTrace();
            }*/
        }
        
        System.out.println("Total packets length: " + length);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }
}