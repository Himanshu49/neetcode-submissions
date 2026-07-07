class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for(int i=0;i<rows/2;i++){
            for(int j=i;j<cols-i-1;j++){
                // rotate;
                int temp = matrix[rows-j-1][i];
                matrix[rows-j-1][i] = matrix[rows-i-1][cols-j-1];
                matrix[rows-i-1][cols-j-1] = matrix[j][cols-i-1];
                matrix[j][cols-i-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
