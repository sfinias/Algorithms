package org.example.algorithms.lists.challenge2;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {

        // add your code here

        IntegerNode newNode = new IntegerNode(value);

        if (head == null) {
            head = newNode;
            return;
        }

        IntegerNode current = head;
        IntegerNode previous = null;
        while (current != null && current.getValue() <= value) {
            IntegerNode temp = current;
            current = current.getNext();
            previous = temp;
        }
        if (previous != null) {
            previous.setNext(newNode);
        }
        if (head.equals(current)) {
            head = newNode;
        }
        newNode.setNext(current);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
