class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums)
        {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] countList = new ArrayList[nums.length+1];

        for(Map.Entry<Integer, Integer> curr: countMap.entrySet()){
            if(countList[curr.getValue()] == null){
                countList[curr.getValue()] = new ArrayList<>();
            }
            countList[curr.getValue()].add(curr.getKey());
        }

        int res[] = new int[k];
        for(int i=nums.length, pos=0;i>=0;i--){
            if(countList[i] != null){
                ArrayList<Integer> curr= countList[i];
                for(int val: curr){
                    res[pos] = val;
                    pos++;
                    if(pos == k)
                        return res;
                }
            }
        }
        return res;
    }
}
