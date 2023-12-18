import java.util.Scanner;

import benchmark.Json;
import networking.Server;

public class MainClass
{
    public static void main(String[] args)
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        Scanner scanner = new Scanner(System.in);

        System.out.println("Started server on port: 7777");
        Server server = new Server(7777);
        server.StartListening();

        Json benchmark = new Json(server);
        benchmark.TestReadWrite();

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

            if (input.compareToIgnoreCase("print") == 0)
            {
                var packet = server.GetPacket();
                if (packet == null)
                {
                    System.out.println("No new packets to print");
                    continue;
                }
                while (packet != null)
                {
                    String receivedData = new String(packet, 8, packet.length-8);
                    System.out.println(receivedData);
                    packet = server.GetPacket();
                }
            }
        }
        
        server.StopListening();

        System.out.println("Server stopped");

        scanner.close();
    }
}