package nowcoder.nc0088_top_k;

public class TopK {
  public int findKth(int[] a, int n, int K) {
    dfs(a, 0, n - 1, K);
    return a[n - K];
  }

  private void dfs(int[] a, int i, int j, int K){
    int p = partition(a, i, j);
    int index = a.length - K;
    if(p == index){
      return;
    } else if(p < index){
      dfs(a, p + 1, j, K);
    } else {
      dfs(a, i, p - 1, K);
    }
  }

  private int partition(int[] a, int i, int j){
    int tmp = a[i];
    while(i < j){
      while(i < j && a[j] >= tmp){
        j--;
      }
      a[i] = a[j];
      while(i < j && a[i] <= tmp){
        i++;
      }
      a[j] = a[i];
    }
    a[i] = tmp;
    return i;
  }
}
