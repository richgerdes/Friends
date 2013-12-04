package structures;

public class Person {
	
	String name;
	String school;
	
	public Person(String name, String school){
		
		this.name = name;
		this.school = school;
		
	}

	public String getName() {
		return this.name;
	}
	
	public String getSchool() {
		return this.school;
	}

	public String toString() {
		if (!school.equals("")) {
			return name + "|" + "y" + "|" + school;
		}
		else {
			return name + "|" + "n";
		}
	}
}
