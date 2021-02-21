/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2021_normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.util.Pair;

/**
 *
 * @author hugo.ribeiro
 */
public class ex1 {
    
    
    public Map<Integer, ArrayList<Pais>> numBoders(List<Pair<Pais,Pais>> lf) {
        
        Map<Integer, ArrayList<Pais>> retorno = new TreeMap<>();
        
        Map<Pais, Integer> mapaAux = new HashMap<>();
        
        for(Pair<Pais,Pais> entry : lf) {
            
            Pais key = entry.getKey();
            Pais value = entry.getValue();
            
            if(mapaAux.containsKey(key)) {
                Integer auxValue = mapaAux.get(key);
                mapaAux.put(key, auxValue+1);
            } else {
                mapaAux.put(key,new Integer(1));
            }
            
            if(mapaAux.containsKey(value)) {
                Integer auxValue = mapaAux.get(value);
                mapaAux.put(value, auxValue+1);
            } else {
                mapaAux.put(value, new Integer(1));
            }
        }
        
        Iterator it = mapaAux.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry)it.next();

            Pais retornoKey = (Pais) pair.getKey();
            Integer retornoValue = (Integer) pair.getValue();

            if(retorno.containsKey(retornoValue)) {

                ArrayList<Pais> lista = retorno.get(retornoValue);
                lista.add(retornoKey);
                retorno.put(retornoValue,lista);
            } else {
                ArrayList<Pais> lista = new ArrayList<>();
                lista.add(retornoKey);
                retorno.put(retornoValue, lista);
            }
        }        
        
        return retorno;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Pair<Pais,Pais>> paises = new ArrayList<>();
        
        ex1 instance = new ex1();
        
        paises.add(new Pair<Pais,Pais>(new Pais("Portugal"), new Pais("Espanha")));
        paises.add(new Pair<Pais,Pais>(new Pais("Espanha"), new Pais("França")));
        paises.add(new Pair<Pais,Pais>(new Pais("Espanha"), new Pais("Gibraltar")));
        paises.add(new Pair<Pais,Pais>(new Pais("Espanha"), new Pais("Andorra")));
        paises.add(new Pair<Pais,Pais>(new Pais("França"), new Pais("Bélgica")));
        paises.add(new Pair<Pais,Pais>(new Pais("França"), new Pais("Luxemburgo")));

        Map<Integer, ArrayList<Pais>> mapa = instance.numBoders(paises);

        System.out.println(mapa.toString());
    }
}
