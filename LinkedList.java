package SapientTest;

public class LinkedList {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;

		}
	}

	public static LinkedList insert(LinkedList linkedList, int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		if (linkedList.head == null) {
			linkedList.head = newNode;
		} else {
			// traverse till last
			Node last = linkedList.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return linkedList;

	}
	
	public static void printList(LinkedList linkedList)
	{
		Node currNode=linkedList.head;
		while(currNode!=null)
		{
			System.out.println(currNode.data);
			currNode=currNode.next;
		}
		
	}
	
	public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        LinkedList list = new LinkedList(); 
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 
  
        // Print the LinkedList 
        printList(list); 
    } 

}

