import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread
{
    private ServerSocket _serverSocket;
    private List<Socket> _connectedSockets = new ArrayList<>();
    private boolean _isRunning = false;

    public Server(int port)
    {
        try
        {
            _serverSocket = new ServerSocket(port);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void StartListening()
    {
        if (!_isRunning)
        {
            _isRunning = true;
            start();
        }
    }

    public void StopListening()
    {
        _isRunning = false;
        interrupt();
        try
        {
            _serverSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (_isRunning)
        {
            try
            {
                Socket clientSocket = _serverSocket.accept();
                _connectedSockets.add(clientSocket);
                handleClient(clientSocket);
                System.out.println("Client connected!");
            }
            catch (IOException e)
            {
                if (_isRunning == false) return;
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try {
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                // Example: Sending a welcome message to the client
                outputStream.write("Welcome to the Minecraft server! Type 'exit' to disconnect.\n".getBytes());
                outputStream.flush();

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1)
                {
                    String receivedData = new String(buffer, 0, bytesRead);

                    // Process the received data (you can modify this part based on your requirements)
                    System.out.println("Received data from client: " + receivedData.length());
                }
            }
            catch (IOException e)
            {
                System.out.println("Client disconnected");
            }
            finally
            {
                try
                {
                    clientSocket.close();
                    _connectedSockets.remove(clientSocket);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}