/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_normal;

import Priority_queue.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo.ribeiro
 */
public class ex5<K, V> extends HeapPriorityQueue<K,V>  {
    public HeapPriorityQueue<Integer,String> mergeHeaps(HeapPriorityQueue<Integer,String> hp1, HeapPriorityQueue<Integer,String> hp2) {
        
        List<Integer> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        
        Entry<Integer, String> heap1 = hp1.removeMin();
        Entry<Integer, String> heap2 = hp2.removeMin();
        
        int tamanho = hp1.size() + hp2.size();
        
        for(int i = 0; i<tamanho && (!hp1.isEmpty() && !hp2.isEmpty()); i++) {
            
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
    
    public static void main(String[] args) {

        Integer[] keys1 = {0,1,1,2,2,2,2,3,3,3};
        String[] values1 = {"20","15","10","13","8","17","40","50","30","7"};
        
        Integer[] keys2 = {0,1,1};
        String[] values2 = {"3","4","5"};
        
        HeapPriorityQueue<Integer, String> heap1 = new HeapPriorityQueue<>(keys1,values1);
        HeapPriorityQueue<Integer, String> heap2 = new HeapPriorityQueue<>(keys2,values2);
        
        System.out.println("Heap1 = "+heap1.toString());
        System.out.println("Heap2 = "+heap2.toString());
        
        HeapPriorityQueue<Integer, Integer> instance = new ex5();
        HeapPriorityQueue<Integer, String> heapResult = instance.mergeHeaps(heap1,heap2);
        
        System.out.println(heapResult.toString());
    }
}
