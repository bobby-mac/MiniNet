import java.util.*;

public class Child extends Person implements Friendable, Dependent{
	// variables
	private int[] parents = new int[2];
	private ArrayList<Integer> friends = new ArrayList<Integer>();

	// constructor
	Child(String firstName, String lastName, String dob, String password, int[] parents){
		super(firstName, lastName, dob, password);
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