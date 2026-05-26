class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(isPossible(board, used, word, "", 0, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean isPossible(char[][] board, boolean[][] used, String word, String curr, int currPos, int i, int j)
    {
        if(word.equals(curr))
            return true;
        
        if(i>=0 && j>=0 && i<board.length && j<board[0].length)
        {
            if(board[i][j] == word.charAt(currPos) && !used[i][j])
            {
                used[i][j] = true;
                boolean down = isPossible(board, used, word, curr+board[i][j], currPos+1, i+1, j);
                boolean right = isPossible(board, used, word, curr+board[i][j], currPos+1, i, j+1);
                boolean up = isPossible(board, used, word, curr+board[i][j], currPos+1, i-1, j);
                boolean left = isPossible(board, used, word, curr+board[i][j], currPos+1, i, j-1);
                used[i][j] = false;
                return (left || right || up || down);
            }
        }
        return false;
    }
}
