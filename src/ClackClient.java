public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;

    public ClackClient(String userName, String hostName, int port){
    this.userName = userName;
    this.hostName = hostName;
    this.port = port;
    this.closeConnection = false;
    }

    public ClackClient(String userName, String hostName){
    this(userName, hostName, 7000);
    }
    public ClackClient(String userName){
    this(userName, "localhost");
    }

    public ClackClient(){
    this("Anon");
    }

    public void start(){

    }

    public void readClientData(){

    }
    public void sendData(){

    }

    public void  receiveData(){

    }

    public void printData(){

    }

    public String getUserName(){
        return userName;
    }
    public String getHostName(){
        return hostName;
    }
    public int getPort(){
        return port;
    }


    public int hashCode(){
        return 0x321;
    }

    public boolean equals(Object other){
        ClackClient otherFile = (ClackClient) other;
        return otherFile.userName == this.userName &&
                otherFile.hostName == this.hostName &&
                otherFile.port == this.port &&
                otherFile.dataToSendToServer == this.dataToSendToServer  &&
                otherFile.dataToReceiveFromServer == this.dataToReceiveFromServer &&
                otherFile.closeConnection == this.closeConnection;
    }

    public String toString(){
        return "The username of this client is: " + this.userName + "\n" +
                "The hostname of the client is: " + this.hostName + "\n" +
                "The data being sent to the server is: " + this.dataToSendToServer + "\n" +
                "The data being received from the server is: " + this.dataToReceiveFromServer + "\n" +
                "The port of the server is: " + this.port + "\n\n";
    }
}
