package packets;

public interface BasePacket
{
    public String GetData();
    public void SetData(byte[] data);

    //public void SetUChar(byte value);
    //public void SetInt32(int value);
    //public void SetInt16(short value);
    //public void SetFloat3(float x, float y, float z);
    //public void SetBoolean(boolean value);
    //public void SetIVec2(int x, int y);
    //public void SetIVec3(int x, int y, int z);
    //public void SetString(String value);
    //public void SetChunk(int[][][] value);
}