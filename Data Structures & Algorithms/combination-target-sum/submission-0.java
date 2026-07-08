class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        // List<List<Integer>> res = new ArrayList<>();
        // for(int val: nums){
        //     if(val>target){
        //         break;
        //     }

        //     if(val == target){
        //         ArrayList<Integer> curr = new ArrayList<>();
        //         curr.add(val);
        //         res.add(curr);
        //     }
        //     else{
        //         // include current element and check if possible to make 
        //         List<List<Integer>> curr = combinationSum(nums, target-val);
        //         if(curr != null || curr.size() != 0){
        //             for(List<Integer> temp: curr){
        //                 temp.add(val);
        //                 res.add(temp);
        //             }
        //         }
        //     }
        // }

        // return res;
        return combinationSum(nums, target, 0);
    }


    public List<List<Integer>> combinationSum(int[] nums, int target, int pos){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=pos;i<nums.length;i++){
            int val=nums[i];
            if(val>target){
                break;
            }

            if(val == target){
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(val);
                res.add(curr);
                return res;
            }
            else{
                // include current element and check if possible to make 
                List<List<Integer>> curr = combinationSum(nums, target-val, i);
                if(curr != null || curr.size() != 0){
                    for(List<Integer> temp: curr){
                        temp.add(val);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}
