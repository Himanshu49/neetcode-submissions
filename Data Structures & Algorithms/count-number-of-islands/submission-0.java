class Solution {
    int row ,col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        int islands= 0;
        col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int i, int j, char[][] grid){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] != '1')
            return;
        
        grid[i][j] = '2';
        dfs(i+1,j, grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
