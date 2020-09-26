package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}


class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key))
                return pair.second;
        }
        return null;
    }

    public void update(Integer key, Integer value) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
            }
        }
        this.bucket.add(new Pair<Integer, Integer>(key, value));
    }

    public Integer remove(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                int p = pair.second;
                this.bucket.remove(pair);
                return p;
            }
        }
        return null;
    }
}
public class HashMap {
    private int key_space;
    private List<Bucket> hash_table;

    /** Initialize your data structure here. */
    public HashMap() {
        this.key_space = 2069;
        //in order to minimize the potential collisions, it is advisable to use a prime number as the base of modulo, e.g. 2069.
        this.hash_table = new ArrayList<Bucket>();
        for (int i = 0; i < this.key_space; ++i) {
            this.hash_table.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).update(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public Integer get(int key) {
        int hash_key = key % this.key_space;
        return this.hash_table.get(hash_key).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public Integer remove(int key) {
        int hash_key = key % this.key_space;
        return this.hash_table.get(hash_key).remove(key);
    }


    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, -1);
        map.put(5, 50);
        map.put(6, 60);
        map.put(1, 20);
        map.put(7, 10);
        map.put(8, 20);
        map.put(9, 30);
        map.put(10, 40);
        map.put(11, 50);
        map.put(12, 60);
        map.put(13, 10);
        map.put(14, 20);
        map.put(15, 30);
        map.put(16, 40);
        map.put(17, 50);
        map.put(18, 60);


        System.out.println(map.remove(1));
        System.out.println(map.remove(2));
        System.out.println(map.remove(90));
        System.out.println(map.remove(80));
        System.out.println(map.remove(30));

    }
}


