package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Generic_Pair<U, V> {
    public U first;
    public V second;

    public Generic_Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}


class Generic_Bucket <K, V>{
    private List<Generic_Pair<K, V>> bucket;

    public Generic_Bucket() {
        this.bucket = new LinkedList<Generic_Pair<K, V>>();
    }

    public V get(K key) {
        for (Generic_Pair<K, V> pair : this.bucket) {
            if (pair.first.equals(key))
                return pair.second;
        }
        return null;
    }

    public boolean update(K key, V value) {
        for (Generic_Pair<K, V> pair : this.bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                return true;
            }
        }
        this.bucket.add(new Generic_Pair<K, V>(key, value));
        return false;
    }

    public V remove(K key) {
        for (Generic_Pair<K, V> pair : this.bucket) {
            if (pair.first.equals(key)) {
                V p = pair.second;
                this.bucket.remove(pair);
                return p;
            }
        }
        return null;
    }
}

public class Generic_HashMap <K, V>{
    private int key_space;
    private List<Generic_Bucket<K, V>> hash_table;
    private int size;
    /** Initialize your data structure here. */
    public Generic_HashMap() {
        this.key_space = 2069;
        this.hash_table = new ArrayList<Generic_Bucket<K, V>>();
        for (int i = 0; i < this.key_space; ++i) {
            this.hash_table.add(new Generic_Bucket<K, V>());
        }
        size = 0;
    }

    /** value will always be non-negative. */
    public void put(K key, V value) {
        int hash_key = key.hashCode();
        boolean bool = this.hash_table.get(hash_key).update(key, value);
        if(!bool) {
            size++;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public V get(K key) {
        int hash_key = key.hashCode();
        return this.hash_table.get(hash_key).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public V remove(K key) {
        int hash_key = key.hashCode();
        V e = this.hash_table.get(hash_key).remove(key);
        if(e != null)
            size--;
        return e;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Generic_HashMap<Integer, Integer> map = new Generic_HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
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

        for(int i = 1; i < map.getSize(); i++) {
            System.out.println(map.get(i));
        }

        System.out.println(map.getSize());

        System.out.println(map.remove(1));
        System.out.println(map.remove(2));
        System.out.println(map.remove(90));
        System.out.println(map.remove(80));

        for(int i = 1; i < map.getSize(); i++) {
            System.out.println(map.get(i));
        }

        System.out.println(map.getSize());


        System.out.println("--------------");

        Generic_HashMap<String, String> map2 = new Generic_HashMap<>();
        map2.put("1", "222");

        System.out.println(map2.get("1"));
        System.out.println(map2.get("2"));
    }
}


