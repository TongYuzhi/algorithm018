/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    private int capacity;
    private int size;
    private Node head;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.size >= capacity) {
            return false;
        }
        if (head == null) {
            head = new Node(value);
        } else if (head.pre != null) {
                Node node = new Node(value, head.pre, head);
                head.pre.next = node;
                head.pre = node;
                head = node;
        } else { //only have one node in the list
            Node newNode = new Node(value, head, head);
            head.pre = newNode;
            head.next = newNode;
            head = newNode;
        }
        this.size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.size >= capacity) {
            return false;
        }
        if (head == null) {
            head = new Node(value);
        } else if (head.pre != null) {
            Node node = new Node(value, head.pre, head);
            head.pre.next = node;
            head.pre = node;
        } else {
            Node node = new Node(value, head, head);
            head.next = node;
            head.pre = node;
        }
        this.size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.size <= 0 || head == null) {
            return false;
        }
        if (head.pre != null) {
            head.pre.next = head.next;
            head.next.pre = head.pre;
        }
        if (head == head.next) {
            head = null;
        } else {
            head = head.next;
        }
        this.size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.size <= 0 || head == null) {
            return false;
        }
        if (head.next == null || head.next == head) {
            head = null;
        } else {
            head.pre.pre.next = head;
            head.pre = head.pre.pre;
        }
        this.size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (this.size <= 0) {
            return -1;
        }
        return head.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (this.size <= 0 || head == null) {
            return -1;
        }
        if (head.pre != null) {
            return head.pre.value;
        } else {
            return head.value;
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size <= 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size >= this.capacity;
    }

    class Node {
        private int value;
        private Node pre;
        private Node next;

        Node(int value) {
            this.value = value;
            this.pre = null;
            this.next = null;
        }

        Node(int value, Node pre) {
            this.value = value;
            this.pre = pre;
            this.next = null;
        }

        Node(int value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
}
//It's not clean enough,but I think my code is easy to read

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

