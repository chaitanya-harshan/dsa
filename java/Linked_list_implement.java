/**
  implementing Linked Lists
*/
public class Linked_list_implement {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // Adding elements to the list
        list.add(10);
        list.add(20);
        list.add(30);

        // Printing the list
        System.out.print("Initial List: ");
        list.printList(); // Output: 10 20 30 

        // Adding element at the beginning
        list.addFirst(5);
        System.out.print("After adding 5 at the beginning: ");
        list.printList(); // Output: 5 10 20 30 

        // Deleting an element
        list.delete(20);
        System.out.print("After deleting 20: ");
        list.printList(); // Output: 5 10 30 

        // Checking if list contains a specific element
        System.out.println("List contains 10: " + list.contains(10)); // Output: true
        System.out.println("List contains 20: " + list.contains(20)); // Output: false

        // Getting the size of the list
        System.out.println("Size of the list: " + list.size()); // Output: 3
    }
}


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to add a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to delete a node by value
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Method to print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to search for a node by value
    public boolean contains(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Method to get the size of the list
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
