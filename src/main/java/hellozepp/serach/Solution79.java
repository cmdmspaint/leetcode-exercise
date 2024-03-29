package hellozepp.serach;


/**
 * board 由多个字符组成
 * 搜索word 是否存在与 board
 * 只能搜索相邻的字符 不可重复使用
 *
 * For example,
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 *
 * 难度2.5星
 */
public class Solution79 {
    private static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0
                || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (search(board, word, index + 1, i - 1, j) ||
                search(board, word, index + 1, i + 1, j) ||
                search(board, word, index + 1, i, j - 1) ||
                search(board, word, index + 1, i, j + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}