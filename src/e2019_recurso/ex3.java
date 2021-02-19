/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2019_recurso;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import trees.TREE;

/**
 *
 * @author hugo.ribeiro
 */
public class ex3<E extends Comparable<E>> extends TREE<E> {
    
    public List<E> inverseOrder() {
        List<E> resultado = new LinkedList<E>();
        
        inverso(root, resultado);
        return resultado;
    }
    
    private List<E> inverso(Node<E> root, List<E> resultado) {
        
        if(root == null)
            return null;
        
        inverso(root.getLeft(), resultado);
        
        inverso(root.getRight(), resultado);
        
        resultado.add(root.getElement());
        return resultado;
    }
    
    
    public static void main(String[] args) {
        Integer[] arr = {20,15,10,13,8,17,40,50,30,7};
        ex3<Integer> instance = new ex3();
        
        for(int i :arr)
            instance.insert(i);
        
        System.out.println(instance.toString());
        
        List<Integer> inverse = instance.inverseOrder();
        
        System.out.println(inverse.toString());
    }
    
}
