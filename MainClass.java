import java.util.Scanner;

public class MainClass
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

         System.out.println("Started server on port: 1234");
        Server server = new Server(1234);
        server.StartListening();

        while (true)
        {
            String input = scanner.nextLine();
            if (input.compareToIgnoreCase("stop") == 0) break;
        }
        
        server.StopListening();

        System.out.println("Server stopped");

        scanner.close();
    }
}