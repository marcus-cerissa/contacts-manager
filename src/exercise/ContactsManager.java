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
import java.lang.String;


public class ContactsManager {

    static String directory = "src/.";
    static String filename = "contacts.txt";

    static Path p = Paths.get(directory, filename);
    public Scanner scanner = new Scanner(System.in);


    public void runApp(){

//        this.createFile();
        System.out.println(this.getMenu());
        this.getMenu();
        this.menuChoice();

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

    public int menuChoice(){

        System.out.println("\nPlease enter a number from 0 - 5: ");

        int userChoice = scanner.nextInt();

        if(userChoice == 0){

            System.out.println("EXIT");

        }else if(userChoice == 1){

            System.out.println("VIEW ALL");
            this.listFile();


        }else if(userChoice == 2){

            System.out.println("ADD CONTACT");
            this.appendFile();

        }else if(userChoice == 3){

            System.out.println("SEARCH CONTACT");


        }else if(userChoice == 4){

            System.out.println("DELETE CONTACT");
            this.deleteContact();

        }else if(userChoice == 5){

            System.out.println("EXIT APP");

        }
        scanner.nextLine();

        System.out.println("Would you like to choose again? (y/n)");
        String userContinue = scanner.next();

        if(userContinue.equalsIgnoreCase("y")){
            this.runApp();
        }else{
            System.out.println("\n\nGoodBye\nWe hope you enjoyed your stay.");
        }

        return userChoice;

    }



    public void appendFile() {

        String directory = "ContactsManager";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        System.out.println("What is the full name of the contact you want to add?");
        String userName = scanner.nextLine();

        scanner.nextLine();

        System.out.println("What is the number of the contact you want to add?");
        int userNumber = scanner.nextInt();

        try {

        Files.write(
                Paths.get("ContactsManager", "contacts.txt"),

//                List<String> list = new ArrayList<String>(Arrays.asList(userName + " | " + userNumber)),     // CA 2nd

//                List<String> filename = new ArrayList<>(),            // CA 3rd
//                userName.add(userName + " | " + userNumber);



            Arrays.asList(userName + " | " + userNumber),          // MA 1st

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
        for(int i = 0; i < lines.size(); i ++){
            System.out.println(i + ": " + lines.get(i));
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



    public void deleteContact() {

        String directory = "ContactsManager";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        System.out.println("\nEnter the number of the contact you want to delete: \n");
        int userInput = scanner.nextInt();

        try {

            List<String> lines = Files.readAllLines(dataFile);
            lines.remove(userInput);
            Files.write(Paths.get("ContactsManager", "contacts.txt"), lines);

        }catch(Exception e){

            System.out.println("DELETE FILE ERROR");

        }

    }  // deleteContact




    public static void main(String[] args) {
    ContactsManager CM = new ContactsManager();
    CM.runApp();

    }  // main method



}  // ContactsManager class

