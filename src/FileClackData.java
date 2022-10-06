public abstract class FileClackData extends ClackData {

private String fileName;
private String fileContents;

/**
 sets up username, fileName, and type
 */
public FileClackData(String userName, String fileName, int type){
 //call super
}

public FileClackData(){
//call super
}

/** sets filename */
public void setFileName(String fileName){
    this.fileName = fileName;
}

public String getFileName(){
    return fileName;
}

// i am not totally sure how to go about the data object right now
//public Data getData(){
//    return data;
//}

public void readFileContents(){

}

public void writeFileContents(){

}

public int hashCode(){
    return 0x123;
}

public boolean equals(){
    return false;
}

public String toString(){
    return "";
}
}
