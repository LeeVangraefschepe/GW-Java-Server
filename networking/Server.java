package networking;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class Server extends Thread
{
    private ServerSocket _tcpSocket;
    private DatagramSocket _udpSocket;
    private LinkedHashSet<Socket> _tcpSockets = new LinkedHashSet<>();
    private LinkedHashSet<UDPSocket> _udpSockets = new LinkedHashSet<>();
    private boolean _isRunning = false;

    private List<byte[]> _packets = new ArrayList<>();

    public Server(int port)
    {
        try
        {
            _tcpSocket = new ServerSocket(port);
            _udpSocket = new DatagramSocket(port);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public byte[] GetPacket()
    {
        if (_packets.isEmpty()) return null;
        var packet = _packets.get(_packets.size()-1);
        _packets.remove(_packets.size()-1);
        return packet;
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
            for (Socket socket : _tcpSockets)
            {
                socket.close();
            }
            
            _tcpSocket.close();
            _udpSocket.close();

            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        HandleUDP();
        while (_isRunning)
        {
            try
            {
                Socket clientSocket = _tcpSocket.accept();
                _tcpSockets.add(clientSocket);
                HandleTCP(clientSocket);
                System.out.println("Client connected!");
            }
            catch (IOException e)
            {
                if (_isRunning == false) return;
                e.printStackTrace();
            }
        }
    }

    private void HandleUDP()
    {
        new Thread(() -> {
            while (_isRunning)
            {
                try
                {
                    // UDP connection handling
                    byte[] udpBuffer = new byte[1024];
                    DatagramPacket udpPacket = new DatagramPacket(udpBuffer, udpBuffer.length);
                    _udpSocket.receive(udpPacket);

                    _packets.add(udpBuffer);

                    UDPSocket senderSocket = new UDPSocket();
                    senderSocket.address = udpPacket.getAddress();
                    senderSocket.port = udpPacket.getPort();
                    _udpSockets.add(senderSocket);
                }
                catch (Exception e)
                {
                    if (_isRunning == false) return;
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void SendAllUDP(String message)
    {
        for (var socket : _udpSockets)
        {
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), socket.address, socket.port);
            try
            {
                _udpSocket.send(packet);
            }
            catch (Exception e)
            {
                if (_isRunning == false) return;
                e.printStackTrace();
            }
        }
    }

    public void SendAllTCP(String message)
    {
        for (var socket : _tcpSockets)
        {
            try
            {
                var outputStream = socket.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private void HandleTCP(Socket clientSocket)
    {
        new Thread(() -> {
            try {
                InputStream inputStream = clientSocket.getInputStream();
                //OutputStream outputStream = clientSocket.getOutputStream();

                // Example: Sending a welcome message to the client
                //outputStream.write("Welcome to the Minecraft server! Type 'exit' to disconnect.\n".getBytes());
                //outputStream.flush();

                byte[] buffer = new byte[1024];

                while (inputStream.read(buffer) != -1)
                {
                    _packets.add(buffer);
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
                    _tcpSockets.remove(clientSocket);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    
    public class UDPSocket implements Comparable<UDPSocket>
    {
        InetAddress address;
        int port;

        @Override
        public int compareTo(UDPSocket otherSocket)
        {
            // Your comparison logic goes here
            // For example, you might compare based on address and then port
            if (this.address.toString().equals(otherSocket.address.toString()))
            {
                return Integer.compare(this.port, otherSocket.port);
            }
            return -1;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            UDPSocket udpSocket = (UDPSocket) obj;
            return port == udpSocket.port && this.address.toString().equals(udpSocket.address.toString());
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(address.toString(), port);
        }
    }
}