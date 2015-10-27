package edu.sc.cse.algs.datastructures.lists;

/**
 * Implement doubly linked list.
 * @author meng (gmail: y(dot)meng201011)
 *
 * @param <T> comparable object
 */
public class DoublyLinkedList<T>  {
	/*
	 * node object in the list
	 */
	class Node<T> implements Comparable<T> {
		private Node<T> next;
		private Node<T> prev;
		private T data;
		
		public void setData(T data) {
			this.data = data;
		}
		
		public void setNext(Node<T> node) {
			this.next = node;
		}
		
		public void setPrev(Node<T> node) {
			this.prev = node;
		}
		
		public T getData() {
			return this.data;
		}
		
		public Node<T> getNext() {
			return this.next;
		}
		
		public Node<T> getPrev() {
			return this.prev;
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
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	/**
	 * 
	 * @return whether the list is empty
	 */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * 
	 * @return number of nodes in the list
	 */
	public int size() {
		int count = 0;
		Node<T> iterator = head;
		
		while (iterator != null) {
			count++;
			iterator = iterator.next;
		}
		return count;
	}
	
	/**
	 * Check whether given value is in list
	 * @param value
	 * @return true / false for given value is in list or not
	 */
	public boolean contains(T value) {
		Node<T> iterator = head;
		boolean found = false;
		
		while (iterator != null) {
			if (iterator.data == value) {
				found = true;
				break;
			} else {
				iterator = iterator.next;
			}
		}
		return found;
	}
	
	/**
	 * Insert a node to the head of list given the value.
	 * @param value
	 */
	public void insert(T value) {
		Node<T> node = new Node<T> ();
		node.setData(value);
		
		if (head == null) {
			head = tail = node;
			head.setNext(tail);
			head.setPrev(null);
			tail.setPrev(head);
			tail.setNext(null);
		} else {
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}
	
	/**
	 * Delete nodes have specific value.
	 * @param value
	 */
	public void delete(T value) {
		if (head == null) {
			// empty list
			System.err.println("\n>>> List is underflowed!");
			return;
		} else if (!this.contains(value))  {
			// value to delete is not in the list
			System.err.println("\n>>> The list does not contain " + value);
			return;
		} else {
			// iterator
			Node<T> iterator = head;
			
			// iterate though the list
			while (iterator != null) {
				// found the node
				if (iterator.data == value) {
					if (head == tail) {
						// delete the last node from list
						head = tail = null;
						return;
					} 
					//  list contains multiple elements
					if (iterator == head) {
						// delete head
						head = iterator.next;
						head.setPrev(null);
					} else if (iterator == tail) {
						// delete tail
						tail = iterator.prev;
						tail.setNext(null);
					} else {
						// delete a node from middle
						iterator.prev.setNext(iterator.next);
						iterator.next.setPrev(iterator.prev);
					}
				} // end of deleting
				// next node
				iterator = iterator.next;
				
				// print out the process
				if (iterator != null) {
					System.out.println(iterator.data + ".prev = " 
							+ (iterator.prev != null ? iterator.prev.data : "null")
							 + "; \t"
							+ iterator.data + ".next = "
							+ (iterator.next != null ? iterator.next.data : "null"));
				}
			}		
		}
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
	
	/**
	 * Traverse list from head to tail
	 */
	/*
	 * **** Replace traverse() with toString() ****
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
		DoublyLinkedList<Integer> il = new DoublyLinkedList<Integer> ();
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
		DoublyLinkedList<String> sl = new DoublyLinkedList<String> ();
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
		sl.delete("f");
		sl.delete("a");
		sl.delete("b");
		sl.delete("d");
		sl.delete("e");
		System.out.println("sl.size = " + sl.size());
//		sl.traverse();
		System.out.println(sl.toString());
	}
}
