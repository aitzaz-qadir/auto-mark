import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Utilities {
    public static void UnZip(String zipFilePath, String destinationFolder) throws IOException {
        try{
            File destDir = new File(destinationFolder);
            // Create the destination directory if it doesn't exist
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            // Open the ZIP file
            FileInputStream fis = new FileInputStream(zipFilePath);
            ZipInputStream zipInputStream = new ZipInputStream(fis);

            // Read and extract each entry in the ZIP file
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                String entryName = entry.getName();
                File entryFile = new File(destinationFolder, entryName);

                // Create directories if necessary
                if (entry.isDirectory()) {
                    entryFile.mkdirs();
                } else {
                    // Create the parent directories if they don't exist
                    File parent = entryFile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    // Write the file content
                    FileOutputStream fos = new FileOutputStream(entryFile);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                    fos.close();
                }
            }

            // Close the ZIP input stream
            zipInputStream.close();
            fis.close();
            System.out.println("File unzipped successfully to: " + destinationFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
