import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test{
	
	public static void main(String[] args){
		//Person test1 = new Person();
		//Person test2 = new Person();
		LocalDate date1 = LocalDate.parse("19501225", DateTimeFormatter.BASIC_ISO_DATE);
		Adult test3 = new Adult("Adam", "Smith", date1, "secret_word");

		//System.out.println(test1.getID());
		//System.out.println(test2.getID());
		System.out.println(test3.getID());

		System.out.println(test3.getFirstName());
		System.out.println(test3.getLastName());

		System.out.println("Age is " + test3.getAge());
		System.out.println("DOB is " + test3.getDOB());

		test3.addFriend(7);
		test3.addFriend(9);
		System.out.println(test3.getFriends());

		test3.removeFriend(7);
		System.out.println(test3.getFriends());

		test3.addDependent(11);
		System.out.println(test3.getDependents());


		

	}
}