#### [79. 单词搜索](https://leetcode-cn.com/problems/word-search/)

难度中等893

给定一个 `m x n` 二维字符网格 `board` 和一个字符串单词 `word` 。如果 `word` 存在于网格中，返回 `true` ；否则，返回 `false` 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/11/04/word2.jpg)

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg)

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true
```

**示例 3：**

![img](https://assets.leetcode.com/uploads/2020/10/15/word3.jpg)

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false
```



**提示：**

-   `m == board.length`
-   `n = board[i].length`
-   `1 <= m, n <= 6`
-   `1 <= word.length <= 15`
-   `board` 和 `word` 仅由大小写英文字母组成



## 题解

### DFS + 回溯

```java
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, 0, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int k, String word, int i, int j) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '-';
        boolean result = dfs(board, k + 1, word, i + 1, j) || dfs(board, k + 1, word, i - 1, j)
                || dfs(board, k + 1, word, i, j + 1) || dfs(board, k + 1, word, i, j - 1);
        board[i][j] = tmp;
        return result;
    }
}
```
