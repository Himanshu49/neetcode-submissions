class Solution {
    int visited[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val: nums)
            sum+=val;
        
        if(sum%2 != 0)
            return false;
        
        visited = new int[sum][nums.length];
        return subsetPossible(nums, sum/2, nums.length-1);
    }

    public boolean subsetPossible(int[] nums, int sum, int n){
        if (sum == 0)
            return true;
        if(n < 0)
            return false;
        if(visited[sum][n] != 0)
            return visited[sum][n] == 1;
        boolean included = false;
        if(sum-nums[n] >= 0)
            included = subsetPossible(nums, sum-nums[n], n-1);
        boolean excluded = subsetPossible(nums, sum, n-1);
        visited[sum][n] = included||excluded ? 1: -1;
        return  included || excluded;
    }
}
