import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Log{

	// array to hold all profiles
	public static ArrayList<Person> profiles = new ArrayList<Person>();

	// append to array of profiles
	public static void addProfile(Person personID){
		profiles.add(personID);
	}

	public static ArrayList<Person> getPeople() {
		return profiles;
	}

	// retrieve a profile by name
	// public static Person


	// retrieve a profile by ID








	public static String adultProfileString(Adult p){

		// get the type of object
		String profileType = p.getClass().getSimpleName();
		
		// cast int to String where requruired
		String profileID = Integer.toString(p.getID());
		String partnerID = Integer.toString(p.getPartner());
		String friendIDs = Arrays.toString(p.getFriends().toArray());
		String dependentIDs = Arrays.toString(p.getDependents().toArray());

		// join all attributes into single line
		String profileString = String.join(" | ", profileType, profileID, p.getFirstName(), 
										   p.getDOB(), p.getImage(), p.getStatus(), p.getPassword(),
										   friendIDs, dependentIDs, partnerID);
		return profileString;
	}

	public static String childProfileString(Child p){

		// get the type of object
		String profileType = p.getClass().getSimpleName();
		
		// cast int to String where requruired
		String profileID = Integer.toString(p.getID());
		String friendIDs = Arrays.toString(p.getFriends().toArray());
		String parentIDs = Arrays.toString(p.getParents());

		// join all attributes into single line
		String profileString = String.join(" | ", profileType, profileID, p.getFirstName(), 
										   p.getDOB(), p.getImage(), p.getStatus(), p.getPassword(),
										   friendIDs, parentIDs);
		return profileString;
	}

	public static String infantProfileString(Child p){

		// get the type of object
		String profileType = p.getClass().getSimpleName();
		
		// cast int to String where requruired
		String profileID = Integer.toString(p.getID());
		String parentIDs = Arrays.toString(p.getParents());

		// join all attributes into single line
		String profileString = String.join(" | ", profileType, profileID, p.getFirstName(), 
										   p.getDOB(), p.getImage(), p.getStatus(), p.getPassword(),
										   parentIDs);
		return profileString;
	}

}