/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_recurso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import javafx.util.Pair;

/**
 *
 * @author hugo.ribeiro
 */
public class ex1 {
    
    public static String commonFirstName(List<String> names, List<String> nicknames) {
        
        TreeSet<String> commonNames = new TreeSet<>();
        int differentNicks = 0, cont = 0;
        String mostNicks="";
        
        for(String name : names) {
            if(!commonNames.contains(name)) {
                commonNames.add(name);
                TreeSet<String> commonNicks = new TreeSet<>();
                cont = 0;
                
                for(String nickname : nicknames) {
                    if(names.get(cont).equals(name)) {
                        commonNicks.add(nickname);
                    }
                    cont++;
                }
                
                cont=commonNicks.size();
                if(cont > differentNicks) {
                    differentNicks = cont;
                    mostNicks = name;
                }
            }
        }
        
        return mostNicks;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] namesArray = {"Bob", "Mary", "Steve", "Derek", "Mary", "Derek", "Joe", "Derek", "Nicole", "Mary"};
        String[] nicknamesArray = {"Jones", "Ford", "Akers", "Smith", "Giles", "Smith", "Caiu", "Jones", "Jones", "Stepp"};
        
        List<String> names = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        
        for(int i=0;i<namesArray.length;i++) {
            names.add(namesArray[i]);
            nicknames.add(nicknamesArray[i]);
        }
        
        String result = commonFirstName(names, nicknames);
        
        System.out.println(result);
    }
    
}
