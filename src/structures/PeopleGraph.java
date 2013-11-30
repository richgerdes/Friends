package structures;

import java.util.ArrayList;
import java.util.HashMap;


public class PeopleGraph {
	ArrayList<Person> nodes = new ArrayList<Person>();
	ArrayList<PersonNode> adjLL = new ArrayList<PersonNode>(); 
	HashMap<String, Integer> nameToIndex = new HashMap<String, Integer>();
	
	public PeopleGraph() {
		
	}
	
	public Person get(int index) {
		return this.nodes.get(index);
	}
	
	public Person get(String name) {
		return this.get(nameToIndex.get(name));
	}
	
	public void put(String name, Person person) {
		int index = nodes.size();
		person.index = index;
		this.nameToIndex.put(name, index); // really we don't need an arraylist since we never add nodes after creating the graph but whatever
		this.nodes.add(person);
		this.adjLL.add(null);
	}
	
	public PersonNode getNeighbor(String name) {
		return this.adjLL.get(this.nameToIndex.get(name));
	}
	
	public PersonNode getNeighbor(Person person) {
		return this.adjLL.get(person.index);
	}
	
	public void addEdge(String name1, String name2) {
		Person p1 = this.get(name1);
		Person p2 = this.get(name2);
		int p1index = this.nameToIndex.get(name1);
		int p2index = this.nameToIndex.get(name2);
		
		if (this.getNeighbor(name1) == null) {
			this.adjLL.set(p1index, new PersonNode(p2, null));
		}
		else {
			this.adjLL.get(p1index).next = new PersonNode(p2, null);
		}
		if (this.getNeighbor(name2) == null) {
			this.adjLL.set(p2index, new PersonNode(p1, null));
		}
		else {
			this.adjLL.get(p2index).next = new PersonNode(p1, null);
		}
		
	}
}
