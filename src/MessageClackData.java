public abstract class MessageClackData extends ClackData{
    private String message;

    public MessageClackData(String userName, String message, int type){

    }
    public MessageClackData(){

    }

    //unsure how to implement right now
    //public ClackData getData(){
    //}

    public int hashCode(){
        return 0x112;
    }
    public boolean equals(){
        return false;
    }

    public String toString(){
        return "";
    }
}
