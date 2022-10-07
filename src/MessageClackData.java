public class MessageClackData extends ClackData{
    private String message;
/**
 * constructor for message that uses the username and type from clackdata,
 * and has the message
 * */
    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }
    /** default constructor for the message, it sets username and message to null,
     * and the type to 0
     * */
    public MessageClackData(){
        this(null, null, 0);
    }
/**
 * returns the message in a string
 * */
    public String getData(){
        return message;
    }
/** returns hashcode*/
    public int hashCode(){
        return 0x112;
    }
    /** compares usernames, types and messages, then returns true if all are the same*/
    public boolean equals(Object other){
        MessageClackData otherFile = (MessageClackData)other;
        return
                otherFile.getUserName() == super.getUserName() &&
                otherFile.getType() == super.getType() &&
                otherFile.message == this.message;
    } // not sure if it needs to test if the dates are equal, it doesn't work ever if it does
/** converts the data, message, username, and type to a string that can easily be printed*/
    public String toString(){
        return "The date of the message is: " + super.getDate() + "\n" +
                "The contents of the message are: " + this.message + "\n" +
                "The username is: " + super.getUserName() + "\n" +
                "The type is: " + super.getType() + "\n\n";
    }
}
