/**
* Adult is a concrete class that extends Person and implements Friendable.
* Contains attributes and methods for friends, dependents (children) and a partner.
*
* @author  Angus Staines
* @version 1.0
*/

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

	// overlaoded constructor to include status
	Adult(String firstName, String lastName, LocalDate dob, String password, String image, String status){
		super(firstName, lastName, dob, password, image, status);
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

	// returns True if a given ID is in the list of friends. Otherwise returns False.
	public boolean isFriend(int friendID){
		boolean boolFriend;
		if (friends.contains(friendID)){
			boolFriend = true;
		}
		else {
			boolFriend = false;
		}
		return boolFriend;
	}

	// settters
	public void addDependent(int dependentID){	// TODO: should check if already in the list before adding (similar to addFriend)
		dependents.add(dependentID);
	}

	public void addPartner(int partnerID){	
	partner = partnerID;
	}

	// override interface setters
	public void addFriend(int friendID){	// TODO: print to console could be handled in Driver by throwing an exception
		if (isFriend(friendID)){
			System.out.println("This person is already your friend.");
		}
		else friends.add(friendID);
	}

	public void removeFriend(int friendID){	// TODO: print to console could be handled in Driver by throwing an exception
		if (!isFriend(friendID)){
			System.out.println("This person is not an existing friend.");
		}
		else friends.remove(Integer.valueOf(friendID));
	}



}