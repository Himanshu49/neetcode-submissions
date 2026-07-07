class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int rob1 =0, rob2 =0, ans=0, first=nums[0];
        nums[0]= 0;
        for(int val:nums){
            int temp = Math.max(rob1+val, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        ans = rob2;
        nums[0] =  first;
        nums[nums.length-1] = 0;
        rob1 = 0;
        rob2 = 0;
        for(int val:nums){
            int temp = Math.max(rob1+val, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return Math.max(ans, rob2);
    }
}
