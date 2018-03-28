/**
* Infant is a concrete class that extends Person and implements Dependent.
* Contains attributes and methods for parents.
*
* @author  Angus Staines
* @version 1.0
*/

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

	// constructor for retrieving profile (USER_ID is given as an arg, rather than created by the constructor)
	public Infant(int ID, String firstName, String lastName, LocalDate dob, String password, String image, String status, 
				 int[] parents){
		super(ID, firstName, lastName, dob, password, image, status);
		this.parents = parents;
	}
	// override Dependent getter. Returns an array of parent's IDs.
	public int[] getParents(){
		return parents;
	}

}