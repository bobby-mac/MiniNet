import java.util.*;

public class Adult extends Person implements Friendable{

	// variables
	private ArrayList<Integer> friends = new ArrayList<Integer>();
	private ArrayList<Integer> dependents = new ArrayList<Integer>();
	private int partner; // !!! how to make this optional? Or doesn't matter if not used in every instance? !!!


	// constructor
	Adult(String firstName, String lastName, String dob, String password){
		super(firstName, lastName, dob, password);
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

}