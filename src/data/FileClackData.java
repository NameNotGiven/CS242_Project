package data;
import java.io.*;
import java.util.*;
import java.io.Serializable;

/**
 * The class creates a FileClackData that is a subclass of ClackData. Additionally, FileClackData has a filename
 * represented by a string and the file's contents (fileContents) represented by a string.
 *
 * @author Nikolai Melnikov
 */
public class FileClackData extends ClackData
{
    private String fileName;

    private String fileContents;

    private static final String DEFAULT_FILE_CONTENTS = null;

    private static final String DEFAULT_FILE_NAME = "filename";

    /**
     * FileClackData constructor that initializes the userName, fileName, and type with user provided data. Sets the
     * file contents to be null for the time being, incomplete code segment.
     *
     *
     * @param userName          userName of the sender of the FileClackData, inherited from ClackData
     * @param fileName          fileName of the file in FileClackData
     * @param type              dictates the type of FileClackData, inherited from ClackData
     */
    public FileClackData(String userName,String fileName, int type)
    {
        super(userName, type);
        this.fileName = fileName;
        this.fileContents = DEFAULT_FILE_CONTENTS;
    }

    /**
     * FileClackData default constructor that initializes the username to "anon", fileName to "filename", and
     * type to 3.
     */
    public FileClackData()
    {
        this(ANONYMOUS_USER, DEFAULT_FILE_NAME, CONSTANT_SENDFILE);
    }

    /**
     * This is a mutator for the fileName of FileClackData
     *
     * @param fileName          new fileName string
     */
    public void setFileName(String fileName) { this.fileName = fileName; }

    /**
     * This is an accessor for the fileName
     *
     * @return          string of the fileName for FIleClackData
     */
    public String getFileName() { return this.fileName; }

    /**
     * Reads from a file, using FileClackData's fileName, to determine FileClackData's fileContents
     *
     * @throws IOException          Exception thrown if file is not found
     */
    public void readFileContents() throws IOException
    {
        this.fileContents = "";

        try {
            Scanner scan = new Scanner(new File(this.fileName));
            while (scan.hasNext()) {
                String nextString = scan.next();
                this.fileContents += nextString + " ";
            }
            scan.close();
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("FileNotFoundException: " + fnfe.getMessage());
        } catch (IOException ioe) {
            throw new IOException("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Reads from an encrypted file, using FileClackData's fileName and key (for decryption), to determine FileClackData's fileContents
     *
     * @param key                   string of the key used to form the decryption, combination of letters.
     * @throws IOException          Exception thrown if file is not found
     */
    public void readFileContents(String key) throws IOException
    {
        this.fileContents = "";

        try {
            Scanner scan = new Scanner(new File(this.fileName));
            while (scan.hasNext()) {
                String nextString = scan.next();
                this.fileContents += nextString  + " ";
            }
            scan.close();

            this.fileContents = encrypt(this.fileContents, key);
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException( "FileNotFoundException: " + fnfe.getMessage() );
        } catch (IOException ioe) {
            throw new IOException( "IOException: " + ioe.getMessage());
        }
    }

    /**
     * Writes a file, using FileClackData's fileName, with its content being fileContents
     * @throws IOException          IOException
     */
    public void writeFileContents() throws IOException
    {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(this.fileContents);

        } catch (IOException ioe) {
            throw new IOException("IOException: " + ioe.getMessage());
        }

        try {
            writer.close();
        } catch (IOException ioe) {
            throw new IOException("IOException while closing file: " + ioe.getMessage());
        }
    }

    /**
     * Writes an encrypted file, using FileClackData's fileName and key (for encryption), with its content being an encrypted FileClackData's fileContents
     *
     * @param key           string of the key used to form the encryption, combination of letters.
     * @throws IOException          IOException
     */
    public void writeFileContents(String key) throws IOException
    {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(decrypt(this.fileContents, key));

        } catch (IOException ioe) {
            throw new IOException("IOException: " + ioe.getMessage());
        }

        try {
            writer.close();
        } catch (IOException ioe) {
            throw new IOException("IOException while closing file: " + ioe.getMessage());
        }
    }

    /**
     * Creates a unique hashcode for a FIleClackData. Does not hashcode fileContents due to it being set to null
     * since it is an incomplete variable.
     *
     * @return          an integer hashCode
     */
    @Override
    public int hashCode()
    {
        int result = 17;
        int prime = 37;

        result = prime * result + getType();
        result = prime * result + getDate().hashCode();
        result = prime * result + getUserName().hashCode();
        // result = prime * result + this.fileContents.hashCode();  |||| this is null; we cannot hashcode yet
        result = prime * result + this.fileName.hashCode();

        return result;
    }

    /**
     * Checks if two FIleCLackData objects are equal to each other or not. Equal in this circumstance means equivalent
     * type, userName, date, fileName, and fileContents. Does not use fileContents due to it being set to null
     * since it is an incomplete variable.
     *
     * @param obj           dictates the second FileCLackData object that the first FileClackData is comparing to
     * @return              a boolean that determines if the FileClackData's are equal or not
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (!(obj instanceof FileClackData)) return false;

        FileClackData fcd = (FileClackData) obj;

        return this.getType() == fcd.getType() &&
                this.getUserName().equals(fcd.getUserName()) &&
                this.getDate().equals(fcd.getDate()) &&
                this.fileName.equals(fcd.fileName) &&
                this.fileContents.equals(fcd.fileContents);

    }

    /**
     * Turns all data inside FileClackData into a string output. The data includes: a type, userName, date, fileName,
     * fileContents, and a hashCode.
     *
     * @return          string of all data inside FileClackData into a readable format
     */
    @Override
    public String toString()
    {
        return "This is FileClackData that is type, " + getType() + ", from user, " + getUserName() +
                ", at, " + getDate() + ", containing the file named, " + this.fileName + ", with the contents, " +
                this.fileContents + ", the hash code is " + hashCode();
    }

    /**
     * This is an accessor for FIleClackData's "Data".
     *
     * @return          a string of FileClackData's fileContents
     */
    public String getData()  { return this.fileContents; }

    /**
     * This is an overridden accessor for FIleClackData's "Data".
     *
     * @param key               string of the key used to form the decryption, combination of letters.
     * @return                  a string of FileClackData's decrypted fileContents
     */
    public String getData(String key) { return decrypt(this.fileContents, key); }
}
