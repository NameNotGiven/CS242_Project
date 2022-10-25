package test;

import main.ClackServer;

public class TestServer {

    static private ClackServer serverOne = new ClackServer();
    static private ClackServer serverTwo = new ClackServer(7000);
    static private ClackServer serverThree = new ClackServer(0);

    /**
     * Returns the port.
     */
    public int testGetPort(){return serverOne.getPort();}

    /**
     * Returns true if equals is working correctly.
     */
    public boolean testEquals(){return (serverOne.equals(serverTwo) != serverOne.equals(serverThree));}

    /**
     * Checks hash output for consistency with equals.
     */
    public boolean testHash(){return (serverOne.hashCode() == serverTwo.hashCode()) != (serverOne.hashCode() == serverThree.hashCode());}

    /**
     * Returns string output.
     */
    public String testString(){return serverOne.toString();}

}
