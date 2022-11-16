package main;

import data.ClackData;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * The ClackServer class is a blueprint for a ClackServer object that contains information about the
 * port number that clients connect to, a boolean representing whether the server needs to be
 * closed or not, and ClackData objects representing data sent to and received from the client. The
 * server class does not need to know the host name (as the server program runs on its own computer),
 * it just needs to know what port the clients connect to. In our application, all clients will connect
 * to a single port.
 *
 * @author nikolaimelnikov/amandapolarolo
 */
public class ClackServer {
    public static void main(String[] args) {
        if (args.length == 0) {
            ClackServer cs = new ClackServer();
            cs.start();
        }
        else if (args.length == 1) {
            try {
                int port = Integer.parseInt(args[0]);
                ClackServer cs = new ClackServer(port);
                cs.start();

            } catch (NumberFormatException nfe) {
                System.err.println("Argument is not an int: " + nfe.getMessage());
            }
        }
        else System.err.println("Too many arguments!");
    }
    private static final int DEFAULT_PORT = 7000;  // The default port number
    private static final boolean DEFAULT_CLOSE_CONNECTION = false;
    private int port;  // An integer representing the port number on the server connected to
    private boolean closeConnection;  // A boolean representing whether the connection is closed or not
    private ClackData dataToReceiveFromClient;  // A ClackData object representing the data received from the client
    private ClackData dataToSendToClient;  // A ClackData object representing the data sent to client
    private static final ObjectInputStream inFromClient = null;
    private static final ObjectOutputStream outFromClient = null;
    /**
     * The constructor that sets the port number.
     * Should set dataToReceiveFromClient and dataToSendToClient as null.
     *
     * @param port an int representing the port number on the server connected to
     */
    public ClackServer(int port) {
        if (port < 1024) {
            throw new IllegalArgumentException("Error: Port number is less than 1024!");
        }

        this.port = port;
        this.closeConnection = DEFAULT_CLOSE_CONNECTION;
    }

    /**
     * The default constructor that sets the port to the default port number 7000.
     * The default port number should be set up as constant (e.g., DEFAULT_PORT).
     * This constructor should call another constructor.
     */
    public ClackServer() {
        this(DEFAULT_PORT);
    }

    /**
     * Starts the server.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void start() {
        try {
            ServerSocket sskt = new ServerSocket(getPort());
            System.out.println("Server started on port " + getPort());

            while (!closeConnection) {
                Socket clientSocket = sskt.accept();
            }

            sskt.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public void sendData(ClackData dataToSend) {
        try {
            outFromClient.writeObject(dataToSend);
        } catch ( InvalidClassException ice ) {
            System.err.println("InvalidClassException: " + ice.getMessage());
        } catch ( NotSerializableException nse) {
            System.err.println("NotSerializableException: " + nse.getMessage());
        } catch ( IOException ioe ) {
            System.err.println ("IOException in sendData: " + ioe.getMessage());
        }
    }

    /**
     * Receives data from the server.
     */
    public ClackData receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
        } catch ( ClassCastException cce ) {
            System.err.println("ClassCastException: " + cce.getMessage());
        } catch ( ClassNotFoundException cnfe ) {
            System.err.println("ClassNotFoundException: " + cnfe.getMessage());
        } catch ( IOException ioe ) {
            System.err.println("IOException in receiveData: " + ioe.getMessage());
        }
        return dataToReceiveFromClient;
    }

    /**
     * Returns the port.
     *
     * @return this.port.
     */
    public int getPort() {
        return this.port;
    }


    @Override
    public int hashCode() {
        // The following is only one of many possible implementations to generate the hash code.
        // See the hashCode() method in other classes for some different implementations.
        // It is okay to select only some of the instance variables to calculate the hash code
        // but must use the same instance variables with equals() to maintain consistency.
        return Objects.hash(this.port, this.closeConnection, this.dataToReceiveFromClient, this.dataToSendToClient);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClackServer)) {
            return false;
        }

        // Casts other to be a ClackServer to access its instance variables.
        ClackServer otherClackServer = (ClackServer) other;

        // Compares the selected instance variables of both ClackServer objects that determine uniqueness.
        // It is okay to select only some of the instance variables for comparison but must use the same
        // instance variables with hashCode() to maintain consistency.
        return this.port == otherClackServer.port
                && this.closeConnection == otherClackServer.closeConnection
                && Objects.equals(this.dataToReceiveFromClient, otherClackServer.dataToReceiveFromClient)
                && Objects.equals(this.dataToSendToClient, otherClackServer.dataToSendToClient);
    }

    @Override
    public String toString() {
        // Should return a full description of the class with all instance variables.
        return "This instance of ClackServer has the following properties:\n"
                + "Port number: " + this.port + "\n"
                + "Connection status: " + (this.closeConnection ? "Closed" : "Open") + "\n"
                + "Data to receive from the client: " + this.dataToReceiveFromClient + "\n"
                + "Data to send to the client: " + this.dataToSendToClient + "\n";
    }
}
