package structures;

import java.util.HashMap;

public class AdjacencyLinkedList {

	HashMap<Person, PersonNode> adjLL; 
	
	public AdjacencyLinkedList () {
		adjLL = new HashMap<Person, PersonNode>();
	}
	
	// get first neighbor node
	public PersonNode get(Person person) {
		return this.adjLL.get(person);
	}
	
	// get last neighbor node in list
	private PersonNode getLast(Person person) {
		PersonNode n = this.get(person);
		if (n == null) {
			return null;
		}
		else {
			while (n.next != null) {
				n = n.next;
			}
			return n;
		}
	}

	private boolean isEdge(Person p1, Person p2) {
		PersonNode n = this.get(p1);
		if (n == null) {
			return false;
		}
		else {
			if (n.person == p2) {
				return true;
			}
			while (n.next != null) {
				n = n.next;
			}
			return false;
		}
	}
	
	public void addEdge(Person p1, Person p2) {
		if (isEdge(p1, p2)) {
			// since is edge is essentially the same thing as getlast
			// the running time is the same, and O(f(n)+f(n)) = O(f(n)), so the efficiency is essentially unchanged
			return; 					
		}
		else {
			PersonNode last = this.getLast(p1);
			if (last == null) {
				this.adjLL.put(p1, new PersonNode(p2, null));
			}
			else {
				this.getLast(p1).next = new PersonNode(p2, null);
			}
		}
	}
}
