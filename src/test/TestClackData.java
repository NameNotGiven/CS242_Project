package test;
import data.*;

public class TestClackData {
    public static void main(String[] args) {
        //
        // test FileClackData
        //
        FileClackData fileOne = new FileClackData("john", "filename", ClackData.CONSTANT_SENDFILE);
        FileClackData fileTwo = new FileClackData();

        // BEGIN SUPERCLASS TESTING
        // test getType()
        System.out.println(fileOne.getType());

        // test getUserName()
        System.out.println(fileOne.getUserName());

        // test getDate()
        System.out.println(fileOne.getDate());
        // end of superclass testing

        // set and get filename
        fileOne.setFileName("TestFileOne");
        System.out.println("Name of file: " + fileOne.getFileName());

        // test getData
        System.out.println("File contents: " + fileOne.getData());

        // test read/writefileContents (empty functions)
        fileOne.readFileContents();
        fileOne.writeFileContents();

        // test hashCode()
        System.out.println("hashCode: " + fileOne.hashCode());

        // test equals()
        if (fileOne.equals(fileOne)) {
            System.out.println("equals() test passed");
        } else {
            System.exit(1); // this should not happen
        }

        // test toString()
        System.out.println(fileOne.toString());

        //
        // test MessageClackData
        //
        MessageClackData messageOne = new MessageClackData("john", "awesome message", ClackData.CONSTANT_SENDMESSAGE);
        MessageClackData messageTwo = new MessageClackData();

        // BEGIN SUPERCLASS TESTING
        // test getType()
        System.out.println(messageOne.getType());

        // test getUserName()
        System.out.println(messageOne.getUserName());

        // test getDate()
        System.out.println(messageOne.getDate());
        // END SUPERCLASS TESTING

        // test getData
        System.out.println(messageOne.getData());

        // test hashCode()
        System.out.println("hashCode: " + messageOne.hashCode());

        // test equals()
        if (!messageOne.equals(messageTwo)) {
            System.out.println("equals() test passed: objects aren't equal");
        } else {
            System.exit(1);
        }

        // test toString()
        System.out.println(messageOne.toString());
    }
}
