public class FileClackData extends ClackData {

private String fileName;
private String fileContents;

/**
 sets up username, fileName, and type
 */
public FileClackData(String username, String fileName, int type){
    super(username, type);
    this.fileName = fileName;
    this.fileContents = null;
}

public FileClackData(){
    super(0);
    this.fileName = null;
    this.fileContents = null;
}

/** sets filename */
public void setFileName(String fileName){
    this.fileName = fileName;
}

public String getFileName(){
    return fileName;
}


public String getData(){
    return fileContents;
}

public void readFileContents(){

}

public void writeFileContents(){

}

public int hashCode(){
    return 0x123;
}

public boolean equals(Object other){
    FileClackData otherFile = (FileClackData)other;
    return
    otherFile.getUserName() == super.getUserName() &&
    otherFile.getType() == super.getType() &&
    otherFile.fileName == this.fileName  &&
    otherFile.fileContents == this.fileContents;
} //not sure if it needs dates to be equal or not

public String toString(){
    return "The date of the file is: " + super.getDate() + "\n" +
            "The name of the file is: " + this.fileName + "\n" +
            "The contents of the file are: " + this.fileContents + "\n" +
            "The username is: " + super.getUserName() + "\n" +
            "The type is: " + super.getType() + "\n\n";
}
}
