package structures;

import java.util.HashMap;


public class PeopleGraph {
	HashMap<String, Person> graph = new HashMap<String, Person>();
	
	public PeopleGraph() {
		
	}
	
	public Person get(String name) {
		return graph.get(name);
	}
	public void put(String name, Person person) {
		graph.put(name, person);
	}
}
