import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        String destinationDir, zippedDir;

        String myOS = System.getProperty("os.name");
        if(!myOS.equals("Windows 10")){
            destinationDir = currentDirectory + "/Documents";
            zippedDir = currentDirectory + "/ZippedFiles/png2jpg.zip";
        } else{
            destinationDir = currentDirectory + "\\Documents";
            zippedDir = currentDirectory + "\\ZippedFiles\\png2jpg.zip";
        }

        Utilities.UnZip(zippedDir, destinationDir);
        System.out.println("Current Directory: " + destinationDir);
        System.out.println("Zipped Directory: " + zippedDir);
    }
}
