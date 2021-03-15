/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_especial;

import Priority_queue.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo.ribeiro
 */
public class ex5<K, V> extends HeapPriorityQueue<K,V> {
    
    public List<V> ElemslastCompleteLevel() {
        List<V> lista = new ArrayList<>();
        
        int size = heap.size();
        int level = 0;
        
        //Calcular número de níveis
        while(size != 1) {
            size /= 2;
            level++;
        }
        
        int previousMin = 1;
        int min = 2;
        int max = 2;
        int aux = level-1;
        
        //Calcular minimo e máximo
        while(aux!=0) {
            previousMin *= 2;
            min *= 2;
            max *= 2;
                        
            aux--;
        }
        
        max *= 2;

        //Verificar se o último nível está preenchido
        size = heap.size();
        if(size != max-1) {
            max = min;
            min = previousMin;
        }
        
        min--;
        max--;
        
        for(int i = min; i < max; i++) {
            V element = heap.get(i).getValue();
            
            lista.add(element);
        }
        
        return lista;
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
        
        List<Integer> lista = instance.ElemslastCompleteLevel();
        
        System.out.println(lista);
    }
}
