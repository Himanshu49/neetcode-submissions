class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int l = 0, r=nums[0], steps=1, maxJump = nums[0];
        while(r < nums.length-1){
            for(int i=l;i<=r;i++){
                maxJump = Math.max(maxJump, nums[i]+i);
            }
            l=r+1;
            r=maxJump;
            steps++;
        }

        return steps;
    }
}
