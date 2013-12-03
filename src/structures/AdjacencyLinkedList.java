package structures;

import java.util.ArrayList;

public class AdjacencyLinkedList {

	ArrayList<PersonNode> adjLL; 
	
	public AdjacencyLinkedList (int initcap) {
		adjLL = new ArrayList<PersonNode>(initcap);
		for (int i = 0; i <= initcap; i++) {
			adjLL.add(null); // populate linkedlist
		}
	}
	
	// get first neighbor node
	public PersonNode get(int index) {
		return this.adjLL.get(index);
	}
	
	// get last neighbor node in list
	private PersonNode getLast(int index) {
		PersonNode n = this.get(index);
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

	private boolean isEdge(int index1, Person person) {
		PersonNode n = this.get(index1);
		if (n == null) {
			return false;
		}
		else {
			if (n.person == person) {
				return true;
			}
			while (n.next != null) {
				n = n.next;
			}
			return false;
		}
	}
	
	public void addEdge(int index1, Person p2) {
		if (isEdge(index1, p2)) {
			// since isedge is essentially the same thing as getlast
			// the running time is the same, and O(f(n)+f(n)) = O(f(n)), so the efficiency is essentially unchanged
			return; 					
		}
		else {
			PersonNode last = this.getLast(index1);
			if (last == null) {
				this.adjLL.set(index1, new PersonNode(p2, null));
			}
			else {
				this.getLast(index1).next = new PersonNode(p2, null);
			}
		}
	}
}
