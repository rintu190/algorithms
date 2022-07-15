package com.company.datastructures.stacksQueues;

public class QueueImplementation {
    public static void main(String[] args){
        QueueArray queueArray = new QueueArray(100);     // array implementation

        queueArray.enQueue(10);
        queueArray.enQueue(20);
        queueArray.enQueue(30);
        queueArray.enQueue(40);

        System.out.println(queueArray.deQueue() + " dequeued\n");
        System.out.println("Front item is " + queueArray.front());
        System.out.println("Rear item is "  + queueArray.rear());

        QueueLinkedList queueLinked = new QueueLinkedList();    // linked list Implementation

        queueLinked.enQueue(10);
        queueLinked.enQueue(20);
        queueLinked.deQueue();
        queueLinked.deQueue();
        queueLinked.enQueue(30);
        queueLinked.enQueue(40);
        queueLinked.enQueue(50);
        queueLinked.deQueue();

        System.out.println("Queue Front : " + queueLinked.front.key);
        System.out.println("Queue Rear : " + queueLinked.rear.key);
    }
}
class QueueArray{
    int front, rear, size;
    int capacity;
    int array[];

    public QueueArray(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }
    boolean isFull(QueueArray queue){
        return (queue.size == queue.capacity);
    }
    boolean isEmpty(QueueArray queue){
        return (queue.size == 0);
    }
    int front(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        return this.array[this.front];
    }
    int rear(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        return this.array[this.rear];
    }
    void enQueue(int item){
        if(isFull(this))
            return;
        rear = (this.rear +1) % capacity;
        array[rear] = item;
        size = size+1;
        System.out.println(item + " enqueued");
    }
    int deQueue(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        int item = array[front];
        front = (front+1) % capacity;
        size = size - 1;
        return item;
    }
}
class QueueLinkedList {
    class QNode {
        int key;
        QNode next;

        public QNode(int key){
            this.key= key;
            this.next =null;
        }
    }
    QNode front, rear;
    public QueueLinkedList(){
        front = rear = null;
    }
    void enQueue(int key){
        QNode tempNode = new QNode(key);
        if(rear == null)
            front = rear = tempNode;
        rear.next = tempNode;
        rear = tempNode;
    }
    void deQueue(){
        if(front == null)
            return;
        QNode tempNode = front;
        front = front.next;

        if(front == null)
            rear =null;
    }

}
