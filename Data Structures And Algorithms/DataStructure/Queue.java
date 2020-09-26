package DataStructure;

public class Queue {
    private static class Node{
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node head; //remove from head
    private Node tail; //add from tail
    private int count = 0;

    public boolean isEmpty(){
        return head == null;
    }

    public int peek(){
        if(head == null){
            throw new IllegalStateException();
        }
        return head.data;
    }

    public void add(int data){
        Node node = new Node(data);
        if(tail != null){
            tail.next = node;
        }
        tail = node;

        if(head == null){
            head = node;
        }
        count++;
    }

    public int size(){
        return count;
    }

    public int remove(){
        int data;
        if(head != null){
            count--;
            data = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
        }
        else {
            throw new IllegalStateException();
        }
        return data;
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


    public void print(){
        if(head == null){
            return;
        }

        Node current = head;
        System.out.println("------------------------");
        System.out.println("The values inside the DataStructure.Queue are: ");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("------------------------");
    }





    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(34);
        q.add(50);
        //Last   50 - 34 - 1   First
        q.print();
        System.out.println(q.contains(3));
        System.out.println(q.contains(1));
        System.out.println("DataStructure.Queue size = " + q.size());
        System.out.println("DataStructure.Queue front = " + q.peek());
        System.out.println("Is the queue empty? " + q.isEmpty());

    }
}
