class MinStack {
    private Deque<Integer> stack;
    private PriorityQueue<Integer> minHeap;
    public MinStack() {
        stack = new ArrayDeque<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        minHeap.add(val);
    }
    
    public void pop() {
        int val = stack.removeLast();
        minHeap.remove(val);
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}
