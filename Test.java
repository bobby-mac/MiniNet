
public class Test{
	
	public static void main(String[] args){
		//Person test1 = new Person();
		//Person test2 = new Person();
		Adult test3 = new Adult("Adam", "Smith", "25/12/1950", "secret_word");

		//System.out.println(test1.getID());
		//System.out.println(test2.getID());
		System.out.println(test3.getID());

		System.out.println(test3.getFirstName());
		System.out.println(test3.getLastName());

		test3.addFriend(7);
		test3.addFriend(9);
		System.out.println(test3.getFriends());

		test3.removeFriend(7);
		System.out.println(test3.getFriends());

		test3.addDependent(11);
		System.out.println(test3.getDependents());


		

	}
}