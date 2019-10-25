import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  ); // capacity 

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

 //****************** */ Implementation with builtin LinkedHashMap
 // OR 1. IN-BUILD LRU:
 /*
    class LRUCache extends LinkedHashMap<Integer, Integer>{
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
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}
*/
// 2. LinkedHashMap
class LRUCacheLLHM{
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {

        cache = new LinkedHashMap<Integer, Integer>(capacity){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
        
        
    }
    
    public int get(int key) {
        int val = cache.getOrDefault(key, -1);
        if(val != -1){
            cache.remove(key);
            cache.put(key, val);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCacheLLHM cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}

 //******************   Implementation with DoublyLL + HashMap

class LRUCache{

    class DListNode{ // Duubly linked list
        int key, val;
        DListNode prev, next;
    }
    private DListNode head, tail;
    private int cap;
    private Map<Integer, DListNode> hm = new HashMap<>();
    
    //DLinkedList related operations
    private void addNode(DListNode node) {
        node.prev = head.prev;
        head.prev.next = node;
        node.next = head;
        head.prev = node;
    }

    private void removeNode(DListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DListNode node){
        removeNode(node);
        addNode(node);
    }

    private DListNode removeTailNode(){
        if(!(tail.next == head)){
            DListNode LastNode = tail.next;
            removeNode(tail.next);
            return LastNode;            
        }
        return null;
    }

    public LRUCache(int capacity) {
        cap = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = null;
        head.prev = tail;
        tail.next = head;
        tail.prev = null;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            DListNode node = hm.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {  
        DListNode node = hm.get(key);
        if(node != null){ // update value and move to head
            node.val = value; 
            moveToHead(node);            
        }
        else{   // insert new node to head
            node = new DListNode();
            node.key = key; 
            node.val = value;
            hm.put(key, node);
            addNode(node);
        }
        
        if(hm.size() > cap){            
            DListNode tailNode = removeTailNode();
            hm.remove(tailNode.key);
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}


