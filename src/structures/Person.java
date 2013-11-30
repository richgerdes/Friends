package structures;

import java.util.ArrayList;

public class Person {
	
	String name;
	String school;
	public int index;
	
	ArrayList<Person> friends = new ArrayList<Person>();
	
	public Person(String name, String school){
		
		this.name = name;
		this.school = school;
		
	}
	
	public void addFriend(Person friend){
		friends.add(friend);
	}

	public String getName() {
		return this.name;
	}
	
	public String getSchool() {
		return this.school;
	}
	
}
