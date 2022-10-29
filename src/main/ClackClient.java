// Client
package main;
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
        if(userName == null){
            throw new IllegalArgumentException();
        } else {
            this.userName = userName;
        }
        if(hostName == null){
            throw new IllegalArgumentException();
        } else {
            this.hostName = hostName;
        }
        if(port < 1024){
            throw new IllegalArgumentException();
        } else {
            this.port = port;
        }
        this.closeConnection = false;
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
    public void start()
    {
        Scanner inFromStd = new Scanner(readClientData());
        readClientData();
        printData(data);
        dataToReceiveFromServer = dataToSendToServer;

    }

    /**
     * Undefined.
     */
    public void readClientData()
    {
        inFromStd = new Scanner(System.in);
        String input = inFromStd.nextLine();
    if(input == "DONE"){
        closeConnection = true;
    } else if(input == "SENDFILE <filename>"){
        dataToSendToServer = new FileClackData(CONSTANT_SENDFILE);
    } else if(input == "LISTUSERS"){

    } else{
        dataToSendToServer = new MessageClackData(CONSTANT_SENDMESSSAGE);
        }
    }

    /**
     * Undefined.
     */
    public void sendData()
    {

    }

    /**
     * Undefined.
     */
    public void receiveData()
    {

    }

    /**
     * Undefined.
     */
    public void printData()
    {
        System.out.println(dataToReceiveFromServer);
    };

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
