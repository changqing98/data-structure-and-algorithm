#### [295. 数据流的中位数](https://leetcode-cn.com/problems/find-median-from-data-stream/)

#### [剑指 Offer 41. 数据流中的中位数](https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/)

中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

-   void addNum(int num) - 从数据流中添加一个整数到数据结构中。
-   double findMedian() - 返回目前所有元素的中位数。

**示例：**

```
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
```

**进阶:**

1.  如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
2.  如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？



## 题解

### 双堆法

1.  建立两个堆，一个大顶堆，一个小顶堆

2.  数据先经过大顶堆，在流向小顶堆，如果是数据流总数为奇数的话，保证大顶堆个数比小顶堆多一个

3.  如果数据流总数为奇数时，中位数即为大顶堆堆顶数值；

    反之为偶数时，则为大顶堆与小顶堆堆顶数值的平均数

```java
class MedianFinder {
    private int count = 0;
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>((x1, x2) -> x2 - x1);
    }
    
    public void addNum(int num) {
        count++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if((count & 1) == 1){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if((count & 1) == 1){
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
        }
    }

```

