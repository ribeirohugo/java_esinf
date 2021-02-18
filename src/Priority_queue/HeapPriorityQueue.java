/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Priority_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * An implementation of a priority queue using an array-based heap.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author antoniosilva
 * @param <K>
 * @param <V>
 *
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    /**
     * primary collection of priority queue entries
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its
     * keys.
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the priority queue
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Creates a priority queue initialized with the respective key-value pairs.
     * The two arrays given will be paired element-by-element. They are presumed
     * to have the same length. (If not, entries will be created only up to the
     * length of the shorter of the arrays)
     *
     * @param keys an array of the initial keys for the priority queue
     * @param values an array of the initial values for the priority queue
     */
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int j = 0; j < Math.min(keys.length, values.length); j++) {
            heap.add(new PQEntry<>(keys[j], values[j]));
        }
        buildHeap();
    }

    // protected utilities
    protected int parent(int j) {
        return (j - 1) / 2;
    }     // truncating division

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     *
     * @param i
     * @param j
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap
     * property.
     *
     * @param j
     */
    protected void percolateUp(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) < 0) {
                swap(j, p);
            }
            j = p;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap
     * property.
     *
     * @param j
     */
    protected void percolateDown(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) {
                break;
            }
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    /**
     * Performs a batch bottom-up construction of the heap in O(n) time.
     */
    protected void buildHeap() {
        int startIndex = parent(size() - 1);
        for (int j = startIndex; j >= 0; j--) {
            percolateDown(j);
        }
    }

    // public methods
    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     *
     * @return entry having a minimal key (or null if empty)
     */
    @Override
    public Entry<K, V> min() {
        return heap.get(0);
    }

    /**
     * Inserts a key-value pair and return the entry created.
     *
     * @param key the key of the new entry
     * @param value the associated value of the new entry
     * @return the entry storing the new key-value pair
     * @throws IllegalArgumentException if the key is unacceptable for this
     * queue
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        PQEntry entry = new PQEntry<>(key, value);
        heap.add(entry);
        percolateUp(size() - 1);
        return entry;
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry (or null if empty)
     */
    @Override
    public Entry<K, V> removeMin() {
        Entry entry = min();
        heap.remove(entry);
        percolateDown(0);
        return entry;
    }

    @Override
    public String toString() {

        String str = "";

        if (heap.isEmpty()) {
            str = "\n PQ is empty!";
        } else {
            for (int i = 0; i < heap.size(); i++) {
                Entry<K, V> elem = heap.get(i);
                str += "(" + elem.getKey() + ", " + elem.getValue() + ") ";
            }
        }
        return str;
    }

    @Override
    public HeapPriorityQueue<K, V> clone() throws CloneNotSupportedException {

        HeapPriorityQueue<K, V> newPQ = new HeapPriorityQueue<>();
        Entry<K, V> e;

        int startIndex = heap.size() - 1;
        for (int j = startIndex; j >= 0; j--) {
            e = heap.get(j);
            K k = e.getKey();
            V v = e.getValue();
            newPQ.insert(k, v);
        }
        return newPQ;
    }

    //HeapPriorityQueue<K,V>
    public List<V> getElementsLevel(int level) {
        List<V> elements = new ArrayList<>();        
        
        int expoente = level, inicio = 1, ultimo=0;
        
        while(expoente>0) {
            inicio *=2;
            expoente--;
        }

        ultimo = inicio*2-1;
        inicio--;

        int size = heap.size();
        
        for(int i = inicio; i< ultimo; i++) {
            if(i < size) {
                elements.add(heap.get(i).getValue());
            } else {
                break;
            }
        }
        
        return elements;
    }
    
    public HeapPriorityQueue<Integer,String> mergeHeaps(HeapPriorityQueue<Integer,String> hp1, HeapPriorityQueue<Integer,String> hp2) {
        
        List<Integer> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        
        Entry<Integer, String> heap1 = hp1.removeMin();
        Entry<Integer, String> heap2 = hp2.removeMin();
        
        int tamanho = hp1.size() + hp2.size();
        
        for(int i = 0; i<tamanho || (!hp1.isEmpty() && !hp2.isEmpty()); i++) {
            
            if(heap1.getKey() < heap2.getKey()) {
                keys.add(heap1.getKey());
                values.add(heap1.getValue());
            } else if(heap1.getKey() > heap2.getKey()) {
                keys.add(heap2.getKey());
                values.add(heap2.getValue());
            } else {
                keys.add(heap1.getKey());
                keys.add(heap2.getKey());
                values.add(heap1.getValue());
                values.add(heap2.getValue());
                
                heap1 = hp1.removeMin();
                heap2 = hp2.removeMin();
            }
        }
        
        while(!hp1.isEmpty()) {
            heap1 = hp1.removeMin();
            keys.add(heap1.getKey());
            values.add(heap1.getValue());
        }
        
        while(!hp2.isEmpty()) {
            heap2 = hp2.removeMin();
            keys.add(heap2.getKey());
            values.add(heap2.getValue());
        }
        
        HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>();
        
        for(int i=0;i<keys.size();i++) {
            queue.insert(keys.get(i), values.get(i));
        }
        
        return queue;
    }
}
