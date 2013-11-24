import java.util.ArrayList;

public class Person {
	
	String name;
	String school;
	
	ArrayList<String> friends = new ArrayList<String>();
	
	public Person(String name, String school){
		
		this.name = name;
		this.school = school;
		
	}
	
	public void addFriend(String friend){
		friends.add(friend);
	}

}
