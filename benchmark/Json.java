package benchmark;

import networking.Server;
import packets.BasePacket;
import packets.JsonPacket;

public class Json extends BaseBenchmark
{
    Server _server;
    public Json(Server server)
    {
        _server = server;
    }

    @Override
    public void FullChunk()
    {
        var chunk = GenerateRandomChunk(48);
        BasePacket[] packets = new JsonPacket[8];

        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            for (int i = 0; i < packets.length; ++i)
            {
                BasePacket packet = new JsonPacket();
                packet.SetInt16((short)20, "PacketId");
                packet.SetIVec2(0, 0, "Position");
                packet.SetUChar((byte)0, "Biome");
                packet.SetChunk(chunk, "Chunk");
                
                var data = packet.GetData();
                length += data.length();
            }
            allPackets.StopBenchmark();
        }

        BasePacket packet = new JsonPacket();
        for (int i = 0; i < packets.length; ++i)
        {
                
            packet.SetInt16((short)20, "PacketId");
            packet.SetIVec2(0, 0, "Position");
            packet.SetUChar((byte)0, "Biome");
            packet.SetChunk(chunk, "Chunk");

            if (_sendPacket) _server.SendAllUDP(packet.GetData());
        }
        
        System.out.println("Total packets length: " + length / _amountLarge);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        FullChunk(packet.GetData());
    }

    @Override
    public void PlayerUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            BasePacket packet = new JsonPacket();
            packet.SetInt16((short)10, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetFloat3(100f, 72f, -500f, "Position");
            packet.SetUChar((byte)20, "Health");
            packet.SetBoolean(false, "OnGround");
            packet.SetFloat3(20f, 50f, 180f, "Rotation");
            packet.SetFloat3(20f, 50f, 180f, "HeadRotation");
            var data = packet.GetData();
            
            allPackets.StopBenchmark();
            length += data.length();
            if (_sendPacket) _server.SendAllUDP(data);
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void BlockUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            BasePacket packet = new JsonPacket();
            packet.SetInt16((short)11, "PacketId");
            packet.SetIVec3(100, 72, -500, "Position");
            packet.SetInt16((short)1500, "BlockId");
            packet.SetUChar((byte)4, "BlockData");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
            if (_sendPacket) _server.SendAllUDP(data);
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void Input()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            BasePacket packet = new JsonPacket();
            packet.SetInt16((short)12, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetUChar((byte)58, "InputType");
            packet.SetUChar((byte)2, "InputAction");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
            if (_sendPacket) _server.SendAllUDP(data);
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void PlayerJoin()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            BasePacket packet = new JsonPacket();
            packet.SetInt16((short)13, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetString("lee_vgs123457890", "Message");
            packet.SetFloat3(100f, 72f, -500f, "Position");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
            if (_sendPacket) _server.SendAllUDP(data);
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void ChatMessage()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            BasePacket packet = new JsonPacket();
            packet.SetInt16((short)14, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetString("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis arcu ex, fermentum et faucibus facilisis, eleifend eget lacus. Mauris ex tortor, efficitur sit amet blandit ut, lacinia ultrices ante. Integer condimentum in.", "Message");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
            if (_sendPacket) _server.SendAllUDP(data);
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void TestReadWrite()
    {
        System.out.println("Test read write.");
        var chunk = GenerateRandomChunk(32);

        BasePacket packet = new JsonPacket();
        packet.SetInt16((short)20, "PacketId");
        packet.SetIVec2(0, 0, "Position");
        packet.SetUChar((byte)0, "Biome");
        packet.SetChunk(chunk, "Chunk");

        if (packet.GetInt16("PacketId") != (short)20) System.out.println("Int16 failed test");
        if (packet.GetIVec2("Position")[0] != 0) System.out.println("IVec2x failed test");
        if (packet.GetIVec2("Position")[1] != 0) System.out.println("IVec2y failed test");
        if (packet.GetUChar("Biome") != (byte)0) System.out.println("UChar failed test");
        if (packet.GetChunk("Chunk")[10][20][9] != chunk[10][20][9]) System.out.println("Chunk failed test");

        System.out.println("Test is done.");
    }

    @Override
    public void FullChunk(String data)
    {
        short[][][] chunk = new short[1][1][1];
        int[] position = new int[1];
        int biome = 0;
        Benchmark allPackets = new Benchmark();

        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            JsonPacket packet = new JsonPacket();
            packet.SetData(data.getBytes());
            chunk = packet.GetChunk("Chunk");
            position = packet.GetIVec2("Position");
            biome = packet.GetInt32("Biome");
            allPackets.StopBenchmark();
        }
        

        System.out.println("Block[0,0,0] " + chunk[0][0][0]);
        System.out.println("Position (" + position[0] + "," + position[1] + ")");
        System.out.println("Biome " + biome);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }
}