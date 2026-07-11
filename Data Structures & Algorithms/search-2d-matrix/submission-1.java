class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row= matrix.length, col = matrix[0].length;
        // binary search the row to find target in

        int l=0, r=row-1, mid =0;
        while(l<=r){
            mid = (l+r)/2;
            if(matrix[mid][0] == target)
                return true;
            
            if(matrix[mid][0] > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        if(matrix[mid][0] > target){
            mid--;
        }

        if(mid < 0)
            return false;
        int rowToSearch = mid;
        l=0;
        r=col-1;
        while(l<=r){
            mid = (l+r)/2;
            if(matrix[rowToSearch][mid] == target)
                return true;
            
            if(matrix[rowToSearch][mid] < target)
                l = mid+1;
            else{
                r = mid-1;
            }
        }
        return false;
    }
}
