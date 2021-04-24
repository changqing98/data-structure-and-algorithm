public class EditDistance {
	// array[i][j] 表示 word[1...i] 与 字符串word2[1...j]的距离
	// word1[i] == word2[j] min(result[i-1][j-1], result[i-1][j] + 1, result[i][j-1] + 1)
	// word1[i] != word2[j] min(result[i-1][j-1] + 1, result[i-1][j] + 1, result[i][j-1] + 1)
gs
}
