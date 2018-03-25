import java.util.*;

public abstract class Person{
	// variables
	private String userFirstName;
	private String userLastName;
	// private ??? userImage;
	private String userStatus;
	private int userAge;	// !!! should this be a class variable, or simply a function variable when the age is asked for? !!!
	private String dob;
	public static int PROFILE_COUNT = 0;   // static variable to use as counter for unique USER_ID
	private final int USER_ID;
	private String userPassword;

	// constructor !!! need to update to include args (see class diagram)
	Person(String firstName, String lastName, String dob, String password){   // !!! encapsulation for abstract constructor !!!
		userFirstName = firstName;
		userLastName = lastName;
		this.dob = dob;
		userPassword = password;
		USER_ID = ++PROFILE_COUNT;   // increment PROFILE_COUNT and assign to USER_ID (first USER_ID = 1)
	}

	// getters
	public String getFirstName(){
		return userFirstName;
	}

	public String getLastName(){
		return userLastName;
	}

	// public ??? getImage(){
	//	return userImage;
	// } 

	public String getStatus(){
		return userStatus;
	}

	public int getAge(){
		// !!! need to calculate age. Take dob as arg (update class diagram accordingly)
		return userAge;
	}

	public int getID(){
		return USER_ID;
	}

	private String getPassword(){
		return userPassword;
	}


	public boolean checkPassword(String givenPassword){
		// if the password doesn't match, ask to enter again or return 'false'.
		// !!! the input print and input section of this needs to be moved to Driver (or a new View class) !!!
		if (!(givenPassword.equals(getPassword()))){
			System.out.println("Incorrect password.");
			System.out.println("Please re-enter password or press enter to go back to the main menu");

			Scanner in = new Scanner(System.in);
			String secondAttempt = in.nextLine();

			if (secondAttempt.equals("")){
				return false;				
			} else checkPassword(secondAttempt);
		}
		return true;
	}

	// setters

	// receives args from Driver.inputName()
	public void updateName(String firstName, String lastName){
		userFirstName = firstName;
		userLastName = lastName;
	}

	// !!! public void updateImage !!! ?????

	// receives args from Driver.inputStatus()
	public void updateStatus(String status){
		userStatus = status;
	}

	// receives args from Driver.inputDOB()
	public void updateDOB(String dateOfBirth){
		dob = dateOfBirth;
	}	
	
	// receives args from Driver.inputPassword()
	public void updatePassword(String newPassword){
		userPassword = newPassword;
	}
}