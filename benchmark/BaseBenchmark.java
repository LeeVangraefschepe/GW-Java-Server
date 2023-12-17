package benchmark;

import java.util.Random;

public class BaseBenchmark
{
    protected short[][][] GenerateRandomChunk()
    {
        Random rand = new Random(); 
        short[][][] blockData = new short[16][48][16];

        for (short[][] array2d : blockData)
        {
            for (short[] array1d : array2d)
            {
                for (int i = 0; i < array1d.length; ++i)
                {
                    array1d[i] = (short)rand.nextInt(1500);
                }
            }
        }

        return blockData;
    }
}