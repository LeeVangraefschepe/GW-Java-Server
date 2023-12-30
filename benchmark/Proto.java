package benchmark;

import packet.PlayerJoinOuterClass.PlayerJoin;
import packet.PlayerJoinOuterClass.PlayerJoin.Vector3f;

public class Proto extends BaseBenchmark
{
    public Proto()
    {
        PlayerJoin packet = PlayerJoin.newBuilder().setPacketId(0).setMessage("").setPlayerId(0).build();
        System.out.println(packet.toString());
    }

    @Override
    public void TestReadWrite()
    {
        return;
    }

    @Override
    public void FullChunk()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'FullChunk'");
    }

    @Override
    public void PlayerUpdate()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PlayerUpdate'");
    }

    @Override
    public void BlockUpdate()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BlockUpdate'");
    }

    @Override
    public void Input()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Input'");
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
            packetBuilder.setPosition(Vector3f.newBuilder().setX(100f).setY(72f).setZ(-500f).build());
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
        packetBuilder.setPosition(Vector3f.newBuilder().setX(100f).setY(72f).setZ(-500f).build());
        var data = packetBuilder.build().toByteArray();

        PlayerJoin(data);
    }

    @Override
    public void ChatMessage()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ChatMessage'");
    }

    @Override
    public void FullChunk(byte[] data)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'FullChunk'");
    }

    @Override
    public void Input(byte[] data)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Input'");
    }

    @Override
    public void BlockUpdate(byte[] data)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BlockUpdate'");
    }

    @Override
    public void PlayerUpdate(byte[] data)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PlayerUpdate'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ChatMessage'");
    }
}
