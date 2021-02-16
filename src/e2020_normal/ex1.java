/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_normal;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author hugo.ribeiro
 */
public class ex1 {
    
    public static<K, E extends Comparable<E>> List<Pair<K,E>> mergeLists(List<Pair<K,E>> A, List<Pair<K,E>> B) {
        
        List<Pair<K, E>> result = new ArrayList<>();
        
        while(!A.isEmpty() && !B.isEmpty()) {
            
            if(A.isEmpty()) {
                result.add(B.get(0));
                B.remove(0);
                
            } else if(B.isEmpty()) {
                result.add(A.get(0));
                A.remove(0);
                
            } else {
                E valueA = A.get(0).getValue();
                E valueB = B.get(0).getValue();
                
                if(valueB.compareTo(valueA) > 0) {
                    result.add(A.get(0));
                    A.remove(0);
                } else {
                    result.add(B.get(0));
                    B.remove(0);
                }
            }
        }

        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Pair<String,Integer>> A = new ArrayList<>();
        A.add(new Pair<>("A",2));
        A.add(new Pair<>("A",2));
        A.add(new Pair<>("A",5));
        
        List<Pair<String,Integer>> B = new ArrayList<>();
        B.add(new Pair<>("B",1));
        B.add(new Pair<>("B",1));
        B.add(new Pair<>("B",2));
        B.add(new Pair<>("B",3));
        B.add(new Pair<>("B",4));
        B.add(new Pair<>("B",4));
        B.add(new Pair<>("B",5));
        
        System.out.println("List A: "+A);
        System.out.println("List B: "+B);
        
        List<Pair<String,Integer>> result = mergeLists(A, B);
        
        System.out.println("Resultado: "+result);
    }
    
}
