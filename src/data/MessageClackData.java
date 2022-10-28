// Message Data for Clack
// Andrew Tringali 10/3/22

package data;

public class MessageClackData extends ClackData {
    
    //  members
    private String message;

    /**
     * Passes given name and action type to super constructor.
     * Also creates MessageClackData sub-object with message set to "cMessage" string.
     */
    public MessageClackData(String cUsername, String cMessage, int cType)
    {
        super(cUsername, cType);
        this.message = cMessage;
    }

    /**
     * Default constructor, calls super constructor with no arguments.
     */
    public MessageClackData()
    {
        super();
    }


    MessageClackData( String userName, String message, String key, int type )
    {
        super(userName, type);

        this.message = super.encrypt(message, key);
    }

    /**
     * Returns the contents of message.
     */
    public String getData(String key)
    {
        return decrypt(message, key);
    }

    /**
     * hashcode() override.
     */
    @Override
    public int hashCode()
    {
        return super.getUserName().hashCode() ^ super.getType() ^ super.getDate().hashCode() ^ message.hashCode();
    }
    
    /**
     * equals() override.
     */
    @Override
    public boolean equals(Object other)
    {
        MessageClackData otherData = (MessageClackData)other;
        return this.message == otherData.message && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
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
        + "\nmessage: " + message;
    }

}
