package benchmark;

public abstract class BaseBenchmark
{
    protected int _amountLarge = 5000;
    protected int _amountSmall = 50000;

    protected short[][][] GenerateRandomChunk(int height)
    {
        short[][][] blockData = new short[16][height][16];

        for (short[][] array2d : blockData)
        {
            for (short[] array1d : array2d)
            {
                for (int i = 0; i < array1d.length; ++i)
                {
                    array1d[i] = 100;
                }
            }
        }

        return blockData;
    }

    public void SetBenchmarkAmount(int amountLarge, int amountSmall)
    {
        _amountLarge = amountLarge;
        _amountSmall = amountSmall;
    }

    public abstract void TestReadWrite();
    public abstract void FullChunk();
    public abstract void PlayerUpdate();
    public abstract void BlockUpdate();
    public abstract void Input();
    public abstract void PlayerJoin();
    public abstract void ChatMessage();

    public abstract void FullChunk(byte[] data);
    public abstract void Input(byte[] data);
    public abstract void BlockUpdate(byte[] data);
    public abstract void PlayerUpdate(byte[] data);
    public abstract void PlayerJoin(byte[] data);
    public abstract void ChatMessage(byte[] data);

    public class Benchmark
    {
        private long _startTime;
        private double _averageTotal = 0f;
        private int _amount = 0;
        protected void StartBenchmark()
        {
            _startTime = System.nanoTime();
        }

        protected double StopBenchmark()
        {
            long endTime = System.nanoTime();

            // Calculate and print the execution time
            long executionTimeInNanos = endTime - _startTime;
            double executionTimeInMillis = (double)executionTimeInNanos / 1_000_000;

            _averageTotal += executionTimeInMillis;
            ++_amount;

            return executionTimeInMillis;
        }

        protected double GetAverageMs()
        {
            return _averageTotal / _amount;
        }
    }
}