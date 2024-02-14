import Exceptions.MyException_DoesNotExistTheElement;
import Exceptions.MyException_FileNotFoundExcetiont;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesWork {
    private Path pathFileWork;
    public FilesWork(Path pathFileWork){
            this.pathFileWork = pathFileWork;
    }
    public void writeFile(UserData user,boolean userLastName){
        try (BufferedWriter writer = Files.newBufferedWriter(pathFileWork)) {
           if (userLastName) writer.append(user.toString());
            else writer.write(user.toString());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readFile() throws IOException {
        if (Files.notExists(pathFileWork)) {
            throw new MyException_FileNotFoundExcetiont();
        } else {
            try (BufferedReader reader = Files.newBufferedReader(pathFileWork)) {
                String line;
                while ((line = reader.readLine()) !=null ) {
                    System.out.println(line);
                }
            }
        }
    }
}
