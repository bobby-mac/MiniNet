import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

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
        Adult tempAdult = null;
        Child tempChild = null;
        try {
            selectedPerson = people.get(Log.getByID(userId));
        } catch (NullPointerException e) {
            System.out.println("No user with that ID exists");
            return false;
        }

        if(selectedPerson instanceof Adult) {
            tempAdult = (Adult)selectedPerson;
        } else {
            tempChild = (Child)selectedPerson;
        }

        System.out.println("Selected Person: " + selectedPerson.getFullName() + "\n");

        System.out.println("Select from the menu: ");
        System.out.println("1. Print full user details");
        System.out.println("2. Add a friend");
        System.out.println("3. List friends");

        if (selectedPerson instanceof Adult) { 
            System.out.println("4. List Dependents");
        } else {
            System.out.println("4. List Parents");
        }

        System.out.println("5. Remove User");
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
                    try {
                        Person tempPerson = people.get(Log.getByID(selectedFriendId));

                        if(tempPerson instanceof Adult && selectedPerson instanceof Adult) {
                            Adult currentPerson = (Adult) selectedPerson;
                            Adult newFriend = (Adult)tempPerson;

                            currentPerson.addFriend(newFriend.getID());
                            newFriend.addFriend(currentPerson.getID());
                        } else if(tempPerson instanceof Child && selectedPerson instanceof Child) {
                            Adult currentPerson = (Adult) selectedPerson;
                            Adult newFriend = (Adult)tempPerson;

                            currentPerson.addFriend(newFriend.getID());
                            newFriend.addFriend(currentPerson.getID());
                        } else {
                            System.out.println("Users must of same type to be friends");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("No user with that ID exists");
                        return false;
                    }
                }

                break;
            case 3:
                tempAdult = (Adult) selectedPerson;
                printUsersFromId(tempAdult.getFriends(), true);
                return true;
            case 4:
                if(selectedPerson instanceof Adult) {
                    System.out.println("Dependents");
                    System.out.println("******************");
                    
                    tempAdult = (Adult)selectedPerson;
                    printUsersFromId(tempAdult.getDependents(), true);
                } else {
                    System.out.println("Parents");
                    System.out.println("******************");

                    tempChild = (Child)selectedPerson;
                    printUsersFromId(tempChild.getParents(), true);
                }
                return true;
            case 5:
                removeFriends(selectedPerson);
                int personId = Log.getByID(selectedPerson.getID());
                people.remove(personId);
                System.out.println(); // Print empty line for readability
                return false;
            case 0:
                System.out.println(); // Print empty line for readability
                return false;
            default:
                System.out.println("Default Case, please select valid input");
        }

        return true;
    }

    private static String getDOBInput(String prompt) {
        System.out.print(prompt);

        // input.nextLine();
        int year = 0;
        int month = 0;
        int day = 0;

        do {
            year = getIntegerInput("Please enter your year of birth: ");
        } while (year < 1900 || year > Year.now().getValue());

        do {
            month = getIntegerInput("Please enter your month of birth: ");
        } while (month < 1 || month > 12);

        do {
            day = getIntegerInput("Please enter your day of birth: ");
        } while (day < 1 || day > 30);

        String monthString = "" + month;
        if(month < 10) {
            monthString = "0" + month;
        }

        String dayString = "" + day;
        if(day < 10) {
            dayString = "0" + day;
        }

        return "" + year + monthString + dayString;
    }

    private static int getIntegerInput(String prompt) {
        int num = 0;
        Boolean sentinel = true;

        do {
            System.out.print(prompt);
            while(!input.hasNextInt()) {
                input.next(); // Throw away anything left in the buffer, taht isn't an int
            }

            num = input.nextInt();
            sentinel = false;
        } while(sentinel);

        input.nextLine(); // Trash anything left in buffer
        return num;
    }

    private static void inputPersonDetails(){
        
        System.out.print("What is your first name? ");
        String firstName = input.nextLine(); // TODO - add validation firstName must exist

        System.out.print("What is your last name? ");
        String lastName = input.nextLine(); // TODO - add validation lastName must exist

        String dob = getDOBInput("When were you born? ");

        LocalDate userDate = LocalDate.parse(dob, DateTimeFormatter.BASIC_ISO_DATE);
        Period yearsOld = Period.between(userDate, LocalDate.now());
        int userAge = yearsOld.getYears();
        
        // Optional fields
        System.out.print("Enter an image URL: (optional, enter to skip) ");
        String imageURL = input.nextLine();
        
        System.out.print("Enter a status update: (optional, enter to skip) ");
        String status = input.nextLine();

        if (userAge < 16) {
            int parent1;
            int parent2;
            Boolean hasvalidParents = false;
            do {
                printUsersWithFilter(people, "Adult");
                parent1 = getIntegerInput("Select a parent account ID: ");
                parent2 = getIntegerInput("Select a second parent account ID: ");

                if(parent1 == parent2) {
                    System.out.println("Can't have the same parents!");
                } else {

                    try {
                        Adult p1 = (Adult)people.get(Log.getByID(parent1));
                        Adult p2 = (Adult)people.get(Log.getByID(parent2));

                        p1.addPartner(parent2);
                        p2.addPartner(parent1); 
                        // Add dependents after user has been created

                        Person p = new Child(firstName, lastName, userDate, "password", new int[]{parent1, parent2}, imageURL, status );
                        Log.addProfile(p);

                        p1.addDependent(p.getID());
                        p2.addDependent(p.getID());

                        hasvalidParents = true;
                    } catch (Exception e) {
                        System.out.println("Invalid user selection! Users don't exist or aren't Adults");
                    }
                }

            } while (!hasvalidParents);
        } else {
            Person p = new Adult(firstName, lastName, userDate, "password", imageURL, status);
            Log.addProfile(p);
        }


        
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

    // Helper to convert int[] array to Array list
    private static void printUsersFromId(int[] peopleList, Boolean fullDetails) {
        ArrayList<Integer> people = new ArrayList<Integer>();

        for (int i = 0; i < peopleList.length; i++) {
            people.add(peopleList[i]);
        }

        printUsersFromId(people, true);
    }

    private static void printUsersFromId(ArrayList<Integer> peopleList, Boolean fullDetails) {
        System.out.format(
            "%4s%20s%4s\n",
            "User ID",
            "User Name",
            "Age"
        );

        // TODO - make this more robust for displaying large lists
        for (Integer personId: peopleList) {
            printUser(people.get(Log.getByID(personId)), fullDetails);
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

    private static void removeFriends(Person selectedPerson) {
        int selectedPersonId = selectedPerson.getID();
        ArrayList<Integer> friendsList = null;
        if (selectedPerson instanceof Adult) {
            Adult castPerson = (Adult)selectedPerson;
            friendsList = castPerson.getFriends();
        } else if (selectedPerson instanceof Child) {
            Child castPerson = (Child)selectedPerson;
            friendsList = castPerson.getFriends();
        } else {
            System.out.println("Can't remove friends from this user type");
            return;
        }

        for(Integer friendId: friendsList) {
            Person oldFriend = people.get(Log.getByID(friendId));

            if (oldFriend instanceof Adult) {
                Adult castPerson = (Adult)oldFriend;
                castPerson.removeFriend(selectedPersonId);
            } else if (oldFriend instanceof Child) {
                Child castPerson = (Child)oldFriend;
                castPerson.removeFriend(selectedPersonId);
            } else {
                System.out.println("Can't remove friends from this user type");
                Person castPerson = null;
            }

        }
    }
}

/*
! Update the profile information of the selected person
! Find out whether a person is a direct friend of another person
! Find out the name(s) of a person’s child(ren) or the names of the parents
*/