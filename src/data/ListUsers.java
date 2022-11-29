package data;

/**
 * A class used to tell the server to print the names of all users.
 *
 * @author Nikolai Melnikov
 */
public class ListUsers extends ClackData
{

    /**
     * Constructor that has a username and a type int as its parameters.
     *
     * @param userName name of the user requesting list of users
     * @param type type int used to identify the object as a ListUsers object
     */
    public ListUsers(String userName, int type) {
        super(userName, type);
    }

    public String getData() {
        return null;
    }

    public String getData( String input) {
        return null;
    }

}
