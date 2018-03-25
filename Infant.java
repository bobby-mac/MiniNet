

public class Infant extends Person implements Dependent{
	// variables
	private int[] parents = new int[2];

	// constructor
	Infant(String firstName, String lastName, String dob, String password, int[] parents){
		super(firstName, lastName, dob, password);
		this.parents = parents;
	}

	// override Dependent getter
	public int[] getParents(){
		return parents;
	}

}