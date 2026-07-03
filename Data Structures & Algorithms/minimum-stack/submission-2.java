class MinStack {
    public class Node{
        int val;
        Node next;
        Node prev;
        public Node(int v, Node n, Node p){
            val = v;
            next = n;
            prev = p;
        }
    }
    private PriorityQueue<Integer> minHeap;
    private Node start;
    private Node end;
    public MinStack() {
        start = null;
        end = null;
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        if(end == null){
            start = new Node(val,null,null);
            end = start;
        }
        else{
            end.next = new Node(val, null, null);
            end.next.prev = end;
            end = end.next;
        }
        minHeap.add(val);
    }
    
    public void pop() {
        int val = end.val;
        end = end.prev;
        if(end!=null)
            end.next = null;
        minHeap.remove(val);
    }
    
    public int top() {
        return end.val;
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}
