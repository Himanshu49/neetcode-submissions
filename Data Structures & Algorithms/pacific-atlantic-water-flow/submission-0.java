class Solution {
    private record Location(int r, int c){}
    HashSet<Location> visited;
    HashSet<Location> reachablePacific;
    HashSet<Location> reachableAtlantic;
    int rows, cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        visited = new HashSet<>();
        reachablePacific = new HashSet<>();
        reachableAtlantic = new HashSet<>();

        // Initialize
        for(int i = 0;i<rows;i++){
            reachablePacific.add(new Location(i,0));
            reachableAtlantic.add(new Location(i, cols-1));
        }

        for(int i = 0;i<cols;i++){
            reachablePacific.add(new Location(0,i));
            reachableAtlantic.add(new Location(rows-1, i));
        }


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(heights, i, j);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Location currLoc = new Location(i,j);
                if(reachableAtlantic.contains(currLoc) && reachablePacific.contains(currLoc)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(currLoc.r);
                    temp.add(currLoc.c);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int currRow, int currCol){
        if(currRow <0 || currRow>=rows || currCol<0 || currCol>=cols){
            return;
        }

        if(visited.contains(new Location(currRow, currCol))){
            return;
        }

        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int dir[]: directions){
            // can i go to next tile
            if(currRow+dir[0] <0 || currRow+dir[0]>=rows || currCol+dir[1]<0 || currCol+dir[1]>=cols){
                continue;
            }
            if(heights[currRow][currCol] < heights[currRow+dir[0]][currCol+dir[1]]){
                continue;
            }

            visited.add(new Location(currRow, currCol));
            dfs(heights, currRow+dir[0], currCol+dir[1]);

            Location nextTile = new Location(currRow+dir[0], currCol+dir[1]);
            // check if next item is top-left boundary
            // if yes then curr can go pacific
            if(reachablePacific.contains(nextTile)){
                reachablePacific.add(new Location(currRow, currCol));
            }

            // check if next item is bottom-right boundary
            // if yes then curr can go atlantic
            if(reachableAtlantic.contains(nextTile)){
                reachableAtlantic.add(new Location(currRow, currCol));
            }
        }
    }
}
