class Solution {
    HashMap<String, Boolean> map;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val: nums)
            sum+=val;
        
        if(sum%2 != 0)
            return false;
        
        map = new HashMap<>();
        return subsetPossible(nums, sum/2, nums.length-1);
    }

    public boolean subsetPossible(int[] nums, int sum, int n){
        if(n == 0)
            return sum == 0;
        if(map.containsKey(sum+" "+n))
            return map.get(sum+" "+n);
        boolean included = subsetPossible(nums, sum-nums[n], n-1);
        boolean excluded = subsetPossible(nums, sum, n-1);
        map.put((sum+" "+n), included || excluded);
        return  included || excluded;
    }
}
