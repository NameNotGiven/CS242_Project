public class TestClackServer {
    public static void main(String args[])
    {
    ClackServer C1 = new ClackServer(1000);
    ClackServer C2 = new ClackServer();
    ClackServer C3 = new ClackServer(1000);

    System.out.println(C1);
    System.out.println(C2);

    if(C1.equals(C2)){
        System.out.println("Servers are the same");
    } else {
        System.out.println("Servers are NOT the same");
    }
    if(C1.equals(C3)){
        System.out.println("Servers are the same");
    } else {
        System.out.println("Servers are NOT the same");
    }
    System.out.println("Hashcode is: " + C1.hashCode());

    }
}
