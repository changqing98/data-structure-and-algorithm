public class FindNumberIn2DArray {
  public boolean findNumberIn2DArray(int target, int[][] array) {
    int x = 0;
    int y = array[0].length - 1;
    while (x < array.length && y >= 0) {
      if (target < array[x][y]) {
        y--;
      } else if (target > array[x][y]) {
        x++;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] array = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    FindNumberIn2DArray test = new FindNumberIn2DArray();
    System.out.println(test.findNumberIn2DArray(20, array));
  }
}
