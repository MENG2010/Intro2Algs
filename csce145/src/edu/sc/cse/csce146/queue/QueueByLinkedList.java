package edu.sc.cse.csce146.queue;

/**
 * Created by meng on 12/22/16.
 */
public class QueueByLinkedList<T extends Comparable<T>> {
    Node head;
    Node tail;

    public QueueByLinkedList() {
        this.head = null;
        this.tail = this.head;
    }

    public QueueByLinkedList(T data) {
        Node node = new Node(data);
        this.head = node;
        this.tail = this.head;
    }

    public void enqueue(T data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    public T dequeue() {
        if (this.head == null) {
            System.out.println("Cannot dequeue an empty queue");
            return null;
        } else {
            T tmp = (T) this.head.data;
            this.head = this.head.next;
            return tmp;
        }
    }

    public T peek() {
        if (this.head == null) {
            System.out.println("This queue is empty");
            return null;
        } else {
            T tmp = (T) this.head.data;
            return tmp;
        }
    }

    public void print() {
        if (this.head == null) {
            System.out.println("EMPTY QUEUE");
        } else {
            Node iterator = this.head;
            while (iterator.next != null) {
                System.out.print((T) iterator.data + " -> ");
                iterator = iterator.next;
            }
            System.out.println(iterator.data);
        }
    }

    private class Node<T extends Comparable<T>> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(this.data.toString()).append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        QueueByLinkedList<String> strQ = new QueueByLinkedList<>();

        strQ.enqueue("head");
        strQ.print();
        strQ.enqueue("aaaa");
        strQ.print();
        strQ.enqueue("www");
        strQ.print();
        System.out.println("peek: " + strQ.peek());
        strQ.print();
        strQ.dequeue();
        strQ.print();
        strQ.dequeue();
        strQ.print();
        strQ.dequeue();
        strQ.print();
        strQ.dequeue();
        strQ.print();

        QueueByLinkedList<Integer> intQ = new QueueByLinkedList<>();

        intQ.enqueue(3);
        intQ.print();
        intQ.enqueue(7);
        intQ.print();
        intQ.enqueue(6);
        intQ.print();
        System.out.println("peek: " + intQ.peek());
        intQ.print();
        intQ.dequeue();
        intQ.print();
        intQ.dequeue();
        intQ.print();
        intQ.dequeue();
        intQ.print();
        intQ.dequeue();
        intQ.print();
    }
}
