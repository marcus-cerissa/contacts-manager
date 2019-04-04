package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;



public class ContactsManager {


    Scanner scanner = new Scanner(System.in);

    public void runApp(){

        this.createFile();
        System.out.println(this.getMenu());
        this.appendFile();
        this.listFile();

    }

    public void createFile(){

        String directory = "ContactsManager";
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


    public void appendFile() {

        String directory = "ContactsManager";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        System.out.println("What is the full name of the contact you want to add?");
        String userName = scanner.nextLine();


        System.out.println("What is the number of the contact you want to add?");
        String userNumber = scanner.nextLine();

        try {

        Files.write(
                Paths.get("ContactsManager", "contacts.txt"),
                Arrays.asList(userName + " | " + userNumber),
                StandardOpenOption.APPEND
        );

        } catch (Exception e) {

        }


    }


    public void listFile(){

        String directory = "ContactsManager";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);


        try {

        List<String> lines = Files.readAllLines(dataFile);
        for(String line : lines){
            System.out.println(line);
        }

        } catch (Exception e) {


        }



   }


    public String getMenu() {

        return  "Enter an option (1, 2, 3, 4, or 5):\n" +
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n";
    }



    public static void main(String[] args) {

        System.out.println();
        System.out.println();
        System.out.println("Finished Functioning");

    }  // main method


}  // ContactsManager class

