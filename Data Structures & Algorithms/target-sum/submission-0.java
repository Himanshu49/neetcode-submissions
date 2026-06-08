class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int pos)
    {
        if(pos == nums.length)
        {
            return target == 0?1:0;
        }
        int ifCurrAdded = findTargetSumWays(nums, target+nums[pos], pos+1);
        int ifCurrSubtracted = findTargetSumWays(nums, target-nums[pos], pos+1);
        return ifCurrAdded+ifCurrSubtracted;
    }
}
