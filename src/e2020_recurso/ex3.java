/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_recurso;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import trees.*;

/**
 *
 * @author hugo.ribeiro
 */
public class ex3<E extends Comparable<E>> extends TREE<E> {
    
    public E findLCA(Set<E> elements) {
        E min = Collections.min(elements);
        E max = Collections.max(elements);
        
        E resultado = null;
        
        while(true) {
            if(root.getElement().compareTo(min) < 0 && root.getElement().compareTo(max) < 0) {
                root = root.getRight();
            } else if(root.getElement().compareTo(min) > 0 && root.getElement().compareTo(max) > 0) {
                root = root.getLeft();
            } else {
                resultado = root.getElement();
                break;
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        Integer[] arr = {20,15,10,13,8,17,40,50,30,7};
        ex3<Integer> instance = new ex3();
        
        for(int i :arr)
            instance.insert(i);
        
        HashSet<Integer> set = new HashSet<>();
        set.add(7);
        set.add(8);
        set.add(10);
        
        System.out.println(instance.toString());
        
        System.out.println(String.format("ExpResult: %d; Result: %d", 10, instance.findLCA(set)));
    }
}
