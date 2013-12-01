package structures;

import java.util.ArrayList;
import java.util.HashMap;
import structures.AdjacencyLinkedList;


public class PeopleGraph {
	HashMap<String, Integer> nameToIndex = new HashMap<String, Integer>();
	ArrayList<Person> nodes;
	AdjacencyLinkedList adjLL; 

	
	public PeopleGraph(int initcap) {
		this.nodes = new ArrayList<Person>(initcap);
		this.adjLL = new AdjacencyLinkedList(initcap);
	}
	
	public Person get(int index) {
		return this.nodes.get(index);
	}
	
	public Person get(String name) {
		Integer index = this.nameToIndex.get(name);
		if (index == null) {
			return null;
		}
		else {
			return this.get(index);
		}
	}
	
	public void put(String name, Person person) {
		int index = nodes.size();
		this.nameToIndex.put(name, index); 
		this.nodes.add(person);
	}
	
	public PersonNode getNeighbor(String name) {
		return this.adjLL.get(this.nameToIndex.get(name));
	}
	
	public PersonNode getNeighbor(Person person) {
		return this.getNeighbor(person.getName());
	}
	
	public void addEdge(String name1, String name2) {
		Person p1 = this.get(name1);
		Person p2 = this.get(name2);
        int p1index = this.nameToIndex.get(name1);
        int p2index = this.nameToIndex.get(name2);

		this.adjLL.addEdge(p1index, p2);
		this.adjLL.addEdge(p2index, p1);
				
	}

	public void addEdge(Person p1, Person p2) {
		this.addEdge(p1.getName(), p2.getName());
	}
	
	private void printPerson(Person person) {
		if (!person.getSchool().equals("")) {
			System.out.println(person.getName() + "|" + "y" + "|" + person.getSchool());
		}
		else {
			System.out.println(person.getName() + "|" + "n");
		}
	}
	
	public void printGraph() {
		System.out.println(this.nodes.size());
		for (Person person: this.nodes) {
			printPerson(person);
		}
		ArrayList<String> lines = new ArrayList<String>();
		for (Person person: this.nodes) {
			PersonNode neighbor = getNeighbor(person);
			while (neighbor!=null) {
				if (!lines.contains(neighbor.person.getName() + "|" +person.getName())) {
					lines.add(person.getName() + "|" + neighbor.person.getName());
				}
				neighbor = neighbor.next;
			}
		}
		for (String line: lines) {
			System.out.println(line);
		}
	}
	

	
}
