class Solution {
    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxRobbery(nums, 0);
    }

    public int maxRobbery(int[] nums, int pos){
        if(pos >= nums.length)
            return 0;
        
        if(dp[pos] == -1){
            // rob current how and skip next one
            int rob = maxRobbery(nums, pos+2)+nums[pos];

            // skip current
            int skip = maxRobbery(nums, pos+1);
            dp[pos] = Math.max(rob, skip);
        }

        return dp[pos];
    }
}
