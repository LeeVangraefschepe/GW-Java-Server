package packets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JsonPacket implements BasePacket
{
    JSONObject _jsonObject = new JSONObject();

    //#region Getters
    @Override
    public String GetData()
    {
        return _jsonObject.toJSONString();
    }
    @Override
    public byte GetUChar(String key)
    {
        return ((Number)_jsonObject.get(key)).byteValue();
    }
    @Override
    public int GetInt32(String key)
    {
        return ((Number)_jsonObject.get(key)).intValue();
    }
    @Override
    public short GetInt16(String key)
    {
        return ((Number)_jsonObject.get(key)).shortValue();
    }
    @Override
    public float[] GetFloat3(String key)
    {
        float[] data = new float[3];
        JSONArray jsonArray = (JSONArray)_jsonObject.get(key);
        for (int i = 0; i < data.length; i++)
        {
            data[i] = ((Number) jsonArray.get(i)).floatValue();
        }
        return data;
    }
    @Override
    public boolean GetBoolean(String key)
    {
        return (boolean)_jsonObject.get(key);
    }
    @Override
    public int[] GetIVec2(String key)
    {
        int[] data = new int[2];
        JSONArray jsonArray = (JSONArray)_jsonObject.get(key);
        for (int i = 0; i < data.length; i++)
        {
            data[i] = ((Number)jsonArray.get(i)).intValue();
        }
        return data;
    }
    @Override
    public int[] GetIVec3(String key)
    {
        int[] data = new int[3];
        JSONArray jsonArray = (JSONArray)_jsonObject.get(key);
        for (int i = 0; i < data.length; i++)
        {
            data[i] = ((Number)jsonArray.get(i)).intValue();
        }
        return data;
    }
    @Override
    public String GetString(String key)
    {
        return (String)_jsonObject.get(key);
    }
    @Override
    public short[][][] GetChunk(String key)
    {
        JSONArray jsonArray = (JSONArray)_jsonObject.get(key);

        short[][][] result = new short[jsonArray.size()][][];
        for (int i = 0; i < jsonArray.size(); i++)
        {
            JSONArray innerArray = (JSONArray) jsonArray.get(i);
            result[i] = new short[innerArray.size()][];
            for (int j = 0; j < innerArray.size(); j++)
            {
                JSONArray innermostArray = (JSONArray) innerArray.get(j);
                result[i][j] = new short[innermostArray.size()];
                for (int k = 0; k < innermostArray.size(); k++)
                {
                    result[i][j][k] = ((Number) innermostArray.get(k)).shortValue();
                }
            }
        }
        return result;
    }
    //#endregion

    //#region Setters
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
    @Override
    public void SetUChar(byte value, String key)
    {
        _jsonObject.put(key, value);
    }
    @Override
    public void SetInt32(int value, String key)
    {
        _jsonObject.put(key, value);
    }
    @Override
    public void SetInt16(short value, String key)
    {
        _jsonObject.put(key, value);
    }
    @Override
    public void SetFloat3(float x, float y, float z, String key)
    {
        JSONArray data = new JSONArray();
        data.add(x);
        data.add(y);
        _jsonObject.put(key, data);
    }
    @Override
    public void SetBoolean(boolean value, String key)
    {
        _jsonObject.put(key, value);
    }
    @Override
    public void SetIVec2(int x, int y, String key)
    {
        JSONArray data = new JSONArray();
        data.add(x);
        data.add(y);
        _jsonObject.put(key, data);
    }
    @Override
    public void SetIVec3(int x, int y, int z, String key)
    {
        JSONArray data = new JSONArray();
        data.add(x);
        data.add(y);
        data.add(z);
        _jsonObject.put(key, data);
    }
    @Override
    public void SetString(String value, String key)
    {
        _jsonObject.put(key, value);
    }
    @Override
    public void SetChunk(short[][][] value, String key)
    {
        _jsonObject.put(key, Convert3DArrayToJsonArray(value));
    }
    //#endregion

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