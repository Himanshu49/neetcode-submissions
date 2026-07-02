class Solution {
    class Location{
        int r,c;
        public Location(int i, int j){
            r = i;
            c = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int min=-1, row = grid.length, col = grid[0].length;
        boolean flag=false;
        Queue<Location> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    flag = true;
                    queue.add(new Location(i,j));
                }
            }
        }

        while(queue.size()>0){
            int currentSize = queue.size();
            min++;
            while(currentSize > 0){
                Location curr = queue.remove();
                currentSize--;
                // add all neighbouring fruit since they are rotten next minute
                int directions[][] = {{0,1},{0,-1},{-1,0},{1,0}};
                for(int dir[]: directions){
                    if(curr.r+dir[0] >= 0 && curr.r+dir[0]<row && curr.c+dir[1]>=0 && curr.c+dir[1]<col && grid[curr.r+dir[0]][curr.c+dir[1]] == 1){
                        queue.add(new Location(curr.r+dir[0], curr.c+dir[1]));
                        grid[curr.r+dir[0]][curr.c+dir[1]] = 2;
                    }
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        if(!flag)
            return 0;
        return min;
    }
}
