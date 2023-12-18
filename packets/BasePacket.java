package packets;

public interface BasePacket
{
    public String GetData();
    public void SetData(byte[] data);

    public void SetUChar(byte value, String key);
    public void SetInt32(int value, String key);
    public void SetInt16(short value, String key);
    public void SetFloat3(float x, float y, float z, String key);
    public void SetBoolean(boolean value, String key);
    public void SetIVec2(int x, int y, String key);
    public void SetIVec3(int x, int y, int z, String key);
    public void SetString(String value, String key);
    public void SetChunk(short[][][] value, String key);

    public byte GetUChar(String key);
    public int GetInt32(String key);
    public short GetInt16(String key);
    public float[] GetFloat3(String key);
    public boolean GetBoolean(String key);
    public int[] GetIVec2(String key);
    public int[] GetIVec3(String key);
    public String GetString(String key);
    public short[][][] GetChunk(String key);
}