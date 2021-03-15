/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_recurso;

import Priority_queue.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo.ribeiro
 */
public class ex5<K, V> extends HeapPriorityQueue<K,V> {
    
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
    
    public static void main(String[] args) {
        Integer[] values = {20,15,10,13,8,17,40,50,30,7};
        Integer[] keys = new Integer[values.length];
        ex5 instance = new ex5();
        
        for(int i = 0; i<values.length; i++) {
            keys[i] = new Integer(i);
            instance.insert(keys[i], values[i]);
        }
        
        System.out.println(instance.toString());
        
        List<Integer> nivel0 = instance.getElementsLevel(0);
        System.out.println("Nivel 0 = "+nivel0);
        List<Integer> nivel1 = instance.getElementsLevel(1);
        System.out.println("Nivel 1 = "+nivel1);
        List<Integer> nivel2 = instance.getElementsLevel(2);
        System.out.println("Nivel 2 = "+nivel2);
        List<Integer> nivel3 = instance.getElementsLevel(3);
        System.out.println("Nivel 3 = "+nivel3);
    }
}
