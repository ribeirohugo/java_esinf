/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2021_normal;

import Priority_queue.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo.ribeiro
 */
public class ex5<K, V> extends HeapPriorityQueue<K,V>  {
    
    public List<Entry<K, V>> getCommonPathElements(int idx1, int idx2) {
        
        List<Entry<K, V>> lista = new ArrayList<>();
        List<Entry<K, V>> listaAux = new ArrayList<>();
        
        int maior = idx1;
        int menor = idx2;
        if(idx2 > idx1) {
            maior = idx2;
            menor = idx1;
        }
        
        while(maior >= 0) {
            listaAux.add(heap.get(maior));
            
            if(maior <= 0) {
                break;
            }
            
            maior = (maior-1)/2;
        }
        
        while(menor >= 0) {
            Entry<K, V> entry = heap.get(menor);
            if(listaAux.contains(entry)) {
                lista.add(entry);
            }
            
            if(menor <= 0) {
                break;
            }
            
            menor = (menor-1)/2;
        }
        
        return lista;
    }
    
    public static void main(String[] args) {
        String[] values = {"A","B","B","C","D","E","D","E","F"};
        Integer[] keys = new Integer[values.length];
        ex5 instance = new ex5();
        
        for(int i = 0; i<values.length; i++) {
            keys[i] = new Integer(i);
            instance.insert(keys[i], values[i]);
        }
        
        System.out.println(instance.toString());
        
        List<Entry<Integer, String>> lista = instance.getCommonPathElements(7, 8);
        
        for(Entry<Integer, String> entry: lista) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
