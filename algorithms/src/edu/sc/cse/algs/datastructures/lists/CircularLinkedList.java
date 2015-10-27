package edu.sc.cse.algs.datastructures.lists;
/**
 * Implement Circular Linked List
 * @author meng (gmail: y(dot)meng201011)
 *@param <T> comparable object
 */
public class CircularLinkedList<T> {
	class Node<T> implements Comparable<T> {
		private T data;
		private Node<T> next;
		
		public void setData(T data) {
			this.data = data;
		}
		
		public void setNext(Node<T> node) {
			this.next = node;
		}
		
		public T getData() {
			return this.data;
		}
		
		public Node<T> getNext() {
			return this.next;
		}
		
		@Override
		public int compareTo(T value) {
			if (this.data == value) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	
	public CircularLinkedList() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * 
	 * @param value
	 * @return whether or not the list contains given value
	 */
	public boolean contains(T value) {
		Node<T> iterator = head;
		boolean found = false;
		
		while (iterator != tail && !found) {
			if (iterator.data == value) {
				found = true;
			}
			iterator = iterator.next;
		}
		return found;
	}
	
	/**
	 * Insert a new node with given  value before the head.
	 * @param value
	 */
	public void insert(T value) {
		Node<T> node = new Node<T>();
		node.setData(value);
		
		if (head == null) {
			// list was empty
			head = tail = node;
			tail.setNext(head);
			head.setNext(tail);
		} else {
			// list was not empty
			node.setNext(head);
			head = node;
			tail.setNext(head);
		}
	}
	
	/**
	 * To delete nodes that contain given value
	 * @param value
	 */
	public void delete(T value) {
		if (head == null) {
			// empty list
			System.err.println("\n>>> The list is underflowed!");
			return;
		} else if (!this.contains(value)) {
			// list does not contain the specific value
			System.err.println("\n>>> The list does not contain " + value);
			return;
		}  else {
			// delete a node from list
			Node<T> iterator = head;
			Node<T> prevNode = null;
			
			while (iterator != null && this.contains(value)) {
				if (iterator.data == value) {
					// found the node
					if (head == tail) {
						// delete the only one node
						head = tail = null;
						head.setNext(null);
						tail.setNext(null);
						return;
					}  else if (prevNode == null) {
						// delete the head
						head = head.next;
						tail.setNext(head);
					} else {
						// delete a node
						prevNode.setNext(iterator.next);
					}					
				} else {
					// not found yet
					prevNode = iterator;
				}
				// next node
				iterator = iterator.next;
				
				// print out the process
//				if (iterator != null) {
//					System.out.println( "head = " + this.head.data + "; tail = " + this.tail.data
//							 + "; \t"
//							+ iterator.data + ".next = "
//							+ (iterator.next != null ? iterator.next.data : "null"));
//				}
			}
		}
	}// end of delete
	
	/**
	 * 
	 * @return number of nodes in the list
	 */
	public int size() {
		int count = 0;
		Node<T> iterator = head;
		
		while (iterator != null && iterator != tail) {
			count++;
			iterator = iterator.next;
		}
		return count;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		Node<T> iterator = head;
		
		while (iterator != null && iterator != tail) {
			str += iterator.data + " -> ";
			iterator = iterator.next;
		}
		str += "(End)";
		return str;
	}
	
	/**
	 * Traverse the list from head to tail
	 */
	/*
	 * **** Replace traverse() with toString() ****
	*
	public void traverse() {
		Node<T> iterator = head;
		
		while (iterator != null && iterator != tail) {
			System.out.print(iterator.data + " -> ");
			iterator = iterator.next;
		}
		System.out.println("(End)");
	}
	*/
	
	// test
	public static void main(String[] args) {
		// list with integers
		CircularLinkedList<Integer> il = new CircularLinkedList<Integer> ();
		System.out.println("il is empty? " + il.isEmpty());
		il.insert(4);
		il.insert(3);
		il.insert(2);
		il.insert(1);
//		il.traverse();
		System.out.println(il.toString());
		System.out.println("il.size = " + il.size());
		System.out.println("il contains 3? " + il.contains(3));
		System.out.println("il contains 9? " + il.contains(9));
		il.delete(3);
		il.delete(1);
//		il.traverse();
		System.out.println(il.toString());
		
		// list with strings
		CircularLinkedList<String> sl = new CircularLinkedList<String> ();
		sl.insert("a");
		sl.insert("a");
		sl.insert("b");
		sl.insert("a");
		sl.insert("a");
		sl.insert("c");
		sl.insert("d");
//		sl.traverse();
		System.out.println(sl.toString());
		System.out.println("sl is empty()? " + sl.isEmpty());
		System.out.println("sl contains c? " + sl.contains("c"));
		System.out.println("sl contains x? " + sl.contains("x"));	
		sl.delete("c");
		sl.delete("f");
		sl.delete("a");
		System.out.println("sl.size = " + sl.size());
//		sl.traverse();
		System.out.println(sl.toString());
	}
}
