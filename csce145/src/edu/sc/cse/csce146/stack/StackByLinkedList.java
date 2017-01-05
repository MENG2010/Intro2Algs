package edu.sc.cse.csce146.stack;

/**
 * Created by meng on 12/22/16.
 */
public class StackByLinkedList<T extends Comparable<T>> {
    private Node top;
    private Node bottom;

    public StackByLinkedList() {
        this.bottom = null;
        this.top = this.bottom;
    }

    public void push(T data) {
        Node node = new Node(data);

        if (this.bottom == null) {
            this.bottom = node;
            this.top = this.bottom;
        } else {
            this.top.next = node;
            this.top = this.top.next;
        }
    }

    public T pop() {
        if (this.top == null) {
            System.out.println("Cannot pop from an empty stack");
            return null;
        } else {
            T data = (T) this.top.data;

            Node iterator = this.bottom;
            if (iterator.next == null) {
                this.bottom = null;
                this.top = this.bottom;
            } else {
                while (iterator.next.next != null) {
                    iterator = iterator.next;
                }

                this.top = iterator;
                this.top.next = null;
            }
            return data;
        }
    }

    public T peek() {
        if (this.top == null) {
            System.out.println("This stack is empty");
            return null;
        } else {
            return (T) this.top.data;
        }
    }

    public void print() {
        Node iterator = this.bottom;
        System.out.print("BOTTOM | ");
        while (iterator != null) {
            System.out.print(iterator.data.toString() + " | ");
            iterator = iterator.next;
        }
        System.out.println("TOP");
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
            return this.data.toString();
        }
    }

    public static void main(String[] args) {
        StackByLinkedList<String> strStack = new StackByLinkedList<>();

        strStack.print();
        strStack.push("A");
        strStack.print();
        strStack.push("R");
        strStack.print();
        strStack.push("hello");
        strStack.print();
        strStack.push("world");
        strStack.print();
        System.out.println("peek: " + strStack.peek());
        strStack.print();
        System.out.println("pop: " + strStack.pop());
        strStack.print();
        System.out.println("pop: " + strStack.pop());
        strStack.print();
        System.out.println("pop: " + strStack.pop());
        strStack.print();
        System.out.println("pop: " + strStack.pop());
        strStack.print();
        System.out.println("pop: " + strStack.pop());
        strStack.print();

        System.out.println();
        StackByLinkedList<Double> dbStack = new StackByLinkedList<>();

        dbStack.push(5.32);
        dbStack.print();
        dbStack.push(39.0);
        dbStack.print();
        dbStack.push(52.4);
        dbStack.print();
        System.out.println("peek: " + dbStack.peek());
        dbStack.print();
        System.out.println("pop: " + dbStack.pop());
        dbStack.print();
        System.out.println("pop: " + dbStack.pop());
        dbStack.print();
        System.out.println("pop: " + dbStack.pop());
        dbStack.print();
        System.out.println("pop: " + dbStack.pop());
        dbStack.print();
    }
}
