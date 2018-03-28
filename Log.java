/**
* Log is used to store and retrieve profiles via an ArrayList.
*
* @author  Angus Staines
* @version 1.0
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Log{

	// array to hold all profiles
	public static ArrayList<Person> profiles = new ArrayList<Person>();

	// getters
	public static ArrayList<Person> getPeople() {
		return profiles;
	}

	// retrieve a profile's index by name
	public static Integer getByName(String firstAndLastName) throws NullPointerException{
		
		Integer intIndex = null;
		String fullName;
	
		for(int i=0; i < profiles.size(); i++){
			
			// full name = first name + last name
			fullName = profiles.get(i).getFirstName() + " "
					   + profiles.get(i).getLastName();
			
			// check if name is a match
			if(fullName.equals(firstAndLastName)){
				intIndex = i;
				break;
			}
		}
		return intIndex;
	}

	// retrieve a profile's index by ID
	public static Integer getByID(int ID) throws NullPointerException{
		
		Integer intIndex = null;
	
		for(int i=0; i < profiles.size(); i++){
			
			int profileID = profiles.get(i).getID();
			
			// check if ID is a match
			if(ID == profileID){
				intIndex = i;
				break;
			}
		}
		return intIndex;
	}

	// setters
	// append to array of profiles
	public static void addProfile(Person personID){
		profiles.add(personID);
	}

}