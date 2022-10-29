
// Client
package main;

import data.FileClackData;
import data.MessageClackData;

import java.util.Objects;
import java.util.Scanner;
public class ClackClient {
    static final int DEFAULT_PORT = 7000;
    private String userName;
    private String hostName;
    private int port;

    private boolean closeConnection;
    private data.ClackData dataToSendToServer;
    private data.ClackData dataToReceiveFromServer;

    Scanner inFromStd;

    /**
     * Constructor for a name, host and port.
     */
    public ClackClient(String userName, String hostName, int port){
        if (userName == null || hostName == null || port <1024) {throw new IllegalArgumentException("Invalid Client Parameters");}

        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
    }
    /**
     * Constructor for a given name and host, using DEFAULT_PORT.
     */
    public ClackClient(String userName, String hostName)
    {
        this(userName, hostName, DEFAULT_PORT);
    }

    /**
     * Constructor for a given user, using DEFAULT_PORT and localhost.
     */
    public ClackClient(String userName)
    {
        this(userName, "localhost");
    }

    /**
     * Constructor for an anonymous user, using localhost and DEFAULT_PORT.
     */
    public ClackClient()
    {
        this("Anonymous");
    }

    /**
     * Undefined.
     */
    public void start(){

        closeConnection = false;
        while (!closeConnection) {
            readClientData();
            dataToReceiveFromServer = dataToSendToServer;
            printData();
        }
    }

    /**
     * Undefined for now
     */
    public void readClientData(){
        System.out.println("Enter your command/message\n");
        String input = inFromStd.nextLine();
        String[] split = input.split(" ", 3);
        if (split[0].equals("DONE")) {closeConnection = true;}
        else if (split[0].equals("SENDFILE")) {
            dataToSendToServer = new FileClackData(userName, split[1], 3);
            java.io.File f = new java.io.File(split[1]);
            if (!f.canRead()) {
                System.err.println("Couldn't open File\n");
                dataToSendToServer = null;
            }

        }
        else if (input.equals("LISTUSERS")) {} //Do nothing - DO NOT CALL
        else {
            dataToSendToServer = new MessageClackData(userName, input, 2);
        }
        dataToReceiveFromServer = dataToSendToServer;
    }

    /**
     * Undefined for now
     */
    public void sendData(){}

    /**
     * Undefined for now
     */
    public void receiveData(){}

    /**
     * Undefined for now
     */
    public void printData(){
        if (dataToReceiveFromServer != null) {System.out.println(dataToReceiveFromServer.toString());}
        else {System.err.println("No data to retrieve\n");}
    }


    /**
     * Returns username.
     */
    public String getUserName()
    {
        return this.userName;
    }

    /**
     * Returns hostname.
     */
    public String getHostName()
    {
        return this.hostName;
    }

    /**
     * Returns port.
     */
    public int getPort()
    {
        return this.port;
    }

    /**
     * Overrides equals for comparisons that are valid.
     */
    @Override
    public boolean equals(Object o)
    {
        if (this.hashCode() == o.hashCode() && this.getClass() == o.getClass()) {return true;}
        else {return false;}
    }

    /**
     * Overrides hashcode to work with equals.
     */
    @Override
    public int hashCode()
    {
        return this.port + this.userName.hashCode() + this.hostName.hashCode() + this.dataToReceiveFromServer.hashCode() + this.dataToSendToServer.hashCode();
    }

    /**
     * Returns all values in string.
     */
    @Override
    public String toString()
    {
        return "Username: " + this.userName +
                "\nHostname: " + this.hostName +
                "\nPort: " + this.port +
                "\nData To Receive: " + dataToSendToServer.toString() +
                "\nData To Send: " + dataToReceiveFromServer.toString();
    }

}


