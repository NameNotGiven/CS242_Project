package data;

public class ListUsersData extends ClackData
{

    String users;

    public ListUsersData(String users )
    {
        super("server", CONSTANT_LISTUSERS);
        this.users = users;
    }

    public String getData() {
        return users;
    }

}
