package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class ContactsManager {

    public void createFile(){

        String directory = "ContactManager";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);


        try {
            if(Files.notExists(dataDirectory)){
                Files.createDirectories(dataDirectory);
            }
            if (Files.notExists(dataFile)){
                Files.createFile(dataFile);
            }


        }catch(IOException ioe){

            System.out.println(ioe);

        }

    }


    public void appendFile(){

        ///////// needs a try/catch block ///////////
        Files.write(
                Paths.get("ContactManager", "contacts.txt"),
                Arrays.asList("Marcus-1234567890"),
                StandardOpenOption.APPEND
        );

    }

    public void listFile(Path dataFile){

        ////////// needs a try/catch block ////////
        List<String> lines = Files.readAllLines(dataFile);
        for(String line : lines){
            System.out.println(line);
        }

    }

    public static void main(String[] args) {


        System.out.println();
        System.out.println();
        System.out.println("Finished Functioning");
    }


}

