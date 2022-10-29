// File Data for Clack
// Andrew Tringali 10/3/22

package data;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class FileClackData extends data.ClackData {
    
    private String fileName;
    private String fileContents;

    /**
     * Passes given username and action type to super constructor.
     * Will also create FileClackData sub-object with filename "cFileName" and
     * fileContents set to an empty string (test will fail if null).
     */

    public FileClackData(String cUsername, String cFileName, int type)
    {
        super(cUsername, type);
        this.fileName = cFileName;
        this.fileContents = "";
    }

    public FileClackData()
    {
        super();
    }

    /**
     * Sets the name of the file to entered value sFileName.
     */
    public void setFileName(String sFileName)
    {
        this.fileName = sFileName;
    }

    /**
     * Returns fileName.
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * Returns fileContents.
     */
    public String getData(String key)
    {
        return decrypt(fileContents, key);
    }

    /**
     * Declaration placeholder, will read from fileContents.
     */
    public void readFileContents()
    {
        try {
            File myObj = new File(fileName);
            Scanner file = new Scanner(myObj);
            while (file.hasNextLine()) {
                fileContents += file.nextLine();
            }
            file.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println( "File does not exist." );
        } catch (IOException ioe) {
            System.err.println( "IO exception occurred." );
        }


    }
    public void readFileContents(String key)
    {

        try {
            File myObj = new File(fileName);
            Scanner file = new Scanner(myObj);
            while (file.hasNextLine()) {
                fileContents += file.nextLine();
            }
            file.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println( "File does not exist." );
        } catch (IOException ioe) {
            System.err.println( "IO exception occurred." );
        }
        encrypt(fileContents, key);


    }

    /**
     * Declaration placeholder, will write to fileContents
     */
    public void writeFileContents()
    {
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(fileContents);
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void writeFileContents(String key)
    {
        decrypt(fileContents,key);
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(fileContents);
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * hashCode() override.
     */
    @Override
    public int hashCode()
    {
        return super.getUserName().hashCode() ^ super.getType() ^ super.getDate().hashCode() ^ fileName.hashCode() ^ fileContents.hashCode();
    }

    /*
     * equals() override
     */
    @Override
    public boolean equals(Object other)
    {
        FileClackData otherData = (FileClackData)other;
        return this.fileName == otherData.fileName && this.fileContents == otherData.fileContents && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
    }

    /**
     * toString() override.
     * returns a full description of the class with all instance variables, as well as those in the super class.
     */
    @Override
    public String toString()
    {
        return "username: " + super.getUserName() 
        + "\ntype: " + super.getType() 
        + "\ndate: " + super.getDate() 
        + "\nfile name: " + fileName
        + "\nfile contents: " + fileContents;
    }
}
