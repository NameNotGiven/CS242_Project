public abstract class ClackData {
    //fard
    private String username;
    private int type;
    private Date date;
public class Date{

}
public ClackData(String userName, int type){
    this.username = userName;
    this.type = type;
    this.date = date;
}

public ClackData(int type){
    this.username = "Anon";
}

public ClackData(){

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

    /**abstract method to return data
     */
//    public abstract getData(){
//}

}
