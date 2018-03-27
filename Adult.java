import java.util.*;
import java.time.LocalDate;

public class Adult extends Person implements Friendable{

	// variables
	private ArrayList<Integer> friends = new ArrayList<Integer>();
	private ArrayList<Integer> dependents = new ArrayList<Integer>();
	private int partner; // !!! how to make this optional? Or doesn't matter if not used in every instance? !!!


	// constructor for mandatory fields
	Adult(String firstName, String lastName, LocalDate dob, String password){
		super(firstName, lastName, dob, password);
	}

	// overlaoded constructor to include image
	Adult(String firstName, String lastName, LocalDate dob, String password, String image){
		super(firstName, lastName, dob, password, image);
	}

	// constructor for retrieving profile (USER_ID is given as an arg, rather than created by the constructor)
	Adult(int ID, String firstName, String lastName, LocalDate dob, String password, String image, 
		  String status, ArrayList<Integer> friends, ArrayList<Integer> dependents, int partner){
		super(ID, firstName,  lastName, dob, password, image, status);
		this.friends = friends;
		this.dependents = dependents;
		this.partner = partner;		
	}

	// getter
	public ArrayList getDependents(){
	return dependents;
	}

	public int getPartner(){
		return partner;
	}

	// override interface getters
	public ArrayList getFriends(){
		return friends;
	}

	// settters
	public void addDependent(int dependentID){	// !!! should check if already in the list before adding
		dependents.add(dependentID);
	}

	public void addPartner(int partnerID){	
	partner = partnerID;
	}

	// override interface setters
	public void addFriend(int friendID){	// !!! should check if already in the list before adding
		friends.add(friendID);
	}

	public void removeFriend(int friendID){
		friends.remove(Integer.valueOf(friendID));
	}

	public boolean isFriend(int  friendID){
		boolean boolFriend;
		if (friends.contains(friendID)){
			boolFriend = true;
		}
		else {
			boolFriend = false;
		}
		return boolFriend;
	}

}