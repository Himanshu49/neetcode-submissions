class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int l=i+1, r = nums.length-1;
            while(l<r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    // add to result
                    List<Integer> currRes = new ArrayList<>();
                    currRes.add(nums[i]);
                    currRes.add(nums[l]);
                    currRes.add(nums[r]);
                    res.add(currRes);

                    l++;
                    // skip all l while they are same
                    while(l<r && nums[l] == nums[l-1])
                        l++;
                }
                else if(nums[i]+nums[l]+nums[r] < 0){
                    l++;
                }
                else{
                    r--;
                }
            }

            // skip all i while they are same as we already checked those
            while(i<nums.length-1 && nums[i] == nums[i+1])
                i++;
        }
        return res;
    }
}
