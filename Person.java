/**
* Person is the abstract class to create the attributes
* for the profiles of the different type of people using MiniNet.
*
* @author  Angus Staines
* @version 1.0
*/

import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Person{
	// variables
	private String userFirstName;
	private String userLastName;
	private String userImage;
	private String userStatus;
	private int userAge;	// !!! should this be a class variable, or simply a function variable when the age is asked for? !!!
	private LocalDate dob;
	public static int PROFILE_COUNT = 0;   // static variable to use as counter for unique USER_ID
	private final int USER_ID;
	private String userPassword;

	// constructor for mandatory fields
	public Person(String firstName, String lastName, LocalDate dob, String password){
		userFirstName = firstName;
		userLastName = lastName;
		this.dob = dob;
		userPassword = password;
		USER_ID = PROFILE_COUNT++;   // increment PROFILE_COUNT and assign to USER_ID (first USER_ID = 0)
	}

	// constructor overloaded for image
	public Person(String firstName, String lastName, LocalDate dob, String password, String image){
		this(firstName, lastName, dob, password);
		userImage = image;
	}

	// constructor for retrieving profile (USER_ID is given as an arg, rather than created by the constructor)
	public Person(int ID, String firstName, String lastName, LocalDate dob, String password, String image, String status){
		USER_ID = ID;
		userFirstName = firstName;
		userLastName = lastName;
		this.dob = dob;
		userPassword = password;
		userImage = image;
		userStatus = status;
	}


	// getters
	public String getFirstName(){
		return userFirstName;
	}

	public String getLastName(){
		return userLastName;
	}

	// Helper method
	public String getFullName() {
		return userFirstName + " " + userLastName;
	}

	public String getImage(){
		return userImage;
	} 

	public String getStatus(){
		return userStatus;
	}

	public String getDOB(){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String date = dob.format(dateFormatter);
		return date;
	}

	public int getAge(){
		updateAge();
		return userAge;
	}

	public int getID(){
		return USER_ID;
	}

	public String getPassword(){
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

	public void updateFirstName(String firstName){
		userFirstName = firstName;
	}

	public void updateLastName(String lastName){
	userLastName = lastName;
	}

	public void updateImage(String image){
		userImage = image;
	}

	public void updateStatus(String status){
		userStatus = status;
	}

	public void updateDOB(LocalDate dateOfBirth){
		dob = dateOfBirth;
	}

	public void updateAge(){
		Period yearsOld = Period.between(dob, LocalDate.now());
		userAge = yearsOld.getYears();
	}
	
	// receives args from Driver.inputPassword()
	public void updatePassword(String newPassword){
		userPassword = newPassword;
	}
}