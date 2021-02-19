/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_normal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hugo.ribeiro
 */
public class ex2 {
    
    public static List<Character> misterio(Set<String> set) {
        List<Character> l = new LinkedList<>();
        boolean flag= true;
        int i = 0;
        
        while (flag) {
            flag= false;
            for (String s : set) {
                if (i < s.length()) {
                    l.add(s.charAt(i));
                    flag= true;
                }
            }
            i++;
        }
        return l;
    }
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        
        set.add("Te");
        set.add("Teste2");
        set.add("Teste3");
        set.add("Te");
                
        List<Character> l = misterio(set);
        
        System.out.println(l);
    }
}
