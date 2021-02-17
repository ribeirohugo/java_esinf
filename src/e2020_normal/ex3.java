/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_normal;

import trees.*;

/**
 *
 * @author hugo.ribeiro
 */
public class ex3<E extends Comparable<E>> extends TREE<E> {
   
    public E inOrderSuccessor(E element) {
        
        return inOrderSuccessor(element, this.root, this.root.getElement());
    }
    
    public E inOrderSuccessor(E element, Node<E> node, E successor) {
        
        if(node == null)
            return successor;
        
        if(node.getElement().compareTo(element) > 0) {
            if(node.getElement().compareTo(successor) < 0 || element.compareTo(successor) >= 0) {
                successor = node.getElement();
            }

            return inOrderSuccessor(element, node.getLeft(), successor);
        }

        return inOrderSuccessor(element, node.getRight(), successor);
    }
    
    public static void main(String[] args) {
        Integer[] arr = {20,15,10,13,8,17,40,50,30,7};
        ex3<Integer> instance = new ex3();
        
        for(int i :arr)
            instance.insert(i);
        
        System.out.println(instance.toString());
        
        System.out.println(String.format("ExpResult: %d; Result: %d", 8, instance.inOrderSuccessor(7)));
        System.out.println(String.format("ExpResult: %d; Result: %d", 10, instance.inOrderSuccessor(8)));
        System.out.println(String.format("ExpResult: %d; Result: %d", 30, instance.inOrderSuccessor(20)));
        System.out.println(String.format("ExpResult: %d; Result: %d", 40, instance.inOrderSuccessor(30)));
        System.out.println(String.format("ExpResult: %d; Result: %d", 50, instance.inOrderSuccessor(40)));
    }
}


