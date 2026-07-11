class Solution {
    class Pair{
        int val;
        int freq;
        public Pair(int v, int f){
            val = v;
            freq = f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int val: nums){
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> 
        Integer.compare(b.freq, a.freq));

        for(int key: countMap.keySet()){
            pq.add(new Pair(key, countMap.get(key)));
        }

        int res[] = new int[k];
        while(k>0){
            res[k-1] = pq.poll().val;
            k--;
        }

        return res;
    }
}
