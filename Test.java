import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test{
	
	public static void main(String[] args){
		
		// test adult 1
		LocalDate date1 = LocalDate.parse("19720818", DateTimeFormatter.BASIC_ISO_DATE);
		Adult test1 = new Adult("Jack", "Stalk", date1, "bad_password");
		
		// test adult 2
		LocalDate date2 = LocalDate.parse("19550413", DateTimeFormatter.BASIC_ISO_DATE);
		Adult test2 = new Adult("Mary", "Scotts", date2, "secret_word");

		// test adult 3
		LocalDate date3 = LocalDate.parse("19501225", DateTimeFormatter.BASIC_ISO_DATE);
		Adult test3 = new Adult("Adam", "Smith", date3, "secret_word");

		
		test3.addFriend(test1.getID());
		test3.addFriend(test2.getID());

		Log.addProfile(test1);
		Log.addProfile(test2);
		Log.addProfile(test3);

		int j = Log.profiles.size();
		System.out.println("Number of profiles: " + j);

		System.out.println(Log.profiles.get(1).getFirstName());

		System.out.println("Mary's index is:");
		
		// testing the Log getters
		// get by name
		try{
			int i = Log.getByName("Mary Scotts");
			System.out.println(i);
			Log.profiles.get(i).updateLastName("Smith");
			System.out.println(Log.profiles.get(i).getLastName());
		}

		catch(NullPointerException e){
			System.out.println("Person not in system!");
		}

		// get by id
		try{
			int i = Log.getByID(1);
			System.out.println(i);
			System.out.println(Log.profiles.get(i).getLastName());
		}

		catch(NullPointerException e){
			System.out.println("Person not in system!");
		}


		// test Log class
		//System.out.println(Log.adultProfileString(test3));


		

	}
}