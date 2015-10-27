package edu.sc.cse.algs.datastructures.lists;

/**
 * 
 * @author meng (gmail: y(dot)meng201011)
 *  Implement of Singly Lined List
 */
public class SinglyLinkedList<T> {
	// node object
	class Node<T> implements Comparable<T> {
		private T data;
		private Node<T> next;
		
		// assessors
		public T getData() {
			return data;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		// mutators
		public void setData(T data) {
			this.data = data;
		}
		
		public void setNext(Node<T> node) {
			this.next = node;
		}
		
		@Override
		public int compareTo(T value) {
			if (value == this.data) {
				return 0;
			} else {
				return 1;
			}
		}
		
	} // end of Node definition
	
	private Node<T> head;
	private Node<T> tail;
	
	// default Constructor
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public int size() {
		int count = 0;
		Node<T> iterator = head;
		
		while (iterator != null) {
			count++;
			iterator = iterator.next;
		}
		
		return count;
	}
	
	public Node<T> getHead() {
		return this.head;
	}
	
	public Node<T> getTail() {
		return this.tail;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void insert(T value) {
		Node<T> node = new Node<T> ();
		node.setData(value);;
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.setNext(head); 
			head = node;
		}
	}
	
	public void delete(T value) {
		
		if (head == null) {
			System.out.println(">>> The list is underflow!");
			return;
		}
		
		Node<T> iterator = head;
		Node<T> prev = null;
		
		while (iterator != null) {
			if (iterator.data == value) {
				if (prev == null) {
					// delete head
					head = iterator.next;
				} else {
					// delete node not at head
					prev.next = iterator.next;
				}
			} else {
				prev = iterator;
			}
			// next node
			iterator = iterator.next;
		}
	}
	
	public boolean contains(T value) {
		boolean found = false;
		Node<T> iterator = head;
		
		while (!found && iterator != null) {
			if (iterator.data == value) {
				found = true;
			}
			iterator = iterator.next;
		}
		
		return found;
	}
	
	@Override
	public String toString() {
		String str = "";
		Node<T> iterator = head;
		while (iterator != null) {
			str += iterator.data + " -> ";
			iterator = iterator.next;
		}
		str += "(End)";
		return str;
	}
	
	/* 
	 * **** Replaced traverse() with toString(). ****
	 * 
	public void traverse() {
		Node<T> iterator = head;
		while (iterator != null) {
			System.out.print(iterator.data + " -> ");
			iterator = iterator.next;
		}
		System.out.println("(End)");
	}
	*/
	
	// test
	public static void main(String[] args) {
		// list with integers
		SinglyLinkedList<Integer> il = new SinglyLinkedList<Integer> ();
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
		SinglyLinkedList<String> sl = new SinglyLinkedList<String> ();
		sl.insert("a");
		sl.insert("a");
		sl.insert("b");
		sl.insert("a");
		sl.insert("c");
		sl.insert("d");
//		sl.traverse();
		System.out.println(sl.toString());
		System.out.println("sl is empty()? " + sl.isEmpty());
		System.out.println("sl contains c? " + sl.contains("c"));
		System.out.println("sl contains x? " + sl.contains("x"));	
		sl.delete("c");
		sl.delete("a");
		System.out.println("sl.size = " + sl.size());
//		sl.traverse();
		System.out.println(sl.toString());
	}
}
