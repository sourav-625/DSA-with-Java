package DSA;

public class DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }
    
    Node head = null;

    public void addlast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        cur.next.prev = cur;
    }

    public void addfirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        head.prev = newNode;
        head.prev.next = head;
        head = head.prev;
    }

    public void insert(int index, int data) {
        Node cur = head;
        Node newNode = new Node(data);
        if(index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        for(int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next = newNode;
        newNode.next.prev = newNode;
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addfirst(0);
        dl.addfirst(1);
        dl.addlast(2);
        dl.addlast(3);
        dl.insert(1, 4);
        Node cur = dl.head;
        while(cur != null) {
            System.out.print(cur.data + " <--> ");
            cur = cur.next;
        }
    }
}
