public abstract class MessageClackData extends ClackData{
    private String message;

    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }
    public MessageClackData(){
        this(null, null, 0);
    }

    public String getData(){
        return message;
    }

    public int hashCode(){
        return 0x112;
    }
    public boolean equals(Object other){
        MessageClackData otherFile = (MessageClackData)other;
        return otherFile.getDate() == super.getDate() &&
                otherFile.getUserName() == super.getUserName() &&
                otherFile.getType() == super.getType() &&
                otherFile.message == this.message;
    }

    public String toString(){
        return "The date of the message is: " + super.getDate() + "\n" +
                "The contents of the message are: " + this.message + "\n" +
                "The username is: " + super.getUserName() + "\n" +
                "The type is: " + super.getType() + "\n\n";
    }
}
