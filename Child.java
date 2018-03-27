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

	// override Frienable getter
	public ArrayList getFriends(){
		return friends;
	}

	// override Dependent getter
	public int[] getParents(){
		return parents;
	}

	// override Friendable setters
	public void addFriend(int friendID){	// !!! should check if already in the list before adding
		friends.add(friendID);
	}

	public void removeFriend(int friendID){
		friends.remove(Integer.valueOf(friendID));
	}

}