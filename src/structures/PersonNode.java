package structures;

public class PersonNode {

	public Person person;
	public PersonNode next;
	
	public PersonNode(Person person, PersonNode next) {
		this.person = person;
		this.next = next;
	}
}
