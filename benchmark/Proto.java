package benchmark;

import packet.PlayerJoinOuterClass.PlayerJoin;
import packet.Chunk.ChunkData;
import packet.PlayerUpdateOuterClass.PlayerUpdate;
import packet.BlockUpdateOuterClass.BlockUpdate;
import packet.InputOuterClass.Input;
import packet.ChatMessageOuterClass.ChatMessage;

public class Proto extends BaseBenchmark
{
    @Override
    public void TestReadWrite()
    {
        return;
    }

    @Override
    public void FullChunk()
    {
        var chunk = GenerateRandomChunk(384);

        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            var packetBuilder = ChunkData.newBuilder();
            packetBuilder.setPacketId(20);
            packetBuilder.setPosition(ChunkData.Vector2.newBuilder().setX(0).setY(0).build());
            packetBuilder.setBiome(0);

            for (short[][] row : chunk)
            {
                ChunkData.ChunkRow.Builder rowBuilder = ChunkData.ChunkRow.newBuilder();
                for (short[] slice : row)
                {
                    ChunkData.ChunkSlice.Builder sliceBuilder = ChunkData.ChunkSlice.newBuilder();
                    for (short value : slice)
                    {
                        sliceBuilder.addValues(value);
                    }
                    rowBuilder.addSlices(sliceBuilder.build());
                }
                packetBuilder.addChunk(rowBuilder.build());
            }

            var data = packetBuilder.build().toByteArray();
            allPackets.StopBenchmark();
            length += data.length;
        }

        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        var packetBuilder = ChunkData.newBuilder();
            packetBuilder.setPacketId(20);
            packetBuilder.setPosition(ChunkData.Vector2.newBuilder().setX(0).setY(0).build());
            packetBuilder.setBiome(0);

            for (short[][] row : chunk)
            {
                ChunkData.ChunkRow.Builder rowBuilder = ChunkData.ChunkRow.newBuilder();
                for (short[] slice : row)
                {
                    ChunkData.ChunkSlice.Builder sliceBuilder = ChunkData.ChunkSlice.newBuilder();
                    for (short value : slice)
                    {
                        sliceBuilder.addValues(value);
                    }
                    rowBuilder.addSlices(sliceBuilder.build());
                }
                packetBuilder.addChunk(rowBuilder.build());
            }

            var data = packetBuilder.build().toByteArray();

        FullChunk(data);
    }

    @Override
    public void PlayerUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            var packetBuilder = PlayerUpdate.newBuilder();
            packetBuilder.setPacketId(10);
            packetBuilder.setPlayerId(1564815618);
            packetBuilder.setPosition(PlayerUpdate.Vector3f.newBuilder().setX(100f).setY(72f).setZ(-500f).build());
            packetBuilder.setHealth(20);
            packetBuilder.setOnGround(false);
            packetBuilder.setRotation(PlayerUpdate.Vector3f.newBuilder().setX(20f).setY(50f).setZ(180f).build());
            packetBuilder.setHeadRotation(PlayerUpdate.Vector3f.newBuilder().setX(20f).setY(50f).setZ(180f).build());
            var data = packetBuilder.build().toByteArray();

            allPackets.StopBenchmark();
            length += data.length;
        }

        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        var packetBuilder = PlayerUpdate.newBuilder();
            packetBuilder.setPacketId(10);
            packetBuilder.setPlayerId(1564815618);
            packetBuilder.setPosition(PlayerUpdate.Vector3f.newBuilder().setX(100f).setY(72f).setZ(-500f).build());
            packetBuilder.setHealth(20);
            packetBuilder.setOnGround(false);
            packetBuilder.setRotation(PlayerUpdate.Vector3f.newBuilder().setX(20f).setY(50f).setZ(180f).build());
            packetBuilder.setHeadRotation(PlayerUpdate.Vector3f.newBuilder().setX(20f).setY(50f).setZ(180f).build());
            var data = packetBuilder.build().toByteArray();

        PlayerUpdate(data);
    }

    @Override
    public void BlockUpdate()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            var packetBuilder = BlockUpdate.newBuilder();
            packetBuilder.setPacketId(11);
            packetBuilder.setPosition(BlockUpdate.Vector3.newBuilder().setX(100).setY(72).setZ(-500).build());
            packetBuilder.setBlock(1500);
            packetBuilder.setBlockData(4);
            var data = packetBuilder.build().toByteArray();

            allPackets.StopBenchmark();
            length += data.length;
        }

        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        var packetBuilder = BlockUpdate.newBuilder();
            packetBuilder.setPacketId(11);
            packetBuilder.setPosition(BlockUpdate.Vector3.newBuilder().setX(100).setY(72).setZ(-500).build());
            packetBuilder.setBlock(1500);
            packetBuilder.setBlockData(4);
            var data = packetBuilder.build().toByteArray();

        BlockUpdate(data);
    }

    @Override
    public void Input()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            var packetBuilder = Input.newBuilder();
            packetBuilder.setPacketId(11);
            packetBuilder.setPlayerId(1564815618);
            packetBuilder.setInputType(58);
            packetBuilder.setInputAction(2);
            var data = packetBuilder.build().toByteArray();

            allPackets.StopBenchmark();
            length += data.length;
        }

        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        var packetBuilder = Input.newBuilder();
            packetBuilder.setPacketId(11);
            packetBuilder.setPlayerId(1564815618);
            packetBuilder.setInputType(58);
            packetBuilder.setInputAction(2);
            var data = packetBuilder.build().toByteArray();

        Input(data);
    }

    @Override
    public void PlayerJoin()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            var packetBuilder = PlayerJoin.newBuilder();
            packetBuilder.setPacketId(10);
            packetBuilder.setPlayerId(1564815618);
            packetBuilder.setMessage("lee_vgs123457890");
            packetBuilder.setPosition(PlayerJoin.Vector3f.newBuilder().setX(100f).setY(72f).setZ(-500f).build());
            var data = packetBuilder.build().toByteArray();

            allPackets.StopBenchmark();
            length += data.length;
        }

        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        var packetBuilder = PlayerJoin.newBuilder();
        packetBuilder.setPacketId(10);
        packetBuilder.setPlayerId(1564815618);
        packetBuilder.setMessage("lee_vgs123457890");
        packetBuilder.setPosition(PlayerJoin.Vector3f.newBuilder().setX(100f).setY(72f).setZ(-500f).build());
        var data = packetBuilder.build().toByteArray();

        PlayerJoin(data);
    }

    @Override
    public void ChatMessage()
    {
        Benchmark allPackets = new Benchmark();
        long length = 0;
        for (int x = 0; x < _amountSmall; ++x)
        {
            allPackets.StartBenchmark();

            var packetBuilder = ChatMessage.newBuilder();
            packetBuilder.setPacketId(14);
            packetBuilder.setPlayerId(1564815618);
            packetBuilder.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis arcu ex, fermentum et faucibus facilisis, eleifend eget lacus. Mauris ex tortor, efficitur sit amet blandit ut, lacinia ultrices ante. Integer condimentum in.");
            var data = packetBuilder.build().toByteArray();

            allPackets.StopBenchmark();
            length += data.length;
        }

        System.out.println("Total packets length: " + length / _amountSmall);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");

        var packetBuilder = ChatMessage.newBuilder();
            packetBuilder.setPacketId(14);
            packetBuilder.setPlayerId(1564815618);
            packetBuilder.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis arcu ex, fermentum et faucibus facilisis, eleifend eget lacus. Mauris ex tortor, efficitur sit amet blandit ut, lacinia ultrices ante. Integer condimentum in.");
            var data = packetBuilder.build().toByteArray();

        ChatMessage(data);
    }

    @Override
    public void FullChunk(byte[] data)
    {
        ChunkData packet = null;
        int packetId = 0, biome = 0;
        int[] position = new int[2];
        short[][][] chunk = new short[1][1][1];
        
        Benchmark allPackets = new Benchmark();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            try
            {
                packet = ChunkData.parseFrom(data);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return;
            }

            packetId = packet.getPacketId();
            position[0] = packet.getPosition().getX();
            position[1] = packet.getPosition().getY();
            biome = packet.getBiome();

            // Read out chunk
            int numRows = packet.getChunkCount();
            int numSlices = packet.getChunk(0).getSlicesCount();
            int numValues = packet.getChunk(0).getSlices(0).getValuesCount();
            chunk = new short[numRows][numSlices][numValues];

            for (int i = 0; i < numRows; i++)
            {
                ChunkData.ChunkRow row = packet.getChunk(i);
                for (int j = 0; j < numSlices; j++)
                {
                    ChunkData.ChunkSlice slice = row.getSlices(j);
                    for (int k = 0; k < numValues; k++)
                    {
                        chunk[i][j][k] = (short)slice.getValues(k);
                    }   
                }
            }

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
        Input packet = null;

        int playerId = 0, packetId = 0, inputAction = 0, inputType = 0;
        
        Benchmark allPackets = new Benchmark();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            try
            {
                packet = Input.parseFrom(data);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return;
            }

            packetId = packet.getPacketId();
            playerId = packet.getPlayerId();
            inputAction = packet.getInputAction();
            inputType = packet.getInputType();

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
        BlockUpdate packet = null;

        int packetId = 0, blockId = 0, blockData = 0;
        int[] position = new int[3];
        
        Benchmark allPackets = new Benchmark();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            try
            {
                packet = BlockUpdate.parseFrom(data);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return;
            }

            packetId = packet.getPacketId();
            position[0] = packet.getPosition().getX();
            position[1] = packet.getPosition().getY();
            position[2] = packet.getPosition().getZ();
            blockId = packet.getBlock();
            blockData = packet.getBlockData();

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
        PlayerUpdate packet = null;

        int playerId = 0, health = 0, packetId = 0;
        float[] position = new float[3];
        float[] rotation = new float[3];
        float[] headRotation = new float[3];
        boolean onGround = true;
        
        Benchmark allPackets = new Benchmark();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            try
            {
                packet = PlayerUpdate.parseFrom(data);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return;
            }

            packetId = packet.getPacketId();
            playerId = packet.getPlayerId();

            position[0] = packet.getPosition().getX();
            position[1] = packet.getPosition().getY();
            position[2] = packet.getPosition().getZ();

            health = packet.getHealth();
            onGround = packet.getOnGround();

            rotation[0] = packet.getRotation().getX();
            rotation[1] = packet.getRotation().getY();
            rotation[2] = packet.getRotation().getZ();

            headRotation[0] = packet.getHeadRotation().getX();
            headRotation[1] = packet.getHeadRotation().getY();
            headRotation[2] = packet.getHeadRotation().getZ();

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
        PlayerJoin packet = null;

        int playerId = 0, packetId = 0;
        float[] position = new float[3];
        String message = "";
        
        Benchmark allPackets = new Benchmark();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            try
            {
                packet = PlayerJoin.parseFrom(data);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return;
            }

            packetId = packet.getPacketId();
            playerId = packet.getPlayerId();
            position[0] = packet.getPosition().getX();
            position[1] = packet.getPosition().getY();
            position[2] = packet.getPosition().getZ();
            message = packet.getMessage();

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
        ChatMessage packet = null;

        int playerId = 0, packetId = 0;
        String message = "";
        
        Benchmark allPackets = new Benchmark();
        for (int x = 0; x < _amountLarge; ++x)
        {
            allPackets.StartBenchmark();
            
            try
            {
                packet = ChatMessage.parseFrom(data);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return;
            }

            packetId = packet.getPacketId();
            playerId = packet.getPlayerId();
            message = packet.getMessage();

            allPackets.StopBenchmark();
        }
        
        System.out.println("PacketId " + packetId);
        System.out.println("PlayerId " + playerId);
        System.out.println("Message " + message);
        System.out.println("Execution time average: " + allPackets.GetAverageMs() + "ms");
    }
}
