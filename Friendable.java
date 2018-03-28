/**
* Friendable is an interface with getters and setters for a list of freinds.
*
* @author  Angus Staines
* @version 1.0
*/

import java.util.*;

public interface Friendable{

// getters
	public ArrayList getFriends();
	public boolean isFriend(int  friendID);

// setters
	public void addFriend(int friendID);
	public void removeFriend(int friendID);

}