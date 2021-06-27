import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegress = new int[numCourses];
    List<List<Integer>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adjacencyList.add(new ArrayList());
    }
    for (int[] item : prerequisites) {
      indegress[item[1]]++;
      adjacencyList.get(item[0]).add(item[1]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegress[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int removed = queue.poll();
      numCourses--;
      for (int course : adjacencyList.get(removed)) {
        if (--indegress[course] == 0) {
          queue.add(course);
        }
      }
    }
    return numCourses == 0;
  }
}
