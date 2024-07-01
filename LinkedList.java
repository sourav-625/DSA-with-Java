package DSA;

class Node {
	Object element;
	Node next;
	Node(Object element) {
		this.element = element;
		next = null;
	}
}
public class LinkedList<T> {
    Node head=null;
	//method to insert at first
	public void insertAtFirst(T element) {
		Node newNode = new Node(element);
		newNode.next = head;
		head = newNode;
	}
	//method to insert at last
	public void insertAtLast(T element) {
		Node newNode = new Node(element);
		if(head == null){
			head = newNode;
			return;
		}
		Node cur=head;
		while(cur.next != null){
			cur = cur.next;
		}
		cur.next = newNode;
	}
	//method to insert at any position
	public void insert(int index, T element) {
		Node newNode = new Node(element);
		Node cur=head;
		for(int i = 0; i < index - 1; i++){
			cur = cur.next;
			i++;
		}
		newNode.next = cur.next;
		cur.next = newNode;
	}
	//method to display linked list
	public void display() {
		if(head == null){
			System.out.println("Linked list is empty");
		}
		Node cur = head;
		while(cur != null){
			System.out.print(cur.element+" >> ");
			cur = cur.next;
		}
		System.out.println();
	}
	//method to find element at a certain position
	public Object elementAt(int index) {
		Node ans=head;
		for(int i = 0; i < index; i++){
			ans = ans.next;
		}
		return ans.element;
	}
	//method to check if element is there in linked list
	public boolean listed(T element) {
		if(head == null) return false;
		Node cur = head;
		while(cur.next != null) {
			if(cur.element == element) return true;
			cur = cur.next;
		}
		return false;
	}
	//method to refer to a node at a certain index
	public Node node(int index) {
		Node ref = head;
		for(int i = 0; i < index; i++){
			ref = ref.next;
		}
		return ref;
	}
	//method to delete an element at index
	public void delete(int index) {
		Node cur = head;
		for(int i = 0; i < index - 1; i++){
			cur = cur.next;
		}
		cur.next = cur.next.next;
	}
	//method to find the length of linked list
	public int listLength(){
		int length = 0;
		Node cur = head;
		if(head == null) return length;
		while(cur.next != null){
			length++;
			cur = cur.next;
		}
		return length;
	}

	//main method to run the program
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.insertAtLast(0);
		l.insertAtLast(1);
		l.insertAtLast(2);
		l.insert(1,3);
		l.display();
		l.delete(1);
		l.display();
		System.out.println(l.listLength());
	}
}
