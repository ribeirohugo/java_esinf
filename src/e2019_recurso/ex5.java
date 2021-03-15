/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2019_recurso;

import Priority_queue.*;

/**
 *
 * @author hugo.ribeiro
 */
public class ex5<K, V> extends HeapPriorityQueue<K,V> {

    public static <K,V extends Comparable<V>> int NumbElemsLastLevel(HeapPriorityQueue<K,V> heap) {
        
        int size = heap.size();
        
        int level = 1;
        
        //Calcular número de níveis
        while(size != 1) {
            size /= 2;
            level++;
        }
        
        int aux=level;
        int min=1;
        int max=1;
        
        //Calcular mínimo e máximo da heap
        while(aux!=1) {
            min *= 2;
            aux -= 1;
        }
        max = min * 2;
                
        aux=0;
        int cont=0;
        while(!heap.isEmpty()) {
            aux++;
            if(aux>=min && aux<max) {
                cont++;
            }
            
            heap.removeMin();
        }
        
        return cont;
    }
    
    public static void main(String[] args) {
        Integer[] values = {20, 15,10, 13,8,17,40, 50,30,7};
        Integer[] keys = new Integer[values.length];
        HeapPriorityQueue<Integer, Integer> instance = new HeapPriorityQueue();
        
        for(int i = 0; i<values.length; i++) {
            keys[i] = new Integer(i);
            instance.insert(keys[i], values[i]);
        }
        
        System.out.println(instance.toString());
        
        int number = NumbElemsLastLevel(instance);
        
        System.out.println(number);
    }
}
