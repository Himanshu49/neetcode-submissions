class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        Integer[] pos = {nums[i], nums[j], nums[k]};
                        Arrays.sort(pos);
                        if(visited.contains(pos[0]+" "+pos[1]+" "+pos[2]))
                            continue;
                        visited.add(pos[0]+" "+pos[1]+" "+pos[2]);
                        result.add(Arrays.asList(pos));
                    }
                }
            }
        }
        return result;
    }
}
