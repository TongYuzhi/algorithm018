import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jcp.xml.dsig.internal.MacOutputStream;

import jdk.internal.module.ModuleBootstrap;
import sun.security.provider.DomainKeyStore.DKS;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache extends LinkedHashMap<Integer, Integer> {

    private static final long serialVersionUID = 1L;
    
    private int capacity;

	public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

/**
 * 
 * class LRUCache {

   class DLinkedNode {
       int key;
       int val;
       DLinkedNode prev;
       DLinkedNode next;

       DLinkedNode() {}

       DLinkedNode(int key, int val) {
           this.key = key;
           this.val = val;
       }
   }

   private int size;
   private int capacity;
   private DLinkedNode head;
   private DLinkedNode tail;
   private Map<Integer, DLinkedNode> cache;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.cache = new HashMap<>();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode end = this.tail.prev;
        removeNode(end);
        return end;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    
    public int get(int key) {
        DLinkedNode node = this.cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = this.cache.get(key);

        if (node == null) {
            node = new DLinkedNode(key, value);
            this.size++;
            this.cache.put(key, node);
            addToHead(node);

            if (this.size > this.capacity) {
                DLinkedNode tail = removeTail();
                this.cache.remove(tail.key);
                this.size--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }
}
 */

 /**
  * 
  class LRUCache extends LinkedHashMap<Integer, Integer> {

    private static final long serialVersionUID = 1L;
    
    private int capacity;

	public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
  */