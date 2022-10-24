import java.io.File;

public class TestClackData {
    public static void main(String args[])
    {
    MessageClackData C1 = new MessageClackData("testuser1", "testmessage1", ClackData.CONSTANT_LISTUSERS);
    MessageClackData C2 = new MessageClackData();
    MessageClackData C3 = new MessageClackData("testuser1", "testmessage1", ClackData.CONSTANT_LISTUSERS);

    FileClackData B1 = new FileClackData("testuser2", "testfilename2", ClackData.CONSTANT_LISTUSERS);
    FileClackData B2 = new FileClackData();
    FileClackData B3 = new FileClackData("testuser2", "testfilename2", ClackData.CONSTANT_LISTUSERS);

    System.out.println(C1);
    System.out.println(C2);
    System.out.println(B1);
    System.out.println(B2);

        if(C1.equals(C2)){
            System.out.println("Messages are the same");
        } else {
            System.out.println("Messages are NOT the same");
        }

        if(C1.equals(C3)){
            System.out.println("Messages are the same");
        } else {
            System.out.println("Messages are NOT the same");
        }
        System.out.println("Hashcode is: " + C1.hashCode());
        System.out.println("Message/data is: " + C1.getData());


        if(B1.equals(B2)){
            System.out.println("Files are the same");
        } else {
            System.out.println("Files are NOT the same");
        }

        if(B1.equals(B3)){
            System.out.println("Files are the same");
        } else {
            System.out.println("Files are NOT the same");
        }
        System.out.println("Hashcode is: " + B1.hashCode());
        System.out.println("Message/data is: " + B1.getData());




    }
}
