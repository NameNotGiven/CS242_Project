import java.util.Date;
/**
 * Class ClackData is a superclass that represents the data sent between the client and the
 * server. An object of type ClackData consists of the username of the client user, the date and
 * time at which the data was sent and the data itself, which can either be a message
 * (MessageClackData) or the name and contents of a file (FileClackData). MessageClackData
 * and FileClackData are both children of ClackData. Note that ClackData should not be
 * instantiable, but MessageClackData and FileClackData should be.
 * */
public abstract class ClackData {
    private String username;
    private int type;
    private Date date;

    static final int CONSTANT_LISTUSERS = 0;
/**
 * constructor to set up userName and type, date should be
 * automatically created here
 * */
public ClackData(String userName, int type){
    this.username = userName;
    this.type = type;
    this.date = new Date();
}
/**
 * constructor to create anonymous user, whose name is "Anon"
 * should call another constructor*/
public ClackData(int type){
    this("Anon", type);
}

public ClackData(){
    this(0);
}
    //accessor returns type
public int getType(){
    return type;
}
//accessor returns username
public String getUserName(){
    return username;
}
//accessor returns date
public Date getDate(){
    return date;
}
public abstract String getData();

}
