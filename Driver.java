import java.util.Scanner;

public class Driver {
    private static Scanner input = new Scanner(System.in);
    // private static Person selectedPerson = null; // TODO - import Person class

    public static void main(String args[]) {

    }

    public static void start() {
        while(startMenu());

        end();
    }

    public static void end() {
        // Run any required cleanup
        input.close();
    }

    public static char getMenuInput(){

        // Get the first character from user input
        String line = input.next();
        input.nextLine();
        char selection = line.charAt(0);

        return selection;
    }

    public static Boolean startMenu() {        
        System.out.println("Select from the menu: ");
        System.out.println("1. Create a new person");
        System.out.println("2. Select person from network");
        System.out.println("x. Quit MiniNet");

        char selection = getMenuInput();

        switch (selection) {
            case '1':
                System.out.println("Create a person");
                inputPersonDetails();
                break;
            case '2':
                System.out.println("Case 2");
                break;
            case 'x':
                System.out.println("Exiting");
                return false;
            default:
                System.out.println("Default Case, please select valud input");
        }

        return true;
    }

    private static void selectedPersonMenu(){

    }

    public static void inputPersonDetails(){
        System.out.print("What is your first name? ");
        String firstName = input.nextLine(); // TODO - add validation firstName must exist

        System.out.print("What is your last name? ");
        String lastName = input.nextLine(); // TODO - add validation lastName must exist

        // TODO - add validation firstname and lastname must be unique

        System.out.print("What is your age? ");
        int age = input.nextInt(); // TODO - add validation for age to be reasonable
        input.nextLine();

        if (age < 16) {
            // TODO - Add parent group
        }

        // Optional fields
        System.out.print("Enter an image URL: (optional, enter to skip) ");
        String imageURL = input.nextLine();
        
        System.out.print("Enter a status update: (optional, enter to skip) ");
        String status = input.nextLine();
        
        // TODO - create Person and add to Array
    }
}

/*
! Select a person by name
! Display the profile of the selected person
! Update the profile information of the selected person
! Delete the selected person
! Connect two persons in a meaningful way e.g. friend, parent
! Find out whether a person is a direct friend of another person
! Find out the name(s) of a person’s child(ren) or the names of the parents
*/