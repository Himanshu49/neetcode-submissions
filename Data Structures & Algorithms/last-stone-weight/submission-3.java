class Solution {
    int dp[][];
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int val: stones){
            heap.add(val);
        }

        while(heap.size() > 1){
            int res = heap.poll() - heap.poll();
            heap.add(res);
        }

        if(heap.size() == 0)
            return 0;
        return heap.poll();
    }
}
