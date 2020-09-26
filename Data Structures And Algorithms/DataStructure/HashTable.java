package DataStructure;

import java.util.ArrayList;

class HashNode<K, V>
{
    K key;
    V value;

    // Reference to next node
    HashNode<K, V> next;

    // Constructor
    public HashNode(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}

public class HashTable <K, V>{
    // array is used to store array of chains
    private ArrayList<HashNode<K, V>> array;

    // Current capacity of array list
    private int bucketsInArray;

    // Current size of array list
    private int size;

    // Constructor (Initializes capacity, size and
    // empty chains.
    public HashTable()
    {
        array = new ArrayList<>();
        bucketsInArray = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < bucketsInArray; i++)
            array.add(null);
    }

    // This implements hash function to find index
    // for a key
    private int getHashArray(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode % bucketsInArray;
        return index;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size() == 0;
    }



    public void add(K key, V value) {
        int bucketIndex = getHashArray(key);
        HashNode<K, V> head = array.get(bucketIndex);

        // Check if key is already present
        while (head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = array.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        array.set(bucketIndex, newNode);

    }



    public V get(K key) {
        // Find head of chain for given key
        int bucketIndex = getHashArray(key);
        HashNode<K, V> head = array.get(bucketIndex);

        while (head != null) {  // Search key in chain
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // If key not found
    }



    public V remove(K key)
    {
        // Apply hash function to find index for given key
        int bucketIndex = getHashArray(key);

        // Get head of chain
        HashNode<K, V> head = array.get(bucketIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null)
        {
            // If Key found
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            array.set(bucketIndex, head.next);

        return head.value;
    }




    public void print() {
        for(HashNode<K, V> i : array){
            if( i != null) {
                System.out.print("The key is \"" + i.key + "\" and the value = ");
                System.out.print(i.value);
                System.out.println("");
            }
        }
    }



    public boolean contains(K key){
        int bucketIndex = getHashArray(key);
        HashNode<K, V> head = array.get(bucketIndex);

        while (head != null)
        {
            if (head.key.equals(key))
                return true;
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args)
    {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.add("this",1 );
        hashTable.add("coder",2 );
        hashTable.add("this",4 );
        hashTable.add("hi",5 );

        System.out.println(hashTable.size());
        System.out.println(hashTable.remove("this"));
        System.out.println(hashTable.remove("this"));
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());
        System.out.println("-------");
        hashTable.print();

        System.out.println(hashTable.contains("coder"));
        System.out.println(hashTable.contains("hi"));
        System.out.println(hashTable.contains("sdsd"));

        System.out.println(hashTable.get("hi"));

        HashTable<Integer, String> hashTable2 = new HashTable<>();
        hashTable2.add(1, "this");
        hashTable2.add(2, "this2");
        hashTable2.add(3, "this");
        hashTable2.add(4, "this2");
        hashTable2.add(5, "this");
        hashTable2.add(6, "this2");
        hashTable2.add(7, "this");
        hashTable2.add(8, "this2");
        hashTable2.add(9, "this");
        hashTable2.add(11, "this2");
        hashTable2.add(12, "this");


        hashTable2.print();
        hashTable2.remove(1);
        hashTable2.print();
        System.out.println(hashTable2.size());
        
    }
}
