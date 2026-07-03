class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int heapSize, globalK;
    public KthLargest(int k, int[] nums) {
        heapSize = 0;
        globalK = k;
        for(int val: nums){
            add(val);
        }
    }
    
    public int add(int val) {
        if(heapSize < globalK){
            heapSize++;
            minHeap.add(val);
        }
        else if(val > minHeap.peek()){
            minHeap.remove();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
