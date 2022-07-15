package com.company.datastructures.stacksQueues;

public class StackImplementation {
    public static void main(String[] args){
        StackArray s = new StackArray();
        s.push(10);
        s.push(30);
        s.push(45);
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.peek() + " peek of the stack");

        StackLinkedList sl = new StackLinkedList();
        sl.push(10);
        sl.push(40);
        sl.push(80);
        System.out.println(sl.pop() + " popped from stack");
        System.out.println(sl.peek() + " peek of the stack");

    }
}
class StackArray {
    static final int MAX = 1000;
    int top;
    int arrayStack[] = new int[MAX];

    StackArray(){
        top = -1;
    }
    boolean isEmpty(){
        return (top < 0);
    }
    boolean push(int element){
        if(top >= (MAX-1)){
            System.out.println("stack overflow");
            return false;
        }else{
            arrayStack[++top] = element;
            System.out.println(element + " pushed to stack");
            return true;
        }
    }
    int pop(){
        if(top < 0){
            System.out.println("stack underflow");
            return 0;
        }else{
            return arrayStack[top--];
        }
    }
    int peek(){
        if(top < 0){
            System.out.println("stack underflow");
            return 0;
        }else{
            return arrayStack[top];
        }
    }
}
class StackLinkedList {
    StackNode root;

    static class StackNode {
        int data;
        StackNode next;
        StackNode(int data){
            this.data = data;
        }
    }

    public boolean isEmpty(){
        if(root == null)
            return true;
        else
            return false;
    }
    public void push(int data){
        StackNode node = new StackNode(data);
        if(root == null)
            root = node;
        else{
            StackNode temp = root;
            root = node;
            node.next =temp;
        }
        System.out.println(data + " pushed to stack");
    }
    public int pop(){
        int popped = Integer.MIN_VALUE;
        if(root == null)
            System.out.println("stack is empty");
        else {
            popped = root.data;
            root = root.next;
        }
        return popped;
    }
    public int peek(){
        if(root == null){
            System.out.println("stack is empty");
            return Integer.MIN_VALUE;
        }else{
            return root.data;
        }

    }
}
