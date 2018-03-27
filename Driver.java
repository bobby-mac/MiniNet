import java.util.ArrayList;
import java.util.Scanner;

import Person;
import Adult;
import Child;
import Infant;

import Log;

public class Driver {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Person> people = new ArrayList<Person>();
    private static Person selectedPerson = null;

    public static void main(String args[]) {

    }

    public static void start(ArrayList<Person> loadedPeople) {
        people = Log.getPeople();

        while(startMenu());

        end();


    }

    private static void end() {
        // Run any required cleanup
        input.close();
    }

    private static int getMenuInput(){

        // Get the first character from user input
        String line = input.next();
        input.nextLine();
        int selection = -1;

        try {
            selection = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number selection");
        }

        return selection;
    }

    private static Boolean startMenu() {        
        System.out.println("Select from the menu: ");
        System.out.println("1. Create a new person");
        System.out.println("2. Select person from network");
        System.out.println("0. Quit MiniNet");

        int selection = getMenuInput();

        switch (selection) {
            case 1:
                System.out.println("Create a person");
                inputPersonDetails();
                break;
            case 2:
                System.out.println("Printing People List");
                printUsers(people, false);

                System.out.println("Select a user ID: ");
                int selectedUserId = getMenuInput();
                if(selectedUserId < 0) {
                    System.out.println("Please select a valid user ID");
                } else {
                    while(selectedPersonMenu(selectedUserId));
                }

                break;
            case 0:
                System.out.println("Exiting");
                return false;
            default:
                System.out.println("Default Case, please select valid input");
        }

        return true;
    }

    private static Boolean selectedPersonMenu(int userId) {
        selectedPerson = people.get(userId);

        System.out.println("Selected Person: " + selectedPerson.getFullName() + "\n");

        System.out.println("Select from the menu: ");
        System.out.println("1. Print full user details");
        System.out.println("2. Add a friend");
        System.out.println("3. List friends");
        System.out.println("0. Go Back");

        int selection = getMenuInput();

        switch (selection) {
            case 1:
                printUser(selectedPerson, true);
                break;
            case 2:
                System.out.println("Select a friend to add");

                printUsersWithFilter(people, "Adult");

                System.out.println("Select a user ID: ");
                int selectedFriendId = getMenuInput();
                
                if(selectedFriendId < 0) {
                    System.out.println("Please select a valid user ID");
                } else {
                    Adult newFriend = (Adult)people.get(selectedFriendId);
                    Adult tempAdult = (Adult) selectedPerson;
                    tempAdult.addFriend(newFriend.getID());
                }

                break;
            case 3:
                System.out.println("TODO - Print list of users friends");
                Adult tempAdult = (Adult) selectedPerson;
                printUsers(tempAdult.getFriends(), true);
                // printUsers(selectedPerson.getFriends()); // TODO - implement getFriends();
                return true;
            case 0:
                System.out.println(); // Print empty line for readability
                return false;
            default:
                System.out.println("Default Case, please select valid input");
        }

        return true;
    }

    private static void inputPersonDetails(){
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

    // Print users from a list of Person objects
    private static void printUsers(ArrayList<Person> peopleList, Boolean fullDetails) {
        System.out.format(
            "%4s%20s%4s\n",
            "User ID",
            "User Name",
            "Age"
        );
        // TODO - make this more robust for displaying large lists
        for (Person person: peopleList) {
            printUser(person, fullDetails);
        }
    }

    private static void printUsersFromId(ArrayList<Integer> peopleList, Boolean fullDetails) {
        System.out.format(
            "%4s%20s%4s\n",
            "User ID",
            "User Name",
            "Age"
        );

        

        // TODO - make this more robust for displaying large lists
        for (Person person: peopleList) {
            printUser(person, fullDetails);
        }
    }

    private static void printUser(Person person, Boolean fullDetails) {
        if(fullDetails) {
            System.out.println("User ID: " + person.getID());
            System.out.println("First Name: " + person.getFirstName());
            System.out.println("Last Name: " + person.getLastName());
            System.out.println("Age: " + person.getAge());
            
            String userStatus = person.getStatus();
            if(userStatus != null) {
                System.out.println("User Status: " + userStatus);
            }

            System.out.println(); // Print empty line for readability

        } else {
            System.out.format(
                "%4d%20s%4d\n",
                person.getID(),
                person.getFullName(),
                person.getAge()
            );
        }
    }

    private static void printUsersWithFilter(ArrayList<Person> people, String filter) {
        ArrayList<Person> filteredPeople = new ArrayList<Person>();

        // TODO - find way to check class type against a string? Probably use a hashmap of classes?
        for(Person person: people) {
            if(person instanceof Adult) {
                filteredPeople.add(person);
            }
        }

        printUsers(filteredPeople, false);
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