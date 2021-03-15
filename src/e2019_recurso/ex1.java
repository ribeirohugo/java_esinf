/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2019_recurso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hugo.ribeiro
 */
public class ex1 {
    public static void Doublepacking(Double capac, List<Double> pesos, Map<Integer,LinkedList<Double>> paletes) {
        if(pesos.isEmpty()) {
            return;
        }
                
        for(Double peso : pesos) {

            int cont = 1;
            for(Map.Entry<Integer,LinkedList<Double>> palete : paletes.entrySet() ) {

                Double sum = 0.0;
                
                LinkedList<Double> teste = palete.getValue();

                for(Double item : palete.getValue()) {
                    sum = sum + item;
                }
                
                if(sum + peso <= capac) {
                    break;
                }
                
                cont++;
            }
            
            LinkedList<Double> linked;
            if(paletes.containsKey(cont)) {
                linked = paletes.get(cont);
            } else {
                linked = new LinkedList<>();
            }
            
            linked.add(peso);
            paletes.put(cont++, linked);
        }
    }
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer,LinkedList<Double>> paletes = new HashMap<>();
        
        List<Double> pesos = new ArrayList<>(Arrays.asList(4.0, 8.0, 2.0, 1.0, 7.0, 6.0, 1.0, 4.0, 5.0, 2.0));
        System.out.println(pesos);
        
        Doublepacking(10.0, pesos, paletes);
        System.out.println(paletes);
    }
}
