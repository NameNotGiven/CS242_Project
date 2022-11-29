package test;

import data.FileClackData;
import data.MessageClackData;

import java.io.IOException;

public class TestClackData
{

    private static final String TEST_USERNAME = "jto33";
    private static final String TEST_MESSAGE = "Something Something blah blah blah";
    private static final String TEST_FILENAME = "src/test/TestRead.txt";
    private static final String TEST_CHANGED_FILENAME1 = "src/test/secret.txt";
    private static final String TEST_CHANGED_FILENAME2 = "src/test/something.txt";
    private static final String TEST_CHANGED_FILENAME3 = "src/test/TestReadEncrypted.txt";
    private static final String TEST_CHANGED_FILENAME4 = "src/test/encrypted.txt";
    private static final String TEST_KEY = "gwahgw";
    private static final int TEST_SENDMESSAGE = 2;
    public static final int TEST_SENDFILE = 3;



    public static void main(String[] args)
    {
        MessageClackData mcd1 = new MessageClackData();
        MessageClackData mcd2 = new MessageClackData(TEST_USERNAME, TEST_MESSAGE, TEST_SENDMESSAGE);
        MessageClackData mcd3 = new MessageClackData(TEST_USERNAME, TEST_MESSAGE, TEST_KEY, TEST_SENDMESSAGE);
        FileClackData fcd1 = new FileClackData();
        FileClackData fcd2 = new FileClackData(TEST_USERNAME, TEST_FILENAME, TEST_SENDFILE);

        System.out.println("The type of mcd1 is: " + mcd1.getType());
        System.out.println("The username of the person who made mcd1 is: " + mcd1.getUserName());
        System.out.println("The date mcd1 was created: " + mcd1.getDate());
        System.out.println("The hash code of mcd1 is: " + mcd1.hashCode());
        System.out.println("Is mcd1 equivalent to mcd2: " + mcd1.equals(mcd2));
        System.out.println("The message of mcd1 is: " + mcd1.getData());
        System.out.println(mcd1);

        System.out.println("The type of mcd2 is: " + mcd2.getType());
        System.out.println("The username of the person who made mcd2 is: " + mcd2.getUserName());
        System.out.println("The date mcd2 was created: " + mcd2.getDate());
        System.out.println("The hash code of mcd2 is: " + mcd2.hashCode());
        System.out.println("Is mcd2 equivalent to mcd1: " + mcd2.equals(mcd1));
        System.out.println("The message of mcd2 is: " + mcd2.getData());
        System.out.println(mcd2);

        System.out.println("The type of fcd1 is: " + fcd1.getType());
        System.out.println("The username of the person who made fcd1 is: " + fcd1.getUserName());
        System.out.println("The date fcd1 was created: " + fcd1.getDate());
        System.out.println("The hash code of fcd1 is: " + fcd1.hashCode());
        System.out.println("Is fcd1 equivalent to fcd2: " + fcd1.equals(fcd2));
        System.out.println("The file name of fcd1 is: " + fcd1.getFileName());
        System.out.println("The file content of fcd1 is: " + fcd1.getData());
        System.out.println(fcd1);

        System.out.println("The type of fcd2 is: " + fcd2.getType());
        System.out.println("The username of the person who made fcd2 is: " + fcd2.getUserName());
        System.out.println("The date fcd2 was created: " + fcd2.getDate());
        System.out.println("The hash code of fcd2 is: " + fcd2.hashCode());
        System.out.println("Is fcd2 equivalent to fcd1: " + fcd2.equals(fcd1));
        System.out.println("The file name of fcd2 is: " + fcd2.getFileName());
        System.out.println("The file content of fcd2 is: " + fcd2.getData());
        System.out.println(fcd2);

        try {
            // fcd1.readFileContents(); // will throw IOException, testing purposes
            fcd2.readFileContents();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        fcd1.setFileName(TEST_CHANGED_FILENAME1);
        fcd2.setFileName(TEST_CHANGED_FILENAME2);

        System.out.println("The type of fcd1 is: " + fcd1.getType());
        System.out.println("The username of the person who made fcd1 is: " + fcd1.getUserName());
        System.out.println("The date fcd1 was created: " + fcd1.getDate());
        System.out.println("The hash code of fcd1 is: " + fcd1.hashCode());
        System.out.println("Is fcd1 equivalent to fcd2: " + fcd1.equals(fcd2));
        System.out.println("The file name of fcd1 is: " + fcd1.getFileName());
        System.out.println("The file content of fcd1 is: " + fcd1.getData());
        System.out.println(fcd1);

        System.out.println("The type of fcd2 is: " + fcd2.getType());
        System.out.println("The username of the person who made fcd2 is: " + fcd2.getUserName());
        System.out.println("The date fcd2 was created: " + fcd2.getDate());
        System.out.println("The hash code of fcd2 is: " + fcd2.hashCode());
        System.out.println("Is fcd2 equivalent to fcd1: " + fcd2.equals(fcd1));
        System.out.println("The file name of fcd2 is: " + fcd2.getFileName());
        System.out.println("The file content of fcd2 is: " + fcd2.getData());
        System.out.println(fcd2);

        System.out.println("The file content of fcd1 is: " + fcd1.getData());
        //fcd1.writeFileContents(); NullPointerException due to default parameters
        try {
            // fcd1.readFileContents(); // will throw IOException, testing purposes
            fcd2.readFileContents();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }


        fcd1.setFileName(TEST_CHANGED_FILENAME3);
        try {
            fcd1.readFileContents("GRKLP");
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        System.out.println("The type of fcd1 is: " + fcd1.getType());
        System.out.println("The username of the person who made fcd1 is: " + fcd1.getUserName());
        System.out.println("The date fcd1 was created: " + fcd1.getDate());
        System.out.println("The hash code of fcd1 is: " + fcd1.hashCode());
        System.out.println("Is fcd1 equivalent to fcd2: " + fcd1.equals(fcd2));
        System.out.println("The file name of fcd1 is: " + fcd1.getFileName());
        System.out.println("The encrypted file content of fcd1 is: " + fcd1.getData());
        System.out.println("The decrypted file content of fcd1 is: " + fcd1.getData("GRKLP"));
        System.out.println(fcd1);

        fcd1.setFileName(TEST_CHANGED_FILENAME2);

        try {
            fcd1.readFileContents();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        fcd1.setFileName(TEST_CHANGED_FILENAME4);

        try {
            fcd1.writeFileContents("GRKLP");
        }
        catch ( IOException ioe ) {
            System.err.println( ioe.getMessage() );
        }



        System.out.println("The type of mcd3 is: " + mcd3.getType());
        System.out.println("The username of the person who made mcd3 is: " + mcd3.getUserName());
        System.out.println("The date mcd3 was created: " + mcd3.getDate());
        System.out.println("The hash code of mcd3 is: " + mcd3.hashCode());
        System.out.println("Is mcd3 equivalent to mcd2: " + mcd3.equals(mcd2));
        System.out.println("The encrypted message of mcd3 is: " + mcd3.getData());
        System.out.println("The decrypted message of mcd3 is: " + mcd3.getData(TEST_KEY));
        System.out.println(mcd3);
    }
}
