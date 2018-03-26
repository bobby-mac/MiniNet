import java.time.LocalDate;

public class Infant extends Person implements Dependent{
	// variables
	private int[] parents = new int[2];

	// constructor for mandatory fields
	Infant(String firstName, String lastName, LocalDate dob, String password, int[] parents){
		super(firstName, lastName, dob, password);
		this.parents = parents;
	}

	// overlaoding constructor to include image
	Infant(String firstName, String lastName, LocalDate dob, String password, int[] parents, String image){
		super(firstName, lastName, dob, password, image);
		this.parents = parents;
	}
	// override Dependent getter
	public int[] getParents(){
		return parents;
	}

}