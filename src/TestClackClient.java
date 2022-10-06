public class TestClackClient {
    public static void main(String args[])
    {
    ClackClient C1 = new ClackClient("testuser1", "testhost1", 1000);
    ClackClient C2 = new ClackClient();
    ClackClient C3 = new ClackClient("testuser1", "testhost1", 1000);

    System.out.println(C1);
    System.out.println(C2);

        if(C1.equals(C2)){
            System.out.println("Clients are the same");
        } else {
            System.out.println("Clients are NOT the same");
        }
        if(C1.equals(C3)){
            System.out.println("Clients are the same");
        } else {
            System.out.println("Clients are NOT the same");
        }
        System.out.println("Hashcode is: " + C1.hashCode());
        System.out.println("Username is: " + C1.getUserName());
        System.out.println("Hostname is: " + C1.getHostName());
        System.out.println("Port is: " + C1.getPort());


    }
}
