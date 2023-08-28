/*
 * LinkedList that can be used to store a series of Board Nodes
 */
public class LinkedList {
	
	protected Node head;
	protected int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public void addNode(Node n) {
		n.setNext(head);
		head = n;
		size++;
	}
	
	public Node getNode() {
		return head;
	}
	
	public int getSize() {
		return size;
	}
	
	public Node removeNode() {
		Node removedNode = head;
		head = head.next();
		this.size--;
		return removedNode;
	}
	
}

