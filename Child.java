/**
* Child is a concrete class that extends Person and implements Friendable and Dependent.
* Contains attributes and methods for friends and parents.
*
* @author  Angus Staines
* @version 1.0
*/

import java.util.*;
import java.time.LocalDate;

public class Child extends Person implements Friendable, Dependent{
	// variables
	private int[] parents = new int[2];
	private ArrayList<Integer> friends = new ArrayList<Integer>();

	// constructor for mandatory fields
	Child(String firstName, String lastName, LocalDate dob, String password, int[] parents){
		super(firstName, lastName, dob, password);
		this.parents = parents;
	}

	// overloading constructor to include image
	Child(String firstName, String lastName, LocalDate dob, String password, int[] parents, String image){
		super(firstName, lastName, dob, password, image);
		this.parents = parents;
	}

	// overlaoded constructor to include status
	Child(String firstName, String lastName, LocalDate dob, String password, int[] parents, String image, String status){
		super(firstName, lastName, dob, password, image, status);
		this.parents = parents;
	}

	// constructor for retrieving profile (USER_ID is given as an arg, rather than created by the constructor)
	public Child(int ID, String firstName, String lastName, LocalDate dob, String password, String image, String status, 
				 int[] parents, ArrayList<Integer> friends){
		super(ID, firstName, lastName, dob, password, image, status);
		this.parents = parents;
		this.friends = friends;
	}

	// override Frienable getter
	public ArrayList getFriends(){
		return friends;
	}

	// override Dependent getter. Returns an array of parent's IDs.
	public int[] getParents(){
		return parents;
	}

	// returns True if a given ID is in the list of friends. Otherwise returns False.
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

	// setters
	// override Friendable setters
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