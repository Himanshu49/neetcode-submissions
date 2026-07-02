class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for(int val: nums){
            res = addToRes(val, res);
        }
        return res;
    }

    public List<List<Integer>> addToRes(int val, List<List<Integer>> res){
        List<List<Integer>> newRes = new ArrayList<>();
        for(List<Integer> curr: res){
            // include
            List<Integer> newCurr =new ArrayList<>(curr);
            newCurr.add(val);

            newRes.add(newCurr);
            // add initial unchanged arraylist
            newRes.add(curr);
        }
        return newRes;
    }
}
