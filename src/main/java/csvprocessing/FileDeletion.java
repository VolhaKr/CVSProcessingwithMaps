package csvprocessing;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileDeletion {

    public void deleteFile(String directory, String fileName) {
        String fileToDelete = directory + "\\" + fileName;
        // System.out.println(fileToDelete);
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
