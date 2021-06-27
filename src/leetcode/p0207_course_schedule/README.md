#### [207. 课程表](https://leetcode-cn.com/problems/course-schedule/)



你这个学期必须选修 `numCourses` 门课程，记为 `0` 到 `numCourses - 1` 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 `prerequisites` 给出，其中 `prerequisites[i] = [ai, bi]` ，表示如果要学习课程 `ai` 则 **必须** 先学习课程 `bi` 。

-   例如，先修课程对 `[0, 1]` 表示：想要学习课程 `0` ，你需要先完成课程 `1` 。

请你判断是否可能完成所有课程的学习？如果可以，返回 `true` ；否则，返回 `false` 。

 

**示例 1：**

```
输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
```

**示例 2：**

```
输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
```

 

**提示：**

-   `1 <= numCourses <= 105`
-   `0 <= prerequisites.length <= 5000`
-   `prerequisites[i].length == 2`
-   `0 <= ai, bi < numCourses`
-   `prerequisites[i]` 中的所有课程对 **互不相同**



## 题解

可以将题目转化为判断图是否有环，基于拓扑排序实现。

## BFS

1.  首先统计每个节点的入度indegress
2.  统计出该图的邻接表adjacencyList
3.  将入度为0的结点依次加入队列
4.  遍历该队列依次删除结点，同时删除结点相邻的边（被删除结点相邻的结点入度-1），将新产生的入度为0的结点加入队列
5.  如果最后剩余结点数目为0证明无环，反之必定有环

```java
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjacencyList.add(new ArrayList());
        }
        for(int[] item : prerequisites){
            indegress[item[1]]++;
            adjacencyList.get(item[0]).add(item[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegress[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int removed = queue.poll();
            numCourses--;
            for(int course: adjacencyList.get(removed)){
                if(--indegress[course] == 0){
                    queue.add(course);
                }
            }
        }
        return numCourses == 0;
    }
```

