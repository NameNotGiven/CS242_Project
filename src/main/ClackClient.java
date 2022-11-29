package main;

import data.*;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * A class that provides methods for use by a Clack client.
 *
 * @author Nikolai Melnikov
 *
 */

public class ClackClient
{
    public static void main ( String[] args )
    {
        ClackClient clackClient;
        if ( args.length == 0 )
        {
            clackClient = new ClackClient();
        } else
        {
            Scanner scanner = new Scanner(args[0]);
            scanner.useDelimiter("@");
            String userName = scanner.next();
            if (!scanner.hasNext())
            {
                clackClient = new ClackClient(userName);
            } else
            {
                scanner.useDelimiter("[@:]");
                String hostName = scanner.next();
                if (!scanner.hasNext())
                {
                    clackClient = new ClackClient(userName, hostName);
                } else
                {
                    int port = scanner.nextInt();
                    clackClient = new ClackClient(userName, hostName, port);
                }
            }
            scanner.close();
        }
        clackClient.start();
    }

    // constants
    private static final String ANONYMOUS_USERNAME = "anon";

    private static final String DEFAULT_HOST = "localhost";

    private static final int DEFAULT_PORT = 7000;

    private static final boolean DEFAULT_CLOSE_CONNECTION = false;

    private static final ClackData DEFAULT_DATA_TO_SEND_TO_SERVER = null;

    private static final ClackData DEFAULT_DATA_RECEIVED_FROM_SERVER = null;

    private static final ObjectInputStream DEFAULT_IN_FROM_SERVER = null;

    private static final ObjectOutputStream DEFAULT_OUT_FROM_SERVER = null;


    private final String userName;

    private final String hostName;

    private final int port;

    private boolean closeConnection;

    private ClackData dataToSendToServer;

    private ClackData dataToReceiveFromServer;

    private Scanner inFromStd;

    private ObjectOutputStream outToServer;

    private ObjectInputStream inFromServer;

    private Socket skt;

    /**
     * Constructor that has userName, hostName, and port as its parameters.
     *
     * @param userName Value for userName
     * @param hostName Value for hostName
     * @param port Value for port number
     */
    public ClackClient(String userName, String hostName, int port) throws IllegalArgumentException
    {

        // IllegalArgumentException
        if ( userName == null )
        {
            throw new IllegalArgumentException( "userName is null" );
        }
        if ( hostName == null )
        {
            throw new IllegalArgumentException( "hostName is null" );
        }
        if ( port < 1024 )
        {
            throw new IllegalArgumentException( "port is less than 1024" );
        }

        // if no exception, set values
        this.userName = userName;

        this.hostName = hostName;

        this.port = port;

        this.closeConnection = DEFAULT_CLOSE_CONNECTION;

        this.dataToSendToServer = DEFAULT_DATA_TO_SEND_TO_SERVER;

        this.dataToReceiveFromServer = DEFAULT_DATA_RECEIVED_FROM_SERVER;

        this.inFromServer = DEFAULT_IN_FROM_SERVER;

        this.outToServer = DEFAULT_OUT_FROM_SERVER;

    }

    /**
     * Constructor that has userName and hostName as its parameters.
     * port number is set to 7000.
     *
     * @param userName Value for userName
     * @param hostName Value for hostName
     */
    public ClackClient(String userName, String hostName) {
        this(userName, hostName, DEFAULT_PORT);
    }

    /**
     * Constructor that has userName as its parameter.
     * hostName is set to "localhost", port number is set to 7000.
     *
     * @param userName Value for userName
     */
    public ClackClient(String userName) {
        this(userName, DEFAULT_HOST, DEFAULT_PORT);
    }

    /**
     * Default constructor. userName is set to "anon",
     * hostName is set to "localhost", port number is set to 7000.
     *
     */
    public ClackClient() { this(ANONYMOUS_USERNAME, DEFAULT_HOST, DEFAULT_PORT); }

    // methods

    /**
     * Starts the client. Alternates between reading data to send to the server and printing data received
     * from the server.
     */
    public void start()
    {
        try {
            skt = new Socket(this.hostName, this.port);
            this.outToServer = new ObjectOutputStream ( skt.getOutputStream() );
            this.inFromServer = new ObjectInputStream ( skt.getInputStream() );

        } catch ( UnknownHostException uhe ) {
            System.err.println("UnknownHostException: " + uhe.getMessage());
        } catch ( IOException ioe ) {
            System.err.println("IOException: " + ioe.getMessage());
        } catch ( IllegalArgumentException iae ) {
            System.err.println("IllegalArgumentException: " + iae.getMessage());
        }
    }

    public void close()
    {
        inFromStd.close();
        try {
            outToServer.close();
            inFromServer.close();
            skt.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Reads the data from the client. If the first word of dataToSendToServer is a
     * command, that action is performed, otherwise the entire string of dataToSendToServer
     * is sent as a message.
     */
    public void readClientData()
    {

        String input = this.inFromStd.next();

        switch ( input )
        {

            // command to log out
            case ( "DONE" ):
                this.closeConnection = true;
                this.dataToSendToServer = null;
                break;

            // command to send a file
            case ( "SENDFILE" ):
                try {
                    this.dataToSendToServer = new FileClackData ( userName, inFromStd.next(), FileClackData.CONSTANT_SENDFILE );
                    ((FileClackData)this.dataToSendToServer).readFileContents();
                }
                catch ( IOException ioe ) {
                    dataToSendToServer = null;
                    System.err.println( ioe.getMessage() );
                }
                break;

            // command to list users. Not finished
            case ( "LISTUSERS" ):
                this.dataToSendToServer = new ListUsers (this.userName, ClackData.CONSTANT_LISTUSERS);
                break;

            // if the user does not input a command, the string itself is sent
            default:
                this.dataToSendToServer = new MessageClackData( userName, input + this.inFromStd.nextLine(), MessageClackData.CONSTANT_SENDMESSAGE);
                break;

        }

    }

    /**
     * Sends data to server.
     */
    public void sendData(ClackData dataToSend)
    {
        try {
            outToServer.writeObject(dataToSend);
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
    public ClackData receiveData()
    {
        try {
            dataToReceiveFromServer = (ClackData) inFromServer.readObject();
        } catch ( ClassCastException cce ) {
            System.err.println("ClassCastException: " + cce.getMessage());
        } catch ( ClassNotFoundException cnfe ) {
            System.err.println("ClassNotFoundException: " + cnfe.getMessage());
        } catch ( IOException ioe ) {
            System.err.println("IOException in receiveData: " + ioe.getMessage());
        }
        return dataToReceiveFromServer;
    }

    /**
     * Receives data from the server and returns it as a string.
     */

    /**
     * Accessor that returns userName.
     *
     * @return userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Accessor that returns hostName.
     *
     * @return hostName
     */
    public String getHostName() {
        return this.hostName;
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
     * Accessor that returns the closeConnection status
     *
     * @return a boolean representing whether the connection is closed
     */

    public boolean getCloseConnection() {
        return this.closeConnection;
    }

    /**
     * Computes and returns the hash code. All instance variables are used to compute the hash code,
     * except dataToSendToServer and dataReceivedFromServer, which are currently always null.
     *
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        int result = 17;
        result = 37*result + this.userName.hashCode();
        result = 37*result + this.hostName.hashCode();
        result = 37*result + this.port;
        result = 37*result;
        if (this.closeConnection) result += 1;
        result = 37*result + dataToSendToServer.hashCode();
        result = 37*result + dataToReceiveFromServer.hashCode();
        return result;
    }

    /**
     * Checks whether two FileCLackData objects have the same values for
     * userName, hostName, port, and closeConnection. Does not compare dataToSendToServer or
     * dataReceivedFromServer, which are currently always null.
     *
     * @param obj Another instance of ClackClient
     * @return equality boolean of the two instances
     *
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof ClackClient)) return false;
        ClackClient other = (ClackClient)obj;
        return other.userName.equals(this.userName)
                && other.hostName.equals(this.hostName)
                && other.port == this.port
                && other.closeConnection == this.closeConnection
                && other.dataToSendToServer.equals(this.dataToSendToServer)
                && other.dataToReceiveFromServer.equals(this.dataToReceiveFromServer);
    }

    /**
     * Returns the instance variables of ClackClient as a String. Prints the name
     * and value of each variable on its own line.
     *
     * @return a formatted string with the name and value of each instance variable printed on its own line
     */
    @Override
    public String toString()
    {
        return
                "userName: \"" + this.userName + "\"\n" +
                        "hostName: \"" + this.hostName +"\"\n" +
                        "port: " + this.port + '\n' +
                        "closeConnection: " + this.closeConnection + '\n' +
                        "dataToSendToServer: " + this.dataToSendToServer + '\n' +
                        "dataReceivedFromServer: " + this.dataToReceiveFromServer;
    }
}