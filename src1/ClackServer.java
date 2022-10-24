/**
 * ClackServer is a blueprint for a ClackServer object that contains
 * information about the port number that clients connect to, a
 * boolean representing whether the server needs to be closed or not,
 * and ClackData objects representing data sent to and received from client
 * */
public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;

    static int default_port = 7000;
/**
 *  constructor that sets port number, should set data ToReceiveFromClient
 *  and dataToSendToClient as null
 * */
    public ClackServer(int port){
        this.port = port;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
    }
    /**
     *  default constructor that sets port number to 7000
     * */
    public ClackServer(){
        this(default_port);
    }

    public void start(){

    }
    /**
     * receives data from client
     * */
    public void receiveData(){

    }
    /**
     * sends data to client
     * */
    public void sendData(){

    }
    /** returns the port
     * */
    public int getPort(){
        return port;
    }
    /** returns hashcode
     * */
    public int hashCode(){
        return 0x111;
    }
    /** compares data and returns true if all data is the same
     * */
    public boolean equals(Object other){
        ClackServer otherFile = (ClackServer)other;
        return otherFile.port == this.port &&
                otherFile.dataToSendToClient == this.dataToSendToClient &&
                otherFile.dataToReceiveFromClient == this.dataToReceiveFromClient;
    }
    /** returns a string with data to send and receive from client
     * */
    public String toString(){
        return "The port is: " + this.port + "\n" +
                "The data to send to the client is: " + this.dataToSendToClient + "\n" +
                "The data to receive from the client is : " + this.dataToReceiveFromClient + "\n\n";
    }
}
