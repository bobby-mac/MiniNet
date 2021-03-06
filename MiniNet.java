/**
* MiniNet class sets up and tears down the network ready for use
* by the driver class. Reads from a plain text data file to generate
* users and their relevant connections
* 
* @author  Robert McLoughlin
* @version 1.0
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;


public class MiniNet {
    private static ArrayList<Person> people = new ArrayList<Person>();

    public static void main(String args[]){
        String filename = "./miniNet.dat";
        String line = "";
        
        // Read initial data file to load network
        try {
            FileReader fileReader = 
                new FileReader(filename);

                BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] personData = line.split(";");
                Person p = null;

                LocalDate date1 = LocalDate.parse(personData[3], DateTimeFormatter.BASIC_ISO_DATE);

                switch (personData[0]) {
                    case "adult":
                        p = new Adult(
                            personData[1], // First Name
                            personData[2], // Last Name
                            date1, //DOB
                            "password" // Password
                        );
                        break;
                    case "child":
                        p = new Child(
                            personData[1], // First Name
                            personData[2], // Last Name
                            date1, //DOB
                            "password", // Password
                            new int[] {
                                Integer.parseInt(personData[4]), 
                                Integer.parseInt(personData[5])
                            } // Parent Ids
                        );
                        break;
                    default:
                        System.out.println("Can't see that user type in our system, skipping");

                }

                Log.addProfile(p);
            }

            bufferedReader.close();

        } catch(FileNotFoundException ex) {
            System.out.println(
                "No data file to open for '" + 
                filename + "' creating new MiniNet database");
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filename + "'");
        }

        // Start driver class - pass through array of People
        Driver.start(people);
    }
}