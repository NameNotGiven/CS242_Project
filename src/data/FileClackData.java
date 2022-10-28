// File Data for Clack
// Andrew Tringali 10/3/22

package data;

import java.io.IOException;

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
        try{
            boolean doneReading = false;
            while(!doneReading){

            }

        } catch(IOException ioe){
            System.err.println("Error reading contents");
        }

    }
    public void readFileContents(String key)
    {
        try{

        } catch(IOException ioe){
            System.err.println("Error reading key");
        }

    }

    /**
     * Declaration placeholder, will write to fileContents
     */
    public void writeFileContents()
    {
        try{

        } catch()

    }
    public void writeFileContents(String key)
    {
        try{

        } catch()

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
