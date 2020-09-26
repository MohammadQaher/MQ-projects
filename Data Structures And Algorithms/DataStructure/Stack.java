package DataStructure;

public class Stack {
    private static class Node{
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }
    private Node top; //add and remove from top
    private int count = 0;
    public boolean isEmpty(){
        return top == null;
    }
    public int peek(){
        if(top == null){
            throw new IllegalStateException();
        }
        return top.data;
    }
    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
        count++;
    }

    public int size(){
        return count;
    }

    public int pull(){
        int data;
        if(top != null){
            count--;
            data = top.data;
            top = top.next;
        }
        else {
            throw new IllegalStateException();
        }
        return data;
    }




    public boolean contains(int data) {
        if(top == null) {
            throw new IllegalStateException();
        }
        Node current = top;
        while (current != null) {
            if(current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }




    public void print(){
        if(top == null){
            return;
        }

        Node current = top;
        System.out.println("------------------------");
        System.out.println("The values inside the DataStructure.Stack are: ");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("------------------------");
    }





    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(34);
        s.push(40);
        // Last   1   34   40   First
        s.print();
        s.pull();
        s.pull();
        s.push(50);
        // Last   1   50   First
        s.print();
        s.pull();

        System.out.println(s.contains(34));
        System.out.println(s.contains(1));
        System.out.println("DataStructure.Stack size = " + s.size());
        System.out.println("DataStructure.Stack peek = " + s.peek());
        System.out.println("Is the stack empty? " + s.isEmpty());
    }
}
