class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int val: nums){
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }

        ArrayList<Integer> bucket[] = new ArrayList[nums.length+1];
        for(int key: countMap.keySet()){
            int freq = countMap.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        
        int res[] = new int[k];
        for(int i=nums.length;i>=0 && k>0;i--){
            if(bucket[i] != null){
                for(int val: bucket[i]){
                    res[res.length-k] = val;
                    k--;
                }
            }
        }

        return res;
    }
}
