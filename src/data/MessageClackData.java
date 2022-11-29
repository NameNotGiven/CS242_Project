package data;

import java.io.Serializable;

/**
 * The class creates a MessageClackData that is a subclass of ClackData. Additionally, MessageClackData has a message
 * that is represented by a string.
 *
 * @author Nikolai Melnikov
 */
public class MessageClackData extends ClackData
{

    private final String message;

    private static final String DEFAULT_MESSAGE = "Hello!";

    /**
     * MessageClackData constructor that initializes the userName, message, and type with user provided data.
     *
     * @param userName          userName of the sender of the MessageClackData, inherited from ClackData
     * @param message           string of a message in MessageClackData
     * @param type              dictates the type of MessageClackData, inherited from ClackData
     */
    public MessageClackData(String userName, String message, int type)
    {
        super(userName, type);
        this.message = message;
    }

    /**
     * MessageClackData default constructor that initializes the userName to "anon", message to "Hello!", and type to 2
     */
    public MessageClackData() { this(ANONYMOUS_USER, DEFAULT_MESSAGE, CONSTANT_SENDMESSAGE); }

    /**
     * MessageClackData constructor that initializes the userName, message, key, and type with user provided data.
     * The message is encrypted using "key" as the encryption key
     * @param userName          userName of the sender of the MessageClackData, inherited from ClackData
     * @param message           string of a message in MessageClackData
     * @param key               string of the key used to form the encryption, combination of letters.
     * @param type              dictates the type of MessageClackData, inherited from ClackData
     */
    public MessageClackData(String userName, String message, String key, int type)
    {
        super(userName, type);
        this.message = encrypt(message, key);
    }

    /**
     * Creates a unique hashcode for a MessageClackData
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
        result = prime * result + this.message.hashCode();

        return result;
    }

    /**
     * Checks if two MessageCLackData objects are equal to each other or not. Equal in this circumstance means
     * equivalent type, userName, date, and message.
     *
     * @param obj           dictates the second MessageCLackData object that the first MessageClackData is comparing to
     * @return              a boolean that determines if the MessageClackData's are equal or not
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (!(obj instanceof MessageClackData)) return false;

        MessageClackData mcd = (MessageClackData)obj;

        return this.getType() == mcd.getType() &&
                this.getUserName().equals(mcd.getUserName()) &&
                this.getDate().equals(mcd.getDate()) &&
                this.message.equals(mcd.message);

    }

    /**
     * Turns all data inside MessageClackData into a string output. The data includes: a type, userName, date, message,
     * and a hashCode.
     *
     * @return          string of all data inside FileClackData into a readable format
     */
    @Override
    public String toString()
    {
        return "This is MessageClackData that is type, " + getType() + ", from user, " + getUserName() +
                ", at, " + getDate() + ", stating, " + this.message + ", the hash code is " + hashCode();
    }

    /**
     * This is an accessor for MessageClackData's "Data".
     *
     * @return          a string of MessageClackData's message
     */
    public String getData() {
        return this.message;
    }

    /**
     * This is an overridden accessor for MessageClackData's "Data".
     *
     * @param key           string of the key used to form the decryption, combination of letters.
     * @return              a string of MessageClackData's decrypted message
     */
    public String getData(String key) {
        return decrypt(this.message, key);
    }
}
