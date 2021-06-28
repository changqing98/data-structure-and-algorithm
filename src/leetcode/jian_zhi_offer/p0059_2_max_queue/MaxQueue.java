package leetcode.jian_zhi_offer.p0059_2_max_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
  private Queue<Integer> queue;
  private Deque<Integer> deque;

  public MaxQueue() {
    queue = new LinkedList<>();
    deque = new LinkedList<>();
  }

  public int max_value() {
    if (deque.isEmpty()) {
      return -1;
    }
    return deque.peekFirst();
  }

  public void push_back(int value) {
    while (!deque.isEmpty() && deque.peekLast() < value) {
      deque.pollLast();
    }
    deque.offerLast(value);
    queue.offer(value);
  }

  public int pop_front() {
    if (queue.isEmpty()) {
      return -1;
    }
    int result = queue.poll();
    if (deque.peekFirst() == result) {
      deque.pollFirst();
    }
    return result;
  }
}
