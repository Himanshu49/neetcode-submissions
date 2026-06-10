class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean temp[] = new boolean[10];
            boolean temp2[] = new boolean[10];
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){    
                    if(temp[board[i][j]-'0'])
                        return false;
                    temp[board[i][j]-'0'] = true;
                }
                if(board[j][i] != '.'){    
                    if(temp2[board[j][i]-'0'])
                        return false;
                    temp2[board[j][i]-'0'] = true;
                }
            }
        }
        
        int val[] = {0,3,6};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!isValidSquare(board,val[i],val[j]))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSquare(char[][] board, int r, int c)
    {
        boolean temp[] = new boolean[10];
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j] == '.')
                    continue;
                if(temp[board[i][j]-'0'])
                    return false;
                temp[board[i][j]-'0'] = true;
            }
        }
        return true;
    }
}
