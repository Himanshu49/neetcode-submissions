class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, local = 0;
        for(int val: nums){
            if(local<0)
                local = 0;
            local+=val;
            res = Math.max(res, local);
        }
        return res;
    }
}
