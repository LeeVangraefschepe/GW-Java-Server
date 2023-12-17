import java.util.Scanner;
import packets.JsonPacket;

public class MainClass
{
    public static void main(String[] args)
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        Scanner scanner = new Scanner(System.in);

        System.out.println("Started server on port: 1234");
        Server server = new Server(1234);
        server.StartListening();

        while (true)
        {
            String input = scanner.nextLine();
            if (input.compareToIgnoreCase("stop") == 0) break;

            if (input.compareToIgnoreCase("test") == 0)
            {
                System.out.println("Sending test");
                
                JsonPacket packet = new JsonPacket();
                packet.SetUChar((byte)20, input);
                packet.SetInt32(69, "Chunk");
            
                server.SendAllTCP(packet.GetData());
                System.out.println("Sending is sent");
            }

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