package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList; //queue

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
	
	public void put(Person person) {
		int index = nodes.size();
		this.nameToIndex.put(person.getName(), index); 
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
	
	// for convenience
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
				String forwards = person.getName() + "|" + neighbor.person.getName();
				String backwards = neighbor.person.getName() + "|" +person.getName();
				if ((!lines.contains(backwards)) && (!lines.contains(forwards))) {
					lines.add(forwards);
				}
				neighbor = neighbor.next;
			}
		}
		for (String line: lines) {
			System.out.println(line);
		}
	}
	
	public PeopleGraph getSchoolSubgraph(String school) {
		PeopleGraph subgraph = new PeopleGraph(this.nodes.size());
		
		// it would probably be easier for this to be split into multiple functions
		for (Person p: this.nodes) {
			Queue<Person> q = new LinkedList<Person>();
			if ((subgraph.get(p.getName()) == null) && (p.getSchool().equals(school))) {
				q.add(p);
				subgraph.put(p);
				while (!q.isEmpty()) {					
					Person person = q.remove();
					PersonNode neighbor = this.getNeighbor(person);
					while (neighbor != null) {
						if (neighbor.person.getSchool().equals(school)) {
							if (subgraph.get(neighbor.person.getName()) == null) {
								q.add(neighbor.person);
								subgraph.put(neighbor.person);
							}
							subgraph.addEdge(person, neighbor.person);
						}
						neighbor = neighbor.next;
					}
				}
			}
		}
		
		return subgraph;
	}
	
}
