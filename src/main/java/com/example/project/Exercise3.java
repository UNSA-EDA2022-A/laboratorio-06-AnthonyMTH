package com.example.project;

public class Exercise3 {

    public static void main(String[] args) {
        Exercise3 obj = new Exercise3();

        BST<Integer> tree = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree.insert(value);
        }

        System.out.print(obj.bstEstrictamenteBinario(tree));
        
    }


    public <T extends Comparable<T>> boolean bstEstrictamenteBinario(BST<T> a){
        for (Node<T> auxNode = a.root; auxNode != null; auxNode = auxNode.left) {
            if (auxNode.left == null && auxNode.right != null
             || auxNode.left != null && auxNode.right == null) {
                return false;
            }
        }
        for (Node<T> auxNode = a.root; auxNode != null; auxNode = auxNode.right) {
            if (auxNode.left == null && auxNode.right != null
             || auxNode.left != null && auxNode.right == null) {
                return false;
            }
        }
        return true;
    }
}
