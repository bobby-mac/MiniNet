import java.util.Scanner;
import java.io.*;

// TODO - import Person class
import Driver;

public class MiniNet {
    public static void main(String args[]){
        String filename = "miniNet.dat";
        String line = "";

        // Read initial data file to load network
        try {
            FileReader fileReader = 
                new FileReader(filename);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // TODO - Create Person object for each line in datafile
                System.out.println(line);
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
        Driver.start();
    }
}