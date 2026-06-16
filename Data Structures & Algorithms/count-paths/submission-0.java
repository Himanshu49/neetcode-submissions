class Solution {
    int ways[][] = new int[100][100];
    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1)
            return 0;
        if(m == 1 && n == 1)
            return 1;
        if(ways[m][n] == 0){
            int left = uniquePaths(m,n-1);
            int up = uniquePaths(m-1, n);
            ways[m][n] = left+up;
        }
        return ways[m][n];
    }
}
