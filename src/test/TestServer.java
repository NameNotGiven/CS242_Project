package test;

import main.ClackServer;

public class TestServer {

    public static final int TEST_PORT1 = 12345;

    public static final int TEST_PORT2 = 12345;

    public static final int TEST_PORT3 = 54321;


    public static void main ( String[] args )
    {


        ClackServer c1 = new ClackServer(TEST_PORT1);
        ClackServer c2 = new ClackServer(TEST_PORT2);
        ClackServer c3 = new ClackServer(TEST_PORT3);


        c1.equals(c2);
        c1.equals(c3);
        System.out.println(c1);
        System.out.println("getPort(): " + c1.getPort());
        System.out.println("hashCode(): " + c1.hashCode());
        System.out.println("equals(c2): " + c1.equals(c2));
        System.out.println("equals(c3): " + c1.equals(c3));

        c1 = new ClackServer();
        c2 = new ClackServer();
        c3 = new ClackServer();

        c1.equals(c2);
        c1.equals(c3);
        System.out.println("\n" + c1);
        System.out.println("getPort(): " + c1.getPort());
        System.out.println("hashCode(): " + c1.hashCode());
        System.out.println("equals(c2): " + c1.equals(c2));
        System.out.println("equals(c3): " + c1.equals(c3));

    }

}
