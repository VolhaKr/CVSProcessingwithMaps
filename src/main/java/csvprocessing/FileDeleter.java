package csvprocessing;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileDeleter {

    public static void deleteFile(String directoryPath, String RESULT_FILE) {
        String fileToDelete = String.valueOf(Paths.get(directoryPath + RESULT_FILE));
        //String fileToDelete = directory + "\\" + fileName;
        System.out.println("File to delete " + fileToDelete);
        try {
            Files.deleteIfExists(Paths.get(fileToDelete));
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        } catch (IOException e) {
            System.out.println("Invalid permissions.");
        }
        System.out.println("Deletion successful.");
    }
}
