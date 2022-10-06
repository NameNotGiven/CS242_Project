import java.util.Date;
public abstract class ClackData {
    private String username;
    private int type;
    private Date date;

    static final int CONSTANT_LISTUSERS = 0;

public ClackData(String userName, int type){
    this.username = userName;
    this.type = type;
    this.date = new Date();
}

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
