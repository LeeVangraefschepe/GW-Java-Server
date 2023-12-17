package packets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JsonPacket implements BasePacket
{
    JSONObject _jsonObject = new JSONObject();

    @Override
    public String GetData()
    {
        return _jsonObject.toJSONString();
    }

    @Override
    public void SetData(byte[] data)
    {
        var text = new String(data, 0, data.length);
        JSONParser parser = new JSONParser();

        try
        {
            _jsonObject = (JSONObject)parser.parse(text);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void SetUChar(byte value, String key)
    {
        _jsonObject.put(key, value);
    }
    public void SetInt32(int value, String key)
    {
        _jsonObject.put(key, value);
    }
    public void SetInt16(short value, String key)
    {
        _jsonObject.put(key, value);
    }
    public void SetFloat3(float x, float y, float z, String key)
    {
        _jsonObject.put(key+"x", x);
        _jsonObject.put(key+"y", y);
        _jsonObject.put(key+"z", z);
    }
    public void SetBoolean(boolean value, String key)
    {
        _jsonObject.put(key, value);
    }
    public void SetIVec2(int x, int y, String key)
    {
        _jsonObject.put(key+"x", x);
        _jsonObject.put(key+"y", y);
    }
    public void SetIVec3(int x, int y, int z, String key)
    {
        _jsonObject.put(key+"x", x);
        _jsonObject.put(key+"y", y);
        _jsonObject.put(key+"z", z);
    }
    public void SetString(String value, String key)
    {
        _jsonObject.put(key, value);
    }
    public void SetChunk(short[][][] value, String key)
    {
        _jsonObject.put(key, Convert3DArrayToJsonArray(value));
    }

    private static JSONArray Convert3DArrayToJsonArray(short[][][] array3D)
    {
        JSONArray result = new JSONArray();
        for (short[][] array2D : array3D)
        {
            JSONArray array2DJson = new JSONArray();

            for (short[] array1D : array2D)
            {
                JSONArray array1DJson = new JSONArray();
                for (short value : array1D)
                {
                    array1DJson.add(value);
                }
                array2DJson.add(array1DJson);
            }
            result.add(array2DJson);
        }
        return result;
    }
}