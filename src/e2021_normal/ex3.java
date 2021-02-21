/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2021_normal;

import trees.TREE;

/**
 *
 * @author hugo.ribeiro
 */
public class ex3<E extends Integer> extends TREE<Integer> {
    
    public boolean isSymmetric() {
        
        return rec(root.getLeft(),root.getRight());
    }
    
    private boolean rec(Node<Integer> left, Node<Integer> right) {
        
        if(left!= null && right== null || left == null && right != null) {
            return false;
        } else if(left == null && right == null) {
            return true;
        }
        
        if(left.getElement() != right.getElement() * -1) {
            return false;
        }
        
        boolean result1 = rec(left.getLeft(), left.getRight());
        boolean result2 = rec(right.getRight(), right.getLeft());
        
        return result1 && result2;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer[] symetric = {1,-2,2};
        ex3<Integer> instance = new ex3();
        
        for(int i :symetric)
            instance.insert(i);
        
        System.out.println(instance.toString());
        printResult(instance.isSymmetric());

        Integer[] assymmetric = {20,15,10,13,8,17,40,50,30,7};
        for(int i : assymmetric)
            instance.insert(i);
        
        System.out.println(instance.toString());
        printResult(instance.isSymmetric());
    }
    
    
    private static void printResult(boolean result) {
        if(result) {
            System.out.println("Tree is Symmetric.");
        } else {
            System.out.println("Tree is not Symmetric.");
        }
    }
}
