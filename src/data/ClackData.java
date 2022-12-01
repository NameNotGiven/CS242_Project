package data;

import java.util.Date;
import java.io.Serializable;

/**
 * This class creates a ClackData which represents data being sent to and from a server and a user in the program Clack.
 * This class contains a userName represented by a string (the sender of the data), a type represented by an integer
 * (0,1,2,3 respective to the order of the following list),
 *      (CONSTANT_LISTUSERS: give a listing of all users connected to this session
 *      CONSTANT_LOGOUT: log out, i.e., close this client’s connection
 *      CONSTANT_SENDMESSAGE: send a message
 *      CONSTANT_SENDFILE: send a file)
 * and a date and time the ClackData object was made, stored using the class Date from java.util.Date.
 * This is a superclass of FileClackData and MessageClackData.
 *
 * @author Nikolai Melnikov
 */

public abstract class ClackData implements Serializable {

    private final String userName;

    private final int type;

    private final Date date;

    public static final int CONSTANT_LISTUSERS = 0;

    public static final int CONSTANT_LOGOUT = 1;

    public static final int CONSTANT_SENDMESSAGE = 2;

    public static final int CONSTANT_SENDFILE = 3;

    protected static final String ANONYMOUS_USER = "Anon";


    /**
     * ClackData constructor initializes the userName and type with user-provided data. It initializes the date to the
     * date and time of the construction of the object ClackData using the default constructor of the class Date found
     * in java.util.Date.
     *
     * @param userName      userName of the sender of the ClackData
     * @param type          sets the type of ClackData
     */
    public ClackData(String userName, int type)
    {
        this.userName = userName;
        this.type = type;
        this.date = new Date();
    }

    /**
     * ClackData constructor initializes the type with user-provided data. It initializes
     * the userName to "anon", an anonymous user. It also creates
     * a date at the time of ClackData's creation.
     *
     * @param type          sets the type of ClackData
     */
    public ClackData(int type) { this(ANONYMOUS_USER, type); }

    /**
     * Default constructor that initializes the userName to "anon" and the type to 0,
     * Also, it creates a date at the time of ClackData's creation.
     */
    public ClackData() {
        this (ANONYMOUS_USER, CONSTANT_LISTUSERS);
    }

    /**
     * Accessor that returns the type integer
     *
     * @return          integer representing the type of the ClackData object
     */
    public int getType() {
        return this.type;
    }

    /**
     * Accessor that returns userName
     *
     * @return          string of the userName of the ClackData's sender
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Accessor that returns the creation date
     *
     * @return          creation time/date of the ClackData object
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Encrypts a string using a Vigenère cipher, given a key
     *
     * @param inputStringToEncrypt          String to be encrypted
     * @param key                           String of the encryption key, a combination of letters
     * @return                              An encrypted version of the inputString
     */
    protected String encrypt( String inputStringToEncrypt, String key )
    {
        String output = "";
        for (int i = 0, n = 0; i < inputStringToEncrypt.length(); i++)
        {
            char nextChar = inputStringToEncrypt.charAt(i);

            // ASCII 65 is 'A', 90 is 'Z', 97 is 'a', 122 is 'z'
            if ( (int)nextChar >= 65 && (int)nextChar <= 90 )
            {
                output += (char)(((nextChar - 65) + (Character.toUpperCase(key.charAt(n)) -65)) % 26 + 65);
                n = ++n % key.length();
            }
            else if ( (int)nextChar >= 97 && (int)nextChar <= 122 )
            {
                output += (char)(((nextChar - 97) + (Character.toLowerCase(key.charAt(n)) -97)) % 26 + 97);
                n = ++n % key.length();
            }

            else output += nextChar;

        }

        return output;
    }


    /**
     * Decrypts a string using a Vignère cipher, given a key
     *
     * @param inputStringToDecrypt          String of an input to be decrypted
     * @param key                           String of the key used to form the decryption, combination of letters.
     * @return                              A decrypted version of the inputString
     */
    protected String decrypt( String inputStringToDecrypt, String key )
    {
        String output = "";
        for (int i = 0, n = 0; i < inputStringToDecrypt.length(); i++)
        {
            char nextChar = inputStringToDecrypt.charAt(i);

            // ASCII 97 is 'a', 122 is 'z', 90 is 'Z', and 65 is 'A'
            if ((int)nextChar >= 65 && (int)nextChar <= 90)
            {
                output += (char)((nextChar - Character.toUpperCase(key.charAt(n)) + 26) % 26 + 65);
                n = ++n % key.length();
            }
            else if ((int)nextChar >= 97 && (int)nextChar <= 122)
            {
                output += (char)((nextChar - Character.toLowerCase(key.charAt(n)) + 26) % 26 + 97);
                n = ++n % key.length();
            }

            else output += nextChar;

        }
        return output;
    }

    /**
     * Accessor that returns data.
     *
     * @return          Data of an indeterminate type
     */
    public abstract Object getData();

    /**
     * Accessor that returns data using a key to decipher to data.
     *
     * @return          Data of an indeterminate type
     */

}