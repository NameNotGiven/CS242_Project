/**
 *The ClackClient class represents the client user. A ClackClient object contains the user name,
 * host name of the server connected to, port number connected to, and a boolean
 * designating whether the connection is open or not. Every computer has an address that you
 * can connect to, and in the case of a server, this address represents the host name of the
 * server, so called because it is the host, the main guy through whom all the little clients have
 * their communication. Every computer also has ports to which you connect, these ports enable
 * different applications to simultaneously connect to the network. You connect to a host server at
 * a designated port number. The ClackClient object will also have two ClackData objects
 * representing data sent to the server and data received from the server
 * */
public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;
/**
 * Constructor for username, hostname, and port, connection
 * should be set to open, and should set dataToSendToClient and
 * dataToReceiveFromServer to null
 * */
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
     * Constructor to set up port to default number 7000
     * as a constant, should call another constructor
     * */
    public ClackClient(String userName, String hostName){
    this(userName, hostName, 7000);
    }
    /**
     * constructor that sets host name to be "localhost"
     * */
    public ClackClient(String userName){
    this(userName, "localhost");
    }
/**
 * default constructor that sets anonymous user, should call
 * another constructor
 * */
    public ClackClient(){
    this("Anon");
    }

    public void start(){

    }
    /**
     * Reads data from client
     * */
    public void readClientData(){
/**
 * Sends data to client
 * */
    }
    public void sendData(){

    }
    /**
     * Receives data from server
     * */
    public void  receiveData(){

    }
    /**
     * Prints received data to standard output
     * */
    public void printData(){

    }
    /**
     * Returns username
     * */
    public String getUserName(){
        return userName;
    }
    /**
     * Returns host name
     * */
    public String getHostName(){
        return hostName;
    }
    /**
     * Returns port
     * */
    public int getPort(){
        return port;
    }

    /**
     * Returns hashcode
     * */
    public int hashCode(){
        return 0x321;
    }
    /** compares data and returns true if all data is the same
     * */
    public boolean equals(Object other){
        ClackClient otherFile = (ClackClient) other;
        return otherFile.userName == this.userName &&
                otherFile.hostName == this.hostName &&
                otherFile.port == this.port &&
                otherFile.dataToSendToServer == this.dataToSendToServer  &&
                otherFile.dataToReceiveFromServer == this.dataToReceiveFromServer &&
                otherFile.closeConnection == this.closeConnection;
    }
    /**
     * returns a string with username, host name,
     * data to send and receive from client, and port
     * */
    public String toString(){
        return "The username of this client is: " + this.userName + "\n" +
                "The hostname of the client is: " + this.hostName + "\n" +
                "The data being sent to the server is: " + this.dataToSendToServer + "\n" +
                "The data being received from the server is: " + this.dataToReceiveFromServer + "\n" +
                "The port of the server is: " + this.port + "\n\n";
    }
}
