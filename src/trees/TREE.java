package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

/*
 * @author DEI-ESINF
 * @param <E>
 */
public class TREE<E extends Comparable<E>> extends BST<E> {

    /*
   * @param element A valid element within the tree
   * @return true if the element exists in tree false otherwise
     */
    public boolean contains(E element) {

        return find(root, element) != null;
    }

    public boolean isLeaf(E element) {
        Node<E> node = find(root, element);

        return node != null && node.getLeft() == null && node.getRight() == null;
    }

    /*
   * build a list with all elements of the tree. The elements in the 
   * left subtree in ascending order and the elements in the right subtree 
   * in descending order. 
   *
   * @return    returns a list with the elements of the left subtree 
   * in ascending order and the elements in the right subtree is descending order.
     */
    public Iterable<E> ascdes() {
        List<E> list = new LinkedList<>();

        ascSubtree(root.getLeft(), list);
        list.add(root.getElement());
        desSubtree(root.getRight(), list);

        return list;
    }

    private void ascSubtree(Node<E> node, List<E> snapshot) {
        if (node != null) {
            ascSubtree(node.getLeft(), snapshot);
            snapshot.add(node.getElement());
            ascSubtree(node.getRight(), snapshot);
        }
    }

    private void desSubtree(Node<E> node, List<E> snapshot) {
        if (node != null) {
            desSubtree(node.getRight(), snapshot);
            snapshot.add(node.getElement());
            desSubtree(node.getLeft(), snapshot);
        }
    }

    /**
     * Returns the tree without leaves.
     *
     * @return tree without leaves
     */
    public BST<E> autumnTree() {
        BST<E> tree = new TREE();

        tree.root = copyRec(root);

        return tree;
    }

    private Node<E> copyRec(Node<E> node) {
     
        Node<E> newNode = null;

        if (node != null && (node.getLeft() != null || node.getRight() != null)) {
            newNode = new Node(node.getElement(), copyRec(node.getLeft()), copyRec(node.getRight()));
        }

        return newNode;}

   
    /**
     * @return the the number of nodes by level.
     */
    public int[] numNodesByLevel()
    {
        int[] result = new int[this.height() + 1];
        numNodesByLevel(root, result, 0);

        return result;
    }

    private void numNodesByLevel(Node<E> node, int[] result, int level)
    {
        if (node == null)
        {
            return;
        }
        result[level]++;

        numNodesByLevel(node.getLeft(), result, level + 1);
        numNodesByLevel(node.getRight(), result, level + 1);
    }

    public List<E> topHalf()
    {
        List<E> lista = new ArrayList<>();
        Deque<Node<E>> q = new LinkedList<>();
        double halfSize = (double) size() / 2;

        q.offer(root);

        while (!q.isEmpty() && lista.size() < halfSize)
        {
            Node<E> n = q.poll();
            if (n != null)
            {
                lista.add(n.getElement());
                q.offer(n.getLeft());
                q.offer(n.getRight());
            }
        }

        Collections.sort(lista, Collections.reverseOrder());
        return lista;
    }
}
