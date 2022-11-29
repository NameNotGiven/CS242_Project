package main;

/**
 * A class used to receive and print data for a ClackClient object.
 * This class is meant to run simultaneously on a separate thread.
 *
 * @author Nikolai Melnikov
 */

public class ClientSideServerListener implements Runnable
{
    private final ClackClient client;

    /**
     * Constructor that has a ClackClient object as its parameter.
     *
     * @param client a ClackClient object
     */
    ClientSideServerListener(ClackClient client ) {
        this.client = client;
    }

    public void run()
    {
        while (!this.client.getCloseConnection()) {
            client.receiveData();
        }
    }
}
