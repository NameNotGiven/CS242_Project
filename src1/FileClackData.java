/**
 * class that holds filename and file content
 * */
public class FileClackData extends ClackData {

private String fileName;
private String fileContents;

/**
 * constructor sets up username, fileName, and type
 */
public FileClackData(String username, String fileName, int type){
    super(username, type);
    this.fileName = fileName;
    this.fileContents = null;
}
/**
 * default constructor sets up fileName and fileContents to null, and type to 0
 */
public FileClackData(){
    super(0);
    this.fileName = null;
    this.fileContents = null;
}

/** sets filename */
public void setFileName(String fileName){
    this.fileName = fileName;
}

/**
 * return filename
 * */
public String getFileName(){
    return fileName;
}

/**
 * return fileContents
 * */
public String getData(){
    return fileContents;
}
/** writes file content, nothing for now */
public void readFileContents(){

}
/** writes file content, nothing for now */
public void writeFileContents(){

}
/**
 * return hashcode
 * */
public int hashCode(){
    return 0x123;
}
/**
 * returns true if username, type, filename, and file contents are all the same
 * */
public boolean equals(Object other){
    FileClackData otherFile = (FileClackData)other;
    return
    otherFile.getUserName() == super.getUserName() &&
    otherFile.getType() == super.getType() &&
    otherFile.fileName == this.fileName  &&
    otherFile.fileContents == this.fileContents;
} //not sure if it needs dates to be equal or not

/**
 * returns a string with data, filename, file contents, username, and type
 * */
public String toString(){
    return "The date of the file is: " + super.getDate() + "\n" +
            "The name of the file is: " + this.fileName + "\n" +
            "The contents of the file are: " + this.fileContents + "\n" +
            "The username is: " + super.getUserName() + "\n" +
            "The type is: " + super.getType() + "\n\n";
}
}
