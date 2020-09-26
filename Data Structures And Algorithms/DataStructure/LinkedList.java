package DataStructure;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {

    private Node head;
    private int count = 0;


    public void append(int data) {
        if(head == null) {
            head = new Node(data);
            count++;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        count++;
    }


    public void prepend(int data) {
        Node backHead = new Node(data);
        backHead.next = head;
        head = backHead;
        count++;
    }


    public void deleteWithValue(int data) {
        if(head == null) {
            throw new IllegalStateException();
        }

        if(head.data == data) {
            head = head.next;
            count--;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if(current.next.data == data) {
                current.next = current.next.next;
                count--;
                return;
            }
            current = current.next;
        }
    }



    public int size(){
        return count;
    }




    public void print(){
        if(head == null){
            return;
        }
        Node current = head;
        System.out.println("------------------------");
        System.out.println("The values inside the DataStructure.LinkedList are: ");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("------------------------");
    }




    public boolean isEmpty(){
        return head == null;
    }




    public boolean contains(int data) {
        if(head == null) {
            throw new IllegalStateException();
        }
        Node current = head;
        while (current != null) {
            if(current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }



    public int[] toArray (){
        if(head == null) {
            throw new IllegalStateException();
        }

        int [] array = new int[size()];
        int counter = 0;
        Node current = head;

        while (current != null) {
            array[counter] = current.data;
            current = current.next;
            counter++;
        }
        return array;
    }



    public boolean isCyclic () {
        if(head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if(fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    public int midOfLinkedList() {
        if(head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }


    public static void main(String[] args){
        LinkedList l = new LinkedList();
        System.out.println("Is the linkedList empty? " + l.isEmpty());
        l.append(14);
        l.prepend(15);
        l.append(10);
        //15-14-10
        System.out.println("DataStructure.LinkedList size = " + l.size());
        l.print();
        l.deleteWithValue(14);
        l.print();
        System.out.println("Is the linkedList empty? " + l.isEmpty());
        System.out.println(l.contains(14));
        System.out.println(l.contains(15));
        l.prepend(12);
        l.append(11);
        l.prepend(14);
        l.append(9);
        l.append(16);



        int [] c = l.toArray();
        for(int i : c){
            System.out.println(i);
        }
        System.out.println("--------------");
        System.out.println(l.isCyclic());
        System.out.println(l.midOfLinkedList());
    }
}

