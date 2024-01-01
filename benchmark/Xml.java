package benchmark;

import packets.BasePacket;
import packets.XmlPacket;

public class Xml extends BaseBenchmark
{
    @Override
    public void TestReadWrite()
    {
        System.out.println("Test read write.");
        var chunk = GenerateRandomChunk(32);

        BasePacket packet = new XmlPacket();
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
    public void FullChunk()
    {
        var chunk = GenerateRandomChunk(384);

        Benchmark allPackets = new Benchmark();
        XmlPacket packet = new XmlPacket();
        long length = 0;
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            packet.Clear();
            packet.SetInt16((short)20, "PacketId");
            packet.SetIVec2(0, 0, "Position");
            packet.SetUChar((byte)0, "Biome");
            packet.SetChunk(chunk, "Chunk");
                
            var data = packet.GetData();
            length += data.length();
            allPackets.StopBenchmark();
        }
        
        System.out.println("Total packets length: " + length / _amountLarge);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        FullChunk(packet.GetData().getBytes());
    }

    @Override
    public void PlayerUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        XmlPacket packet = new XmlPacket();
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();
            packet.Clear();
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
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        PlayerUpdate(packet.GetData().getBytes());
    }

    @Override
    public void BlockUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        XmlPacket packet = new XmlPacket();
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            packet.Clear();
            packet.SetInt16((short)11, "PacketId");
            packet.SetIVec3(100, 72, -500, "Position");
            packet.SetInt16((short)1500, "BlockId");
            packet.SetUChar((byte)4, "BlockData");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        BlockUpdate(packet.GetData().getBytes());
    }

    @Override
    public void Input()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        XmlPacket packet = new XmlPacket();
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            packet.Clear();
            packet.SetInt16((short)12, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetUChar((byte)58, "InputType");
            packet.SetUChar((byte)2, "InputAction");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        Input(packet.GetData().getBytes());
    }

    @Override
    public void PlayerJoin()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        XmlPacket packet = new XmlPacket();
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            packet.Clear();
            packet.SetInt16((short)13, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetString("lee_vgs123457890", "Message");
            packet.SetFloat3(100f, 72f, -500f, "Position");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        PlayerJoin(packet.GetData().getBytes());
    }

    @Override
    public void ChatMessage()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        XmlPacket packet = new XmlPacket();
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            packet.Clear();
            packet.SetInt16((short)14, "PacketId");
            packet.SetInt32((int)1564815618, "PlayerId");
            packet.SetString("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis arcu ex, fermentum et faucibus facilisis, eleifend eget lacus. Mauris ex tortor, efficitur sit amet blandit ut, lacinia ultrices ante. Integer condimentum in.", "Message");
            var data = packet.GetData();

            allPackets.StopBenchmark();
            length += data.length();
        }
        
        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
        
        ChatMessage(packet.GetData().getBytes());
    }

    @Override
    public void FullChunk(byte[] data)
    {
        short[][][] chunk = new short[1][1][1];
        int[] position = new int[1];
        int biome = 0, packetId = 0;
        Benchmark allPackets = new Benchmark();

        BasePacket packet = new XmlPacket();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            packet.SetData(data);
            packetId = packet.GetInt16("PacketId");
            chunk = packet.GetChunk("Chunk");
            position = packet.GetIVec2("Position");
            biome = packet.GetInt32("Biome");
            allPackets.StopBenchmark();
        }
        
        System.out.println("PacketId " + packetId);
        System.out.println("Block[0,0,0] " + chunk[0][0][0]);
        System.out.println("Position (" + position[0] + "," + position[1] + ")");
        System.out.println("Biome " + biome);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void Input(byte[] data)
    {
        short packetId = 0;
        int playerId = 0;
        byte inputType = 0, inputAction = 0;

        Benchmark allPackets = new Benchmark();

        BasePacket packet = new XmlPacket();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            packet.SetData(data);
            packetId = packet.GetInt16("PacketId");
            playerId = packet.GetInt32("PlayerId");
            inputType = packet.GetUChar("InputType");
            inputAction = packet.GetUChar("InputAction");
            allPackets.StopBenchmark();
        }
        
        System.out.println("PacketId " + packetId);
        System.out.println("PlayerId " + playerId);
        System.out.println("InputType " + inputType);
        System.out.println("InputAction " + inputAction);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void BlockUpdate(byte[] data)
    {
        short packetId = 0, blockId = 0;
        int[] position = new int[1];
        byte blockData = 0;

        Benchmark allPackets = new Benchmark();
        BasePacket packet = new XmlPacket();

        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            packet.SetData(data);

            packetId = packet.GetInt16("PacketId");
            position = packet.GetIVec3("Position");
            blockId = packet.GetInt16("BlockId");
            blockData = packet.GetUChar("BlockData");
            allPackets.StopBenchmark();
        }
        
        System.out.println("PacketId " + packetId);
        System.out.println("Position (" + position[0] + "," + position[1] + "," + position[2] + ")");
        System.out.println("BlockId " + blockId);
        System.out.println("BlockData " + blockData);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void PlayerUpdate(byte[] data)
    {
        short packetId = 0;
        int playerId = 0;
        float[] position = new float[1];
        float[] rotation = new float[1];
        float[] headRotation = new float[1];
        boolean onGround = true;
        byte health = 0;


        Benchmark allPackets = new Benchmark();
        BasePacket packet = new XmlPacket();

        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            packet.SetData(data);
            
            packetId = packet.GetInt16("PacketId");
            playerId = packet.GetInt32("PlayerId");
            position = packet.GetFloat3("Position");
            health = packet.GetUChar("Health");
            onGround = packet.GetBoolean("OnGround");
            rotation = packet.GetFloat3("Rotation");
            headRotation = packet.GetFloat3("HeadRotation");
            allPackets.StopBenchmark();
        }
        
        System.out.println("PacketId " + packetId);
        System.out.println("PlayerId " + playerId);
        System.out.println("Position (" + position[0] + "," + position[1] + "," + position[2] + ")");
        System.out.println("Health " + health);
        System.out.println("OnGround " + onGround);
        System.out.println("Rotation (" + rotation[0] + "," + rotation[1] + "," + rotation[2] + ")");
        System.out.println("HeadRotation (" + headRotation[0] + "," + headRotation[1] + "," + headRotation[2] + ")");
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void PlayerJoin(byte[] data)
    {
        short packetId = 0;
        int playerId = 0;
        float[] position = new float[1];
        String message = "";

        Benchmark allPackets = new Benchmark();
        BasePacket packet = new XmlPacket();

        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();

            packet.SetData(data);
            packetId = packet.GetInt16("PacketId");
            playerId = packet.GetInt32("PlayerId");
            position = packet.GetFloat3("Position");
            message = packet.GetString("Message");
            allPackets.StopBenchmark();
        }
        
        System.out.println("PacketId " + packetId);
        System.out.println("PlayerId " + playerId);
        System.out.println("Message " + message);
        System.out.println("Position (" + position[0] + "," + position[1] + "," + position[2] + ")");
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }

    @Override
    public void ChatMessage(byte[] data)
    {
        short packetId = 0;
        int playerId = 0;
        String message = "";

        Benchmark allPackets = new Benchmark();
        BasePacket packet = new XmlPacket();

        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            packet.SetData(data);
            packetId = packet.GetInt16("PacketId");
            playerId = packet.GetInt32("PlayerId");
            message = packet.GetString("Message");
            allPackets.StopBenchmark();
        }
        
        System.out.println("PacketId " + packetId);
        System.out.println("PlayerId " + playerId);
        System.out.println("Message " + message);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }
}