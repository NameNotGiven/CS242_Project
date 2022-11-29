package main;

import data.ClackData;
import data.ListUsersData;

import java.io.IOException;
import java.util.*;
import java.net.*;

/**
 *
 * A class that provides methods for use by a Clack server.
 *
 * @author Nikolai Melnikov
 *
 */

public class ClackServer
{

    private static final int DEFAULT_PORT = 7000;

    private static final boolean DEFAULT_CLOSE_CONNECTION = false;

    private static final ArrayList<ServerSideClientIO> DEFAULT_ARRAYLIST_OF_SERVERSIDE_CLIENT_IO = new ArrayList<>();

    private final int port;

    private boolean closeConnection;

    ArrayList<ServerSideClientIO> serverSideClientIOList;


    /**
     * Constructor that has port number as its parameter.
     *
     * @param port set port
     */
    public ClackServer(int port)
    {
        if (port < 1024)
        {
            throw new IllegalArgumentException("Error: Port number is less than 1024!");
        }

        this.port = port;
        this.closeConnection = DEFAULT_CLOSE_CONNECTION;
        this.serverSideClientIOList = DEFAULT_ARRAYLIST_OF_SERVERSIDE_CLIENT_IO;
    }

    /**
     * Default constructor. port number is set to 7000.
     *
     */
    public ClackServer() {
        this(DEFAULT_PORT);
    }

    // methods

    /**
     *  Accepts multiple clients into the server in order to receive and send data between many clients
     */
    public void start()
    {
        try {
            ServerSocket sskt = new ServerSocket(getPort());
            System.out.println("Server started on port " + getPort());

            while (!closeConnection)
            {
                Socket clientSocket = sskt.accept();
                //System.out.println("Client connected");

                ServerSideClientIO sscio = new ServerSideClientIO(this , clientSocket);
                serverSideClientIOList.add(sscio);

                Thread t = new Thread(sscio);
                t.start();
            }

            sskt.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Broadcasts a ClackData object to all ClackClients connected
     *
     * @param dataToBroadcastToClients  ClackData to be broadcasted
     */
    public synchronized void broadcast(ClackData dataToBroadcastToClients)
    {
        for (int i = 0; i < serverSideClientIOList.size(); i++) {
            serverSideClientIOList.get(i).setDataToSendToClient(dataToBroadcastToClients);
            serverSideClientIOList.get(i).sendData();
            serverSideClientIOList.get(i).setDataToSendToClient( new ListUsersData( getListOfUsersString()));
            serverSideClientIOList.get(i).sendData();
            System.out.println(getListOfUsersString());
        }
    }

    /**
     * Removes ServerSideClientIO object from the list of ServerSideClientIO objects.
     *
     * @param sscio ServerSideClientIO object to be removed
     */
    public synchronized void remove(ServerSideClientIO sscio) {
        serverSideClientIOList.remove(sscio);
    }

    /**
     * Accessor that returns port number.
     *
     * @return port number
     */
    public int getPort() {
        return this.port;
    }


    /**
     * Computes and returns the hash code. All instance variables are used to compute the hash code,
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        int result = 17;
        result = 37*result + this.port;
        result = 37*result; if (this.closeConnection) result += 1;
        result = 37*result + serverSideClientIOList.size();
        return result;
    }

    /**
     * Returns whether this instance of ClackServer has the same instance variable values as another.
     *
     * @param obj Another instance of ClackServer
     * @return equality boolean of the two instances
     */
    @Override
    public boolean equals (Object obj)
    {
        if (!(obj instanceof ClackServer)) return false;
        ClackServer other = (ClackServer)obj;
        return other.port == this.port
                && other.closeConnection == this.closeConnection
                && other.serverSideClientIOList.equals(this.serverSideClientIOList);
    }

    /**
     * Returns the instance variables of ClackServer as a formatted String.
     *
     * @return a formatted string containing the values of each instance variable
     */
    @Override
    public String toString () {
        return "port: " + port + '\n' +
                "closeConnection: " + closeConnection + '\n' +
                "serverSideClientIOList: " + serverSideClientIOList;
    }

    /**
     * Returns a string of the names of connected users, seperated by spaces.
     * If a user's name is unknown, it will be shown as "unknown user".
     *
     * @return a string of the names of all connected users
     */
    public String getListOfUsersString()
    {
        String listOfUsers = "";
        for (int i = 0; i < serverSideClientIOList.size(); i++)
        {
            listOfUsers += serverSideClientIOList.get(i).getUserName() + '\n';
        }
        return listOfUsers;
    }

    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            ClackServer cs = new ClackServer();
            cs.start();
        }
        else if (args.length == 1)
        {
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
}
