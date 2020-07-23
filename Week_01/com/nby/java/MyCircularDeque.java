/**
 * @author nanbeiyang
 * @version MyCircularDeque.java, v 0.1 2020/7/23 11:43 上午  Exp $$
 * @name
 */
public class MyCircularDeque {
    private int size = 0;
    private int maxSize;
    private Node first;
    private Node tail;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        maxSize = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node f = first;
        Node newNode = new Node(value, null, first);
        if (f == null) {
            tail = newNode;
        } else {
            f.pre = newNode;
        }
        first = newNode;
        size ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node l = tail;
        Node newNode = new Node(value, tail, null);
        if (l == null) {
            first = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;

        size ++;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (first == tail) {
            first = null;
            tail = null;
        } else {
            Node oldNode = first;
            first = first.next;
            first.pre = null;
            oldNode.next = null;
        }
        size --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (first == tail) {
            first = null;
            tail = null;
        } else {
            Node oldNode = tail;
            tail = tail.pre;
            tail.next = null;
            oldNode.pre = null;
        }
        size --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return first.val;

    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }

    class Node {
        int val;
        Node pre;
        Node next;
        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
