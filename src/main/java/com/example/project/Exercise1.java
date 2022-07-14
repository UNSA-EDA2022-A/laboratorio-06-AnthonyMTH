package com.example.project;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstSimilares(tree1, tree2));
        
    }


    public <T extends Comparable<T>> boolean bstSimilares(BST<T> a1, BST<T> a2){
        Node<T> auxNode = a1.root, auxNode2 = a2.root;
        for (; auxNode != null || auxNode2 != null; auxNode = auxNode.left, auxNode2 = auxNode2.left) {
            if (auxNode.left == null && auxNode2.left != null
            || auxNode.right != null && auxNode2.right == null) {
                return false;
            }
        }

        auxNode = a1.root; 
        auxNode2 = a2.root;
        for (; auxNode != null || auxNode2 != null; auxNode = auxNode.right, auxNode2 = auxNode2.right) {
            if (auxNode.left == null && auxNode2.left != null
            || auxNode.right != null && auxNode2.right == null) {
                return false;
            }
        }
        if (auxNode == null && auxNode2 == null) return true;
        return false;
    }
}
