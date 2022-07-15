package com.company.datastructures.tree;

public class TreeRepresentation {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.setRoot("A");
        tree.setRight("C", 0);
        tree.setLeft("D",1);
        tree.setRight("E",1);
        tree.setLeft("F",2);
        tree.printTree();
    }
}
class Tree {
    String[] str = new String[10];

    public void setRoot(String key){
        str[0] = key;
    }
    public void setLeft(String key, int root){
        int index = (root * 2) + 1;
        if(str[root] == null){
            System.out.println("cant set child " + index);
        }
        str[index] = key;
    }
    public void setRight(String key, int root){
        int index = (root * 2) + 2;
        if(str[root] == null){
            System.out.println("cant set child " + index);
        }
        str[index] = key;
    }
    public void printTree(){
        for(int i=0; i< 10;i++){
            if(str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");
        }
    }
}
