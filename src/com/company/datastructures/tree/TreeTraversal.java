package com.company.datastructures.tree;

public class TreeTraversal {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOder(tree.root);

        System.out.println( "\nPostorder traversal of binary tree is ");
        tree.printPostOrder(tree.root);
    }
}
class Node {
    int key;
    Node left, right;

    public Node(int item){
        key = item;
        left = right = null;
    }
}
class BinaryTree{
    Node root;
    BinaryTree() {
        root = null;
    }
    void printPreOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.key +" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    void printInOder(Node node){
        if(node == null)
            return;
        printInOder(node.left);
        System.out.println(node.key+" ");
        printInOder(node.right);
    }
    void printPostOrder(Node node){
        if(node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.key +" ");
    }
}
