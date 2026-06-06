class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int val: gifts)
            maxHeap.add(val);
        
        for(int i=0;i<k;i++)
        {
            int curr = maxHeap.poll();
            int remaining = (int)Math.sqrt(curr);

            maxHeap.add(remaining);
        }
        long res = 0;
        while(!maxHeap.isEmpty())
        {
            res+=maxHeap.poll();
        }
        return res;
    }
}