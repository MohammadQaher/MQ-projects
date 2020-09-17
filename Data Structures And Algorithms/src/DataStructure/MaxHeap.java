package DataStructure;

import java.util.Arrays;

public class MaxHeap {

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }


    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }


    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }


    public int peek() {
        if (size == 0)
            throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0)
            throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }


    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }


    public int size() {
        return size;
    }


    private void heapifyUp() {
        int index = size -1;
        while (hasParent(index) && parent(index) < items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);

        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] > items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }


    public void print() {
        if(size == 0) {
            return;
        }
        int index = 0;
        System.out.println(parent(index));
        while (hasLeftChild(index)) {
            System.out.println(leftChild(index));
            if(hasRightChild(index)) {
                System.out.println(rightChild(index));
            }
            index++;
        }
    }


    public boolean contains(int value) {
        int index = 0;
        if(items[index] == value) {
            return true;
        }
        while (hasLeftChild(index)) {
            if(leftChild(index) == value) {
                return true;
            } else if(hasRightChild(index)) {
                if(rightChild(index) == value) {
                    return true;
                }
            }
            index++;
        }
        return false;
    }



    public static void main(String[] args){
        MaxHeap m2 = new MaxHeap();

        m2.add(5);
        m2.add(2);
        m2.add(3);
        m2.add(1);
        m2.add(10);
        m2.add(8);
        m2.add(9);

        m2.print();
        System.out.println("----------------------");
        System.out.println(m2.peek());
        System.out.println("----------------------");
        System.out.println(m2.size());
        System.out.println("----------------------");
        System.out.println(m2.poll());
        System.out.println("----------------------");
        System.out.println(m2.peek());

        System.out.println(m2.contains(3));
        System.out.println(m2.contains(11));
    }
}
