package main;

import data.ClackData;
import data.MessageClackData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSideClientIO implements Runnable
{

    private static final boolean DEFAULT_CLOSE_CONNECTION = false;

    private static final ClackData DEFAULT_DATA_TO_RECEIVE_FROM_CLIENT = null;

    private static final ClackData DEFAULT_DATA_TO_SEND_TO_CLIENT = null;

    private static final ObjectInputStream DEFAULT_IN_FROM_CLIENT = null;

    private static final ObjectOutputStream DEFAULT_OUT_TO_CLIENT = null;

    private static final String SERVER_NAME = "server";

    private static final String DEFAULT_USERNAME = "unknown user";

    private String userName;

    private boolean closeConnection;

    private ClackData dataToReceiveFromClient;

    private ClackData dataToSendToClient;



    private ObjectInputStream inFromClient;

    private ObjectOutputStream outToClient;

    private ClackServer server;

    private Socket clientSocket;


    /**
     * Constructor that has a server and a clientSocket as its parameters.
     *
     * @param server a set ClackServer
     * @param clientSocket a set Socket
     */
    ServerSideClientIO(ClackServer server, Socket clientSocket )
    {
        this.server = server;
        this.clientSocket = clientSocket;
        this.closeConnection = DEFAULT_CLOSE_CONNECTION;
        this.dataToReceiveFromClient = DEFAULT_DATA_TO_RECEIVE_FROM_CLIENT;
        this.dataToSendToClient = DEFAULT_DATA_TO_SEND_TO_CLIENT;
        this.inFromClient = DEFAULT_IN_FROM_CLIENT;
        this.outToClient = DEFAULT_OUT_TO_CLIENT;
        this.userName = DEFAULT_USERNAME;
    }

    /**
     * Runnable for threading. Receives and broadcasts ClackData.
     */
    @Override
    public void run()
    {
        try {
            this.inFromClient = new ObjectInputStream(this.clientSocket.getInputStream());
            this.outToClient = new ObjectOutputStream(this.clientSocket.getOutputStream());

            while (!closeConnection) {
                receiveData();
                this.server.broadcast(dataToReceiveFromClient);
            }

            inFromClient.close();
            outToClient.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Sends data from the dataToSendToClient to the outToClient, OutputObjectStream.
     */
    public void sendData()
    {
        try {
            if (!closeConnection)
            {
                outToClient.writeObject(dataToSendToClient);
            }
        } catch(IOException ioe) {
            System.err.println("IOException with writing an object to the client: " + ioe.getMessage());
        }
    }

    /**
     * Basic Mutator that sets the dataToSendToClient
     *
     * @param dataToSendToClient ClackData to be set
     */
    public void setDataToSendToClient(ClackData dataToSendToClient) {
        this.dataToSendToClient = dataToSendToClient;
    }

    /**
     * Receives data from the InputObjectStream, inFromClient, then transfers it into dataToReceiveFromClient. Also, removes
     * the ServerSideClientIO upon the connection needing to be closed.
     */
    public void receiveData()
    {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
            if (dataToReceiveFromClient == null)
            {
                server.remove(this);
                closeConnection = true;
            }

            updateUserName();

            if (dataToReceiveFromClient instanceof data.ListUsers)
            {
                dataToReceiveFromClient = new MessageClackData(SERVER_NAME, server.getListOfUsersString(), ClackData.CONSTANT_SENDMESSAGE);
            }
        } catch(ClassNotFoundException cnfe) {
            System.err.println("Class Not Found Exception with reading an object from the Client: " + cnfe.getMessage());
        } catch(IOException ioe) {
            System.err.println("IOException with reading an object from the Client: " + ioe.getMessage());
        }
    }

    /**
     * Updates userName based on most recent message.
     */
    public void updateUserName ()
    {
        if (dataToReceiveFromClient != null)
        {
            this.userName = dataToReceiveFromClient.getUserName();
        }
    }

    /**
     * Accessor that returns the userName.
     */
    public String getUserName() {
        return this.userName;
    }
}
