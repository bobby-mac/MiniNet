import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;

import Driver;
import Person;
import Adult;
import Child;
import Infant;

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
                // TODO - Create Person object for each line in datafile
                String[] personData = line.split(";");
                Person p = null;

                switch (personData[0]) {
                    case "adult":
                        p = new Adult(
                            personData[1], // First Name
                            personData[2], // Last Name
                            Integer.parseInt(personData[3]), // Age
                            "password" // Password
                        );
                        break;
                    case "child":
                        p = new Child(
                            personData[1], // First Name
                            personData[2], // Last Name
                            Integer.parseInt(personData[3]), // Age
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

                people.add(p);
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