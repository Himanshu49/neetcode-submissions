class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int global = 0, local =0;
        for(int num: nums){
            set.add(num);
        }
        for(int num: nums){
            if(set.contains(num-1))
                continue;
            else{
                local = 1;
                while(set.contains(num+1)){
                    local++;
                    num++;
                }
                global = Math.max(local, global);
            }
        }
        return global;
    }
}
