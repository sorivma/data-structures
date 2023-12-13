package org.example.structures.hashtable;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.8;
    private int collisions = 0;
    private LinkedList<KeyValue<K, V>>[] table;
    private int size;

    @NotNull
    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        LinkedList<KeyValue<K, V>> allEntries = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                allEntries.addAll(list);
            }
        }
        return allEntries.iterator();
    }

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    public void add(K key, V value) {
        addOrReplace(key, value);
    }

    private int findSlotNumber(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % table.length;
    }

    private void growIfNeeded() {
        if ((double) (size + 1) / table.length > LOAD_FACTOR_THRESHOLD) {
            grow();
        }
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        int newCapacity = table.length * 2;
        LinkedList<KeyValue<K, V>>[] newTable = new LinkedList[newCapacity];

        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                for (KeyValue<K, V> entry : list) {
                    int newSlot = Math.abs(entry.getKey().hashCode()) % newCapacity;
                    if (newTable[newSlot] == null) {
                        newTable[newSlot] = new LinkedList<>();
                    }
                    newTable[newSlot].add(entry);
                }
            }
        }
        table = newTable;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return table.length;
    }

    public boolean addOrReplace(K key, V value) {
        int slot = findSlotNumber(key);

        if (table[slot] == null) {
            table[slot] = new LinkedList<>();
        }

        for (KeyValue<K, V> entry : table[slot]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return false;
            }
        }

        if (!table[slot].isEmpty()) {
            collisions+=1;
        }
        table[slot].add(new KeyValue<>(key, value));
        size++;
        growIfNeeded();
        return true;
    }

    public V get(K key) {
        int slot = findSlotNumber(key);
        if (table[slot] != null) {
            for (KeyValue<K, V> entry : table[slot]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public KeyValue<K, V> find(K key) {
        int slot = findSlotNumber(key);
        if (table[slot] != null) {
            for (KeyValue<K, V> entry : table[slot]) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return find(key) != null;
    }

    public boolean remove(K key) {
        int slot = findSlotNumber(key);
        if (table[slot] != null) {
            Iterator<KeyValue<K, V>> iterator = table[slot].iterator();
            while (iterator.hasNext()) {
                KeyValue<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public Iterable<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                for (KeyValue<K, V> entry : list) {
                    keys.add(entry.getKey());
                }
            }
        }
        return keys;
    }

    public Iterable<V> values() {
        LinkedList<V> values = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                for (KeyValue<K, V> entry : list) {
                    values.add(entry.getValue());
                }
            }
        }
        return values;
    }

    public int collisionCount() {
        int sum = 0;
        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null && !list.isEmpty()) {
                sum += list.size() - 1;
            }
        }
        return sum;
    }

    public int getCollisions() {
        return collisions;
    }
}
