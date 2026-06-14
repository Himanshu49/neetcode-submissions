class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i=0;
        Arrays.sort(nums);
        while(i<nums.length-1){
            if(i>0 && nums[i] == nums[i-1])
                i++;
            else{
                int l=i+1,r=nums.length-1;
                while(l<r){
                    if(nums[r]+nums[l]+nums[i] == 0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        temp.add(nums[i]);
                        res.add(temp);
                        l++;
                        while(l<r && nums[l] == nums[l-1])
                            l++;
                    }
                    else if(nums[r]+nums[l]+nums[i] > 0){
                        r--;
                    }
                    else
                        l++;
                }
                i++;
            }
        }
        return res;
    }
}
