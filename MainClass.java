import java.util.Scanner;

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
        }
        
        server.StopListening();

        System.out.println("Server stopped");

        scanner.close();
    }
}