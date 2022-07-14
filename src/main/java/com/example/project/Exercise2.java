package com.example.project;

public class Exercise2 {

    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstIguales(tree1, tree2));
        
    }


    public <T extends Comparable<T>> boolean bstIguales(BST<T> a1, BST<T> a2){
        int equalsLeft = 0;
        int equalsRight = 0;
        Node<T> auxNode = a1.root, auxNode2 = a2.root;
        if (auxNode != null && auxNode2 != null) {
            for (; auxNode != null ||
                    auxNode2 != null; auxNode = auxNode.left, auxNode2 = auxNode2.left) {
                    if (auxNode.data.compareTo(auxNode2.data) != 0) return false;
                    if (auxNode.left == null && auxNode2.left != null
                    || auxNode.right != null && auxNode2.right == null) {
                    return false;
                }
                if (auxNode.left == null && auxNode2.left == null
                    || auxNode.right == null && auxNode2.right == null) continue;
                equalsLeft = auxNode.left.data.compareTo(auxNode2.left.data);
                equalsRight = auxNode.right.data.compareTo(auxNode2.right.data);
                if (equalsLeft != 0 || equalsRight != 0) return false;
            }

            auxNode = a1.root; 
            auxNode2 = a2.root;
            for (; auxNode != null ||
                    auxNode2 != null; auxNode = auxNode.right, auxNode2 = auxNode2.right) {
                if (auxNode.data.compareTo(auxNode2.data) != 0) return false; 
                if (auxNode.left == null && auxNode2.left != null
                    || auxNode.right != null && auxNode2.right == null) {
                    return false;
                }
                if (auxNode.left == null && auxNode2.left == null
                    || auxNode.right == null && auxNode2.right == null) continue;
                equalsLeft = auxNode.left.data.compareTo(auxNode2.left.data);
                equalsRight = auxNode.right.data.compareTo(auxNode2.right.data);
                if (equalsLeft != 0 || equalsRight != 0) return false;
            }
            return true;
        } else if (auxNode == null && auxNode2 == null) return true;
        return false;
    }
}
