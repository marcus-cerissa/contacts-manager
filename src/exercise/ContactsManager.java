package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class ContactsManager {

    public static void main(String[] args) {
        String directory = "ContactManager";
        String filename = "ContactList.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try {
            if(Files.notExists(dataDirectory)){
                Files.createDirectories(dataDirectory);
            }
            if (Files.notExists(dataFile)){
                Files.createFile(dataFile);
            }


            Files.write(
                    Paths.get("ContactManager", "ContactList.txt"),
                    Arrays.asList("Marcus-1234567890"),
                    StandardOpenOption.APPEND
            );

            List<String> lines = Files.readAllLines(dataFile);
            for(String line : lines){
                System.out.println(line);
            }




        }catch(IOException ioe){

            System.out.println(ioe);

        }

        System.out.println();
        System.out.println();
        System.out.println("Finished Functioning");
    }


}

