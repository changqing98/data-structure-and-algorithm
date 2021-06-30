package nowcoder.nc0093_lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
  public int[] LRU(int[][] operators, int k) {
    LRU lru = new LRU(k);
    List<Integer> result = new ArrayList<>();
    for (int[] i : operators) {
      if (i[0] == 1) {
        lru.put(i[1], i[2]);
      } else {
        result.add(lru.get(i[1]));
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }


  static class LRU {
    private int capacity;
    private Map<Integer, Node> map;
    private int size;
    private Node head;
    private Node tail;

    public LRU(int capacity) {
      this.capacity = capacity;
      this.map = new HashMap<>();
    }

    public int get(int key) {
      Node node = map.get(key);
      if (node == null) {
        return -1;
      }
      moveToHead(node);
      return node.value;
    }

    public void put(int key, int value) {
      Node node = map.get(key);
      if (node != null) {
        node.value = value;
        moveToHead((node));
      } else {
        node = new Node(key, value);
        map.put(key, node);
        addToHead(node);
        if (size > capacity) {
          Node removed = removeTail();
          map.remove(removed.key);
        }
      }
    }


    private void moveToHead(Node node) {
      if (head == node) {
        return;
      }
      if (node == tail) {
        tail = node.pre;
        tail.next = null;
      } else {
        node.pre.next = node.next;
        node.next.pre = node.pre;
      }
      node.next = head;
      head.pre = node;
      node.pre = null;
      head = node;
    }

    private Node removeTail() {
      Node removed = tail;
      if (head == tail) {
        head = null;
        tail = null;
      } else {
        Node pre = tail.pre;
        pre.next = null;
        tail = pre;
      }
      size--;
      return removed;
    }


    private void addToHead(Node node) {
      if (head == null) {
        head = node;
        tail = node;
      } else {
        node.next = head;
        head.pre = node;
        head = node;
      }
      size++;
    }

    private static class Node {
      int key;
      int value;
      Node pre;
      Node next;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }

}
