package test;

import main.ClackClient;

public class TestClient {

    public static final String TEST_USERNAME1 = "abc";
    public static final String TEST_HOSTNAME1 = "def";
    public static final int TEST_PORT1 = 12345;
    public static final String TEST_USERNAME2 = "abc";
    public static final String TEST_HOSTNAME2 = "def";
    public static final int TEST_PORT2 = 12345;
    public static final String TEST_USERNAME3 = "ghi";
    public static final String TEST_HOSTNAME3 = "jkl";
    public static final int TEST_PORT3 = 54321;

    public static void main (String[] args)
    {

        // Note: toString() is used implicitly throughout instead of manually calling each accessor for each test.
        // This is done because toString() for ClackClient displays the values of all instance variables on
        // separate lines. Additionally, toString() displays values for which ClackClient does not have accessors.

        // Note: comments throughout denote where input from System.in is required for testing. These comments begin
        // with "input:"

        ClackClient c1 = new ClackClient(TEST_USERNAME1, TEST_HOSTNAME1, TEST_PORT1);
        ClackClient c2 = new ClackClient(TEST_USERNAME2, TEST_HOSTNAME2, TEST_PORT2);
        ClackClient c3 = new ClackClient(TEST_USERNAME3, TEST_HOSTNAME3, TEST_PORT3);

        System.out.println("c1 at start: " + c1);

        c1.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c2.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c3.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: different message
        // input: DONE

        System.out.println("c1 after running: " + c1);
        System.out.println("c2 after running: " + c2);
        System.out.println("c3 after running: " + c3);

        System.out.println("getUserName(): " + c1.getUserName());
        System.out.println("getHostName(): " + c1.getHostName());
        System.out.println("getPort(): " + c1.getPort());
//        System.out.println("hashCode(): " + c1.hashCode());
//        System.out.println("equals(c2): " + c1.equals(c2));
//        System.out.println("equals(c3): " + c1.equals(c3));    disabled because DONE sets dataToSendToServer to null,
//                                                               meaning hashCode() and equals cannot be used on it. There
//                                                               are ways of addressing this if comparisons and hashCodes
//                                                               are necessary after the connection stops.

        c1 = new ClackClient(TEST_USERNAME1, TEST_HOSTNAME1);
        c2 = new ClackClient(TEST_USERNAME2, TEST_HOSTNAME2);
        c3 = new ClackClient(TEST_USERNAME3, TEST_HOSTNAME3);

        System.out.println("c1 at start: " + c1);

        c1.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c2.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c3.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: different message
        // input: DONE

        System.out.println("c1 after running: " + c1);
        System.out.println("c2 after running: " + c2);
        System.out.println("c3 after running: " + c3);

        System.out.println("getUserName(): " + c1.getUserName());
        System.out.println("getHostName(): " + c1.getHostName());
        System.out.println("getPort(): " + c1.getPort());
//        System.out.println("hashCode(): " + c1.hashCode());
//        System.out.println("equals(c2): " + c1.equals(c2));
//        System.out.println("equals(c3): " + c1.equals(c3));    disabled because DONE sets dataToSendToServer to null,
//                                                               meaning hashCode() and equals cannot be used on it. There
//                                                               are ways of addressing this if comparisons and hashCodes
//                                                               are necessary after the connection stops.
        c1 = new ClackClient(TEST_USERNAME1);
        c2 = new ClackClient(TEST_USERNAME2);
        c3 = new ClackClient(TEST_USERNAME3);

        System.out.println("c1 at start: " + c1);

        c1.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c2.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c3.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: different message
        // input: DONE

        System.out.println("c1 after running: " + c1);
        System.out.println("c2 after running: " + c2);
        System.out.println("c3 after running: " + c3);

        System.out.println("getUserName(): " + c1.getUserName());
        System.out.println("getHostName(): " + c1.getHostName());
        System.out.println("getPort(): " + c1.getPort());
//        System.out.println("hashCode(): " + c1.hashCode());
//        System.out.println("equals(c2): " + c1.equals(c2));
//        System.out.println("equals(c3): " + c1.equals(c3));    disabled because DONE sets dataToSendToServer to null,
//                                                               meaning hashCode() and equals cannot be used on it. There
//                                                               are ways of addressing this if comparisons and hashCodes
//                                                               are necessary after the connection stops.

        c1 = new ClackClient();
        c2 = new ClackClient();
        c3 = new ClackClient();

        System.out.println("c1 at start: " + c1);

        c1.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c2.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: not a command; this is a message
        // input: DONE
        c3.start();
        // input: SENDFILE src/test/something.txt
        // input: SENDFILE src/nonexistent
        // input: different message
        // input: DONE

        System.out.println("c1 after running: " + c1);
        System.out.println("c2 after running: " + c2);
        System.out.println("c3 after running: " + c3);

        System.out.println("getUserName(): " + c1.getUserName());
        System.out.println("getHostName(): " + c1.getHostName());
        System.out.println("getPort(): " + c1.getPort());
//        System.out.println("hashCode(): " + c1.hashCode());
//        System.out.println("equals(c2): " + c1.equals(c2));
//        System.out.println("equals(c3): " + c1.equals(c3));    disabled because DONE sets dataToSendToServer to null,
//                                                               meaning hashCode() and equals cannot be used on it. There
//                                                               are ways of addressing this if comparisons and hashCodes
//                                                               are necessary after the connection stops.

    }

}