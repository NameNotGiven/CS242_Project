// Data Class for Clack
// Andrew Tringali 10/3/22

package data;
import java.util.Date;

public abstract class ClackData {
    
    //members
    private String username;
    private int type;
    private Date date;

    //type variable constants
    public static final int CONSTANT_LISTUSERS = 0;
    public static final int CONSTANT_LOGOUT = 1;
    public static final int CONSTANT_SENDMESSAGE = 2;
    public static final int CONSTANT_SENDFILE = 3; 

    /**
     * Creates ClackData object with name "username," action type "cType".
     * Date is automatically set based on the current time.
     */
    public ClackData(String cUsername, int cType)
    {
        this.username = cUsername;
        this.type = cType;
        this.date = new Date();
    }

    /**
     * If a name isn't specified, will use "anon" for an anonymous user.
     */
    public ClackData(int cType)
    {
        this("anon", cType);
    }

    /**
     * Default constructor.
     */
    public ClackData()
    {
        this("anon", CONSTANT_LOGOUT);
    }

    /**
     * Returns the type.
     */
    public int getType()
    {
        return this.type;
    }

    /**
     * Returns the username.
     */
    public String getUserName()
    {
        return this.username;
    }

    /**
     * Returns the date.
     */
    public Date getDate()
    {
        return this.date; // returns a reference, not a copy
    }

    /**
     * Placeholder data, function overridden in MessageClackData and FileClackData.
     */

    protected String encrypt(String inputStringToEncrypt, String key)
    {
        int x = inputStringToEncrypt.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == inputStringToEncrypt.length())
                break;
            key+=(key.charAt(i));
        }

        String encoded_text="";
        x = 0;
        for (int i = 0; i < inputStringToEncrypt.length(); i++)
        {
            x = (inputStringToEncrypt.charAt(i) + key.charAt(i)) %52;
            x += 'A';

            encoded_text+=(char)(x);
        }
        return encoded_text;
    }

    protected String decrypt(String inputStringToDecrypt, String key)
    {
        int x = inputStringToDecrypt.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == inputStringToDecrypt.length())
                break;
            key+=(key.charAt(i));
        }

        String original_text="";
        x = 0;
        for (int i = 0 ; i < inputStringToDecrypt.length() &&
                i < key.length(); i++)
        {
            x = (inputStringToDecrypt.charAt(i) -
                    key.charAt(i) + 26) %52;

            x += 'A';
            original_text+=(char)(x);
        }
        return original_text;
    }

    abstract String getData(String key);
}

