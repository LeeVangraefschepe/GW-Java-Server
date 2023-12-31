import java.util.Scanner;

import benchmark.BaseBenchmark;
import benchmark.*;

public class MainClass
{
    public static void main(String[] args)
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        Scanner scanner = new Scanner(System.in);

        BaseBenchmark benchmark = new Xml();
        benchmark.TestReadWrite();
        benchmark.SetBenchmarkAmount(1, 1);

        while (true)
        {
            String input = scanner.nextLine();
            if (input.compareToIgnoreCase("stop") == 0) break;
            
            if (input.compareToIgnoreCase("chunk") == 0) benchmark.FullChunk();
            if (input.compareToIgnoreCase("player update") == 0) benchmark.PlayerUpdate();
            if (input.compareToIgnoreCase("block update") == 0) benchmark.BlockUpdate();
            if (input.compareToIgnoreCase("input") == 0) benchmark.Input();
            if (input.compareToIgnoreCase("player join") == 0) benchmark.PlayerJoin();
            if (input.compareToIgnoreCase("chat message") == 0) benchmark.ChatMessage();

            if (input.compareToIgnoreCase("one shot") == 0) benchmark.SetBenchmarkAmount(1, 1);
            if (input.compareToIgnoreCase("big shot") == 0) benchmark.SetBenchmarkAmount(100, 1000);
        }

        scanner.close();
    }
}