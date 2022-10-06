public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;

    static int default_port = 7000;

    public ClackServer(int port){
        this.port = port;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
    }

    public ClackServer(){
        this(default_port);
    }

    public void start(){

    }

    public void receiveData(){

    }

    public void sendData(){

    }

    public int getPort(){
        return port;
    }

    public int hashCode(){
        return 0x111;
    }

    public boolean equals(Object other){
        ClackServer otherFile = (ClackServer)other;
        return otherFile.port == this.port &&
                otherFile.dataToSendToClient == this.dataToSendToClient &&
                otherFile.dataToReceiveFromClient == this.dataToReceiveFromClient;
    }

    public String toString(){
        return "The port is: " + this.port + "\n" +
                "The data to send to the client is: " + this.dataToSendToClient + "\n" +
                "The data to receive from the client is : " + this.dataToReceiveFromClient + "\n\n";
    }
}
